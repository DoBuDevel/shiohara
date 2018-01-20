package com.viglet.shiohara.persistence.model.channel;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.viglet.shiohara.persistence.model.site.ShSite;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the ShPost database table.
 * 
 */
@Entity
@NamedQuery(name = "ShChannel.findAll", query = "SELECT c FROM ShChannel c")
@JsonIgnoreProperties({ "shChannels" })
public class ShChannel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String name;

	private String summary;
	
	private byte rootChannel;

	// bi-directional many-to-one association to ShChannel
	@ManyToOne
	@JoinColumn(name = "parent_channel_id")
	private ShChannel parentChannel;

	// bi-directional many-to-one association to ShSite
	@ManyToOne
	@JoinColumn(name = "site_id")
	private ShSite shSite;

	// bi-directional many-to-one association to ShChannel
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "parentChannel", cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<ShChannel> shChannels;

	public ShChannel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public ShChannel getParentChannel() {
		return parentChannel;
	}

	public void setParentChannel(ShChannel parentChannel) {
		this.parentChannel = parentChannel;
	}

	public ShSite getShSite() {
		return shSite;
	}

	public void setShSite(ShSite shSite) {
		this.shSite = shSite;
	}

	public List<ShChannel> getShChannels() {
		return this.shChannels;
	}

	public void setShChannels(List<ShChannel> shChannels) {
		this.shChannels = shChannels;
	}

	public byte getRootChannel() {
		return rootChannel;
	}

	public void setRootChannel(byte rootChannel) {
		this.rootChannel = rootChannel;
	}

}