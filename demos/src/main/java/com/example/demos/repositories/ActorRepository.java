package com.example.demos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demos.model.Actor;

@RepositoryRestResource(path="personas", itemResourceRel = "persona", collectionResourceRel="personas")
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
