package com.example.cookingrecipe.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "recipe")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

// date and time,dd-mm-yyyy hh:mm , veg or non veg, serving size, ingredients,
// cooking instruction
public class Recipe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String title; // name of recipe

	@NotBlank
	private String servingsize; // count of people

	@NotBlank
	private String indicator; // veg or nonveg

	@NotBlank
	private String cookingins; // cooking instruction

	@NotBlank
	private String ingredients; // list of ingredients

	@NotBlank
	private String url; // url of image 

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	@LastModifiedDate
	private Date updatedAt;
	
	
	
	
	
	public Recipe() {
		super();
	}

	public Recipe(@NotBlank String title, @NotBlank String servingsize, @NotBlank String indicator,
			@NotBlank String cookingins, @NotBlank String ingredients, @NotBlank String url) {
		super();
		this.title = title;
		this.servingsize = servingsize;
		this.indicator = indicator;
		this.cookingins = cookingins;
		this.ingredients = ingredients;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getServingsize() {
		return servingsize;
	}

	public void setServingsize(String servingsize) {
		this.servingsize = servingsize;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public String getCookingins() {
		return cookingins;
	}

	public void setCookingins(String cookingins) {
		this.cookingins = cookingins;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

}
