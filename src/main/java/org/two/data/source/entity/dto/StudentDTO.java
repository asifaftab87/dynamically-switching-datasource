package org.two.data.source.entity.dto;

public class StudentDTO {

	
	private Long id;
	private String name;
	private String branch;
	
	public StudentDTO() {}
	
	public StudentDTO(long id, String name, String branch) {
		this.id =id;
		this.name = name;
		this.branch = branch;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	@Override
	public String toString() {
		return "StudentDTO  [id: "+id+"   name: "+name+"   branch: "+branch+"]";
	}
	
}
