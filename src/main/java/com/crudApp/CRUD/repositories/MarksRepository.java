package com.crudApp.CRUD.repositories;

import com.crudApp.CRUD.models.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository extends JpaRepository<Marks,Long> {
    
}
