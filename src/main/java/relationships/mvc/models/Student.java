package relationships.mvc.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name="students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Min(1)
    private int age;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private ContactInfo contactInfo;
    
    public Student() {
        
    }
    
    
    
    public Student(String firstName, String lastName, int age) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.age = age;
    }
    
    public Student(Long id, String firstName, String lastName, int age) {
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.age = age;
    }
    
    public Student(Long id, String firstName, String lastName, int age, ContactInfo contactInfo) {
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.age = age;
    	this.contactInfo = contactInfo;
    }

	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public ContactInfo getContactInfo() {
		return contactInfo;
	}



	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
  
}
