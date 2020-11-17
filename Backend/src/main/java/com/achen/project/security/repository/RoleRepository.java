package com.achen.project.security.repository;


import com.achen.project.security.repository.entity.Role;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long>, QuerydslPredicateExecutor<Role> {
}
