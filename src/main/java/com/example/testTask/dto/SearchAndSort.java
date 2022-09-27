package com.example.testTask.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchAndSort {
    private Sort sort = new Sort();
    private String searchString = "";
    private Map<String, Object> searchList= new HashMap<>();

    private Pagination pagination = new Pagination();

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSearchList(Map<String, Object> searchList) {
        this.searchList = searchList;
    }

    public Map<String, Object> getSearchList() {
        return searchList;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchString() {
        return searchString;
    }
}
