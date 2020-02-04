package  com.relation.backend.Advt.repository;

import com.relation.backend.Advt.entity.Sponsor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface SponsorRepository extends JpaRepository<Sponsor, Long> {
    Sponsor findById(long id);
}