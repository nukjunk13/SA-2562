package  com.relation.backend.Advt.repository;

import com.relation.backend.Advt.entity.Adtype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface AdtypeRepository extends JpaRepository<Adtype, Long> {
    Adtype findById(long id);
}