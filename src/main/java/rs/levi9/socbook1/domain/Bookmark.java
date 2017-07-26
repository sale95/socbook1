package rs.levi9.socbook1.domain;

import com.sun.istack.internal.Nullable;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.Past;

@Entity
public class Bookmark extends BaseEntity {

	@Column(nullable = false)
	private String url;
	
	@Length(min=2, max=100)
	@Column(nullable = false)
	private String title;

	@Column(nullable = true)
	private String importedBy;
	
	@Column(nullable = false)
	private Date date;
	
	@Length(min=1)
	@Column(nullable = false)
	private String description;
	 
	@Column(nullable = false)
	private boolean visibility;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Cascade(CascadeType.ALL)
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "bookmark_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tags;

	public String getImportedBy() {
		return importedBy;
	}

	public void setImportedBy(String importedBy) {
		this.importedBy = importedBy;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
