package com.chni.bp88a_server.model;


/**
 * CusCustomertableinfoBId entity. @author MyEclipse Persistence Tools
 */
public class CusCustomertableinfoBId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerid;
	private String tablecode;

	// Constructors

	/** default constructor */
	public CusCustomertableinfoBId() {
	}

	/** full constructor */
	public CusCustomertableinfoBId(String customerid, String tablecode) {
		this.customerid = customerid;
		this.tablecode = tablecode;
	}


	public String getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getTablecode() {
		return this.tablecode;
	}

	public void setTablecode(String tablecode) {
		this.tablecode = tablecode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CusCustomertableinfoBId))
			return false;
		CusCustomertableinfoBId castOther = (CusCustomertableinfoBId) other;

		return ((this.getCustomerid() == castOther.getCustomerid()) || (this
				.getCustomerid() != null
				&& castOther.getCustomerid() != null && this.getCustomerid()
				.equals(castOther.getCustomerid())))
				&& ((this.getTablecode() == castOther.getTablecode()) || (this
						.getTablecode() != null
						&& castOther.getTablecode() != null && this
						.getTablecode().equals(castOther.getTablecode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCustomerid() == null ? 0 : this.getCustomerid()
						.hashCode());
		result = 37 * result
				+ (getTablecode() == null ? 0 : this.getTablecode().hashCode());
		return result;
	}

}