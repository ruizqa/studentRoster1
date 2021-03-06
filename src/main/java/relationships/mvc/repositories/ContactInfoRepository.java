package relationships.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import relationships.mvc.models.ContactInfo;


@Repository
public interface ContactInfoRepository extends CrudRepository<ContactInfo, Long> {
    List<ContactInfo> findAll();
    Optional<ContactInfo> findById(Long id);
}
