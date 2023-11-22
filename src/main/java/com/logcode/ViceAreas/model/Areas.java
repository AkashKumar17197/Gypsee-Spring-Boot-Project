package com.logcode.ViceAreas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "areas")
public class Areas {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long area_id;
	private String area_name;
    private Long area_population;

    
    public Long getArea_id() {
		return area_id;
	}
	public void setArea_id(Long area_id) {
		this.area_id = area_id;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public Long getArea_population() {
		return area_population;
	}
	public void setArea_population(Long area_population) {
		this.area_population = area_population;
	}

}
