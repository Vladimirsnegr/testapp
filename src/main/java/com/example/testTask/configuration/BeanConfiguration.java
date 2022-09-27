package com.example.testTask.configuration;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.rep.*;
import com.example.testTask.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeanConfiguration {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserServiceImpl userServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        return new UserServiceImpl(userRepository, new Specifications<>(), bCryptPasswordEncoder);
    }

    @Bean
    public OrganizationFormServiceImpl organizationFormService(OrganizationFormRepository organizationFormRepository) {
        return new OrganizationFormServiceImpl(organizationFormRepository, new Specifications<>());
    }

    @Bean
    public RoleServiceImpl roleService(RoleRepository roleRepository) {
        return new RoleServiceImpl(roleRepository, new Specifications<>());
    }

    @Bean
    public BankServiceImpl bankService(BankRepository bankRepository) {
        return new BankServiceImpl(bankRepository, new Specifications<>());
    }

    @Bean
    public ClientServiceImpl clientService(ClientRepository clientRepository) {
        return new ClientServiceImpl(clientRepository, new Specifications<>());
    }

    @Bean
    public DepositServiceImpl depositService(DepositRepository depositRepository) {
        return new DepositServiceImpl(depositRepository, new Specifications<>());
    }
}
