package be.bnair.wiki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.bnair.wiki.models.entities.WikiEntity;

@Repository
public interface WikiRepository extends JpaRepository<WikiEntity, Long> {
}