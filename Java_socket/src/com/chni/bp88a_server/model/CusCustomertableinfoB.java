package com.chni.bp88a_server.model;


/**
 * CusCustomertableinfoB entity. @author MyEclipse Persistence Tools
 */
public class CusCustomertableinfoB implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CusCustomertableinfoBId id;
	private String tablename;
	private String createtime;
	private String createuserid;

	// Constructors

	/** default constructor */
	public CusCustomertableinfoB() {
	}

	/** minimal constructor */
	public CusCustomertableinfoB(CusCustomertableinfoBId id) {
		this.id = id;
	}

	/** full constructor */
	public CusCustomertableinfoB(CusCustomertableinfoBId id, String tablename,
			String createtime, String createuserid) {
		this.id = id;
		this.tablename = tablename;
		this.createtime = createtime;
		this.createuserid = createuserid;
	}

	public CusCustomertableinfoBId getId() {
		return this.id;
	}

	public void setId(CusCustomertableinfoBId id) {
		this.id = id;
	}

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getCreateuserid() {
		return this.createuserid;
	}

	public void setCreateuserid(String createuserid) {
		this.createuserid = createuserid;
	}

}