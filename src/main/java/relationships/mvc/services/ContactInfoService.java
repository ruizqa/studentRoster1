package relationships.mvc.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import relationships.mvc.models.ContactInfo;
import relationships.mvc.models.Student;
import relationships.mvc.repositories.ContactInfoRepository;

@Service 
public class ContactInfoService {
private final ContactInfoRepository repo;

    public ContactInfoService(ContactInfoRepository repo) {
        this.repo = repo;
    }
 
    public List<ContactInfo> allLicenses() {
        return repo.findAll();
    }
    
    public ContactInfo createContactInfo(ContactInfo c) {
        return repo.save(c);
    }
    
    public ContactInfo findContactInfo(Long id) {
        Optional<ContactInfo> opCI = repo.findById(id);
        if(opCI.isPresent()) {
            return opCI.get();
        } else {
            return null;
        }
    }
    
    public ContactInfo updateContactInfo(Long id, String address, Student student, String city, String state) {    	
    	ContactInfo CI = new ContactInfo (id,address, city, state, student);
        return repo.save(CI);
    }
    
 
    public ContactInfo updateLicense(ContactInfo CI) {
        return repo.save(CI);
    }
    
 
    public void deleteContactInfo (Long id) {
        Optional<ContactInfo> CI = repo.findById(id);
        if(CI.isPresent()) {
            repo.deleteById(id);
        } 
    }
    
    
}
