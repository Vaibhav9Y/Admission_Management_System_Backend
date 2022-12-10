package com.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="form_id")
	private AdmissionForm form;
	private String certmat;
	private String certinter;
	private String certgrad;
	private String certpg;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AdmissionForm getForm() {
		return form;
	}
	public void setForm(AdmissionForm form) {
		this.form = form;
	}
	public String getCertmat() {
		return certmat;
	}
	public void setCertmat(String certmat) {
		this.certmat = certmat;
	}
	public String getCertinter() {
		return certinter;
	}
	public void setCertinter(String certinter) {
		this.certinter = certinter;
	}
	public String getCertgrad() {
		return certgrad;
	}
	public void setCertgrad(String certgrad) {
		this.certgrad = certgrad;
	}
	public String getCertpg() {
		return certpg;
	}
	public void setCertpg(String certpg) {
		this.certpg = certpg;
	}
	
	
}
