package relationships.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


//...
@Entity
@Table(name="contactinfos")
public class ContactInfo {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String address;
 private String city;
 private String state;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @OneToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="student_id")
 private Student student;
 public ContactInfo() {
     
 }
 
 
 public ContactInfo(Long id, String address, String city, String state, Student student ) {
	 this.id = id;
	 this.address = address;
	 this.city = city;
	 this.state = state;
	 this.student = student;
 }
 
 public ContactInfo(String address, String city, String state, Student student) {
	 this.address = address;
	 this.city = city;
	 this.state = state;
	 this.student = student;
 }
 
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


public Student getStudent() {
	return student;
}


public void setStudent(Student student) {
	this.student = student;
}


public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
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

