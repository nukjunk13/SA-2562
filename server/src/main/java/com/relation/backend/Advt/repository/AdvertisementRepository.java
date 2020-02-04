package  com.relation.backend.Advt.repository;

import com.relation.backend.Advt.entity.Advertisement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}