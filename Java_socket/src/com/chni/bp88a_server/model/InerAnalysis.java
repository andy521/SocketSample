package com.chni.bp88a_server.model;


public class InerAnalysis {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String createtime;
	private String customerid;
	private String questionid;
	private String value;
	private String source;
	private String createuserid;
	private String tablename;
	private String questionname;
	private String answername;
	private String answertype;
	private String entrydate;

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	public String getAnswertype() {
		return answertype;
	}

	public void setAnswertype(String answertype) {
		this.answertype = answertype;
	}

	public String getAnswername() {
		return answername;
	}

	public void setAnswername(String answername) {
		this.answername = answername;
	}

	public String getQuestionname() {
		return questionname;
	}

	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(String createuserid) {
		this.createuserid = createuserid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((answername == null) ? 0 : answername.hashCode());
		result = prime * result
				+ ((answertype == null) ? 0 : answertype.hashCode());
		result = prime * result
				+ ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result
				+ ((createuserid == null) ? 0 : createuserid.hashCode());
		result = prime * result
				+ ((customerid == null) ? 0 : customerid.hashCode());
		result = prime * result
				+ ((entrydate == null) ? 0 : entrydate.hashCode());
		result = prime * result
				+ ((questionid == null) ? 0 : questionid.hashCode());
		result = prime * result
				+ ((questionname == null) ? 0 : questionname.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result
				+ ((tablename == null) ? 0 : tablename.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InerAnalysis other = (InerAnalysis) obj;
		if (answername == null) {
			if (other.answername != null)
				return false;
		} else if (!answername.equals(other.answername))
			return false;
		if (answertype == null) {
			if (other.answertype != null)
				return false;
		} else if (!answertype.equals(other.answertype))
			return false;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (createuserid == null) {
			if (other.createuserid != null)
				return false;
		} else if (!createuserid.equals(other.createuserid))
			return false;
		if (customerid == null) {
			if (other.customerid != null)
				return false;
		} else if (!customerid.equals(other.customerid))
			return false;
		if (entrydate == null) {
			if (other.entrydate != null)
				return false;
		} else if (!entrydate.equals(other.entrydate))
			return false;
		if (questionid == null) {
			if (other.questionid != null)
				return false;
		} else if (!questionid.equals(other.questionid))
			return false;
		if (questionname == null) {
			if (other.questionname != null)
				return false;
		} else if (!questionname.equals(other.questionname))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (tablename == null) {
			if (other.tablename != null)
				return false;
		} else if (!tablename.equals(other.tablename))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;

	}
}
