package com.exam.belt.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="ratings")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Range(min=0, max=5, message= "min is 0 and max is 5")
	private int rating;
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User ratedBy;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tvshow_id")
    private Tvshow ratedShow;
	public Long getId() {
		return id;
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
	public User getRatedBy() {
		return ratedBy;
	}
	public void setRatedBy(User ratedBy) {
		this.ratedBy = ratedBy;
	}
	public Tvshow getRatedShow() {
		return ratedShow;
	}
	public void setRatedShow(Tvshow ratedShow) {
		this.ratedShow = ratedShow;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Rating() {

	}
 
}
