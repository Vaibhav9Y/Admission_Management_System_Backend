package com.student.dto;

import org.springframework.web.multipart.MultipartFile;

public class DocumentUploadDTO {
	private long formid;
	private MultipartFile mat;
	private MultipartFile inter;
	private MultipartFile grad;
	private MultipartFile pg;
	
	
	public long getFormid() {
		return formid;
	}
	public void setFormid(long formid) {
		this.formid = formid;
	}
	public MultipartFile getMat() {
		return mat;
	}
	public void setMat(MultipartFile mat) {
		this.mat = mat;
	}
	public MultipartFile getInter() {
		return inter;
	}
	public void setInter(MultipartFile inter) {
		this.inter = inter;
	}
	public MultipartFile getGrad() {
		return grad;
	}
	public void setGrad(MultipartFile grad) {
		this.grad = grad;
	}
	public MultipartFile getPg() {
		return pg;
	}
	public void setPg(MultipartFile pg) {
		this.pg = pg;
	}
	
	
}
