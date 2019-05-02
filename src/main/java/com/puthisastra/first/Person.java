package com.puthisastra.first;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Person {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="EMP_ID")
	private Long id;
	
	@Column(length=20)
	private String firstName;
	
	@Column(nullable=false)
	private String lastName;
	
	private Integer age;
	
	private Date lastUpdatedTime;

	@OneToOne
	@JoinColumn(name="DEPT_ID")
	private Department department;
	
	@ManyToOne
	private Role role;
	
	@ManyToMany
	private List<Adress> adress;
	
	private Date createdTime;
	
	private Date updatedTime;
	
	@PrePersist
    private void onCreate() {
        this.setCreatedTime(new Date());
        this.setUpdatedTime(new Date());
    }

    @PreUpdate
    private void onUpdate() {
        this.setUpdatedTime(new Date());
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Adress> getAdress() {
		return adress;
	}

	public void setAdress(List<Adress> adress) {
		this.adress = adress;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	
}
