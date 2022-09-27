package com.example.testTask.Specification;

import com.example.testTask.dto.SearchAndSort;
import com.example.testTask.entity.GeneralEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;

public class Specifications<T> {

    private String getPersents(String inpString) {
        String outString = inpString;
        if (!inpString.contains("%")) {
            outString = "%" + inpString + "%";
        }
        return outString;
    }

    private Predicate getPredicate(Path path, Object value, CriteriaBuilder builder) {
        try {
            if (path.getJavaType().getSuperclass()==GeneralEntity.class) {
                Long searchLong = Long.parseLong(value.toString());
                return builder.in(path).value(searchLong);
            }
            if (path.getJavaType().getSuperclass()==Number.class) {
                if (path.getJavaType()==Long.class) {
                    return builder.in(path).value(Long.parseLong(value.toString()));
                }
                if (path.getJavaType()==Integer.class) {
                    return builder.in(path).value(Integer.parseInt(value.toString()));
                }
                if (path.getJavaType()==Float.class) {
                    return builder.in(path).value(Float.parseFloat(value.toString()));
                }
            }
            if (path.getJavaType()==LocalDate.class) {
                return builder.equal(path, LocalDate.parse(value.toString()));
            }
            if (path.getJavaType()==String.class) {
                return builder.like(path, getPersents(value.toString()));
            }
        }
        catch (Exception e) {
            return builder.disjunction();
        }
        return null;
    }

    public  Specification<T> containsTextInAttributes(SearchAndSort searchAndSort) {
        return (root, query, builder) -> {
            if (searchAndSort.getSort().getDirection().equals("DESC")) {
                query.orderBy(builder.desc(root.get(searchAndSort.getSort().getProperty())));
            }
            else {
                query.orderBy(builder.asc(root.get(searchAndSort.getSort().getProperty())));
            }
            return builder.and(
                    builder.or(
                            root.getModel().getAttributes()
                                    .stream()
                                    .map(a -> {
                                        String searchStr = searchAndSort.getSearchString();
                                        return getPredicate(root.get(a.getName()),searchStr,builder);
                                    })
                                    .toArray(Predicate[]::new)
                    ),
                    builder.and(
                            root.getModel().getAttributes()
                                    .stream()
                                    .filter(a -> searchAndSort.getSearchList().containsKey(a.getName()))
                                    .map(a -> {
                                        var value = searchAndSort.getSearchList().get(a.getName());
                                        return getPredicate(root.get(a.getName()),value,builder);
                                    })
                                    .toArray(Predicate[]::new)
                    )
            );
        };
    }
}
