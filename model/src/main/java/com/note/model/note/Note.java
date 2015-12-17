package com.note.model.note; 

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 笔记主题
 * @author baixiaozheng
 * @Date 2015年11月24日 下午10:47:31
 */
@Entity
@Table(name = "note")
public class Note implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5330459051591498497L;
	
	/**
	 * id
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	/**
	 * 标题
	 */
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "title_pic")
	private String titlePic;
	
	/**
	 * 内容
	 */
	@Column(name = "content", nullable = false)
	private String content;
	
	/**
	 * 类别
	 */
	@Column(name = "category")
	private Integer category;
	
	/**
	 * 标签
	 */
	@Column(name = "tags")
	private Integer[] tags;
	
	/**
	 * 创建者
	 */
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	
    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;
	
    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;
    
    /**
     * 是否正常（false为被删除）
     */
    @Column(name = "enable")
    private Boolean enable;

    /**
     * 是否发布（true正常显示，false只在管理后台可见）
     */
    @Column(name = "publish")
    private Boolean publish;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer[] getTags() {
		return tags;
	}

	public void setTags(Integer[] tags) {
		this.tags = tags;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

    public String getTitlePic() {
        return titlePic;
    }

    public void setTitlePic(String titlePic) {
        this.titlePic = titlePic;
    }

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Boolean getPublish() {
		return publish;
	}

	public void setPublish(Boolean publish) {
		this.publish = publish;
	}

}
 