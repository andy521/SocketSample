package com.chni.bp88a_server.model;

public class InterveneItems {

	private String weight;    //体重
	private String ghb;    // 糖化血红蛋白
	private String waist;    // 腰围
	private String tg;    // 甘油三酯
	private String height;// 身高


	private String bmi;
	private String tc;// 总胆固醇
	private String sbp;// 收缩压1	
	private String ldl;// 低密度脂蛋白
	private String dbp;// 舒张压
	private String hdl;// 高密度脂蛋白
	private String hr;// 心率
	private String oxy;// 血氧
	private String fpg;// 空腹血糖
	private String crp;// c-反应蛋白
	private String pbg;// 餐后血糖
	private String entyDate;// 检测时间
	private String customerid;
    private String mobileType;//当前手机类型  1 为Android， 2为IOS 

	public String getMobileType() {
	return mobileType;
}

public void setMobileType(String mobileType) {
	this.mobileType = mobileType;
}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getGhb() {
		return ghb;
	}

	public void setGhb(String ghb) {
		this.ghb = ghb;
	}

	public String getWaist() {
		return waist;
	}

	public void setWaist(String waist) {
		this.waist = waist;
	}

	public String getTg() {
		return tg;
	}

	public void setTg(String tg) {
		this.tg = tg;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getSbp() {
		return sbp;
	}

	public void setSbp(String sbp) {
		this.sbp = sbp;
	}

	public String getLdl() {
		return ldl;
	}

	public void setLdl(String ldl) {
		this.ldl = ldl;
	}

	public String getDbp() {
		return dbp;
	}

	public void setDbp(String dbp) {
		this.dbp = dbp;
	}

	public String getHdl() {
		return hdl;
	}

	public void setHdl(String hdl) {
		this.hdl = hdl;
	}

	public String getHr() {
		return hr;
	}

	public void setHr(String hr) {
		this.hr = hr;
	}

	public String getOxy() {
		return oxy;
	}

	public void setOxy(String oxy) {
		this.oxy = oxy;
	}

	public String getFpg() {
		return fpg;
	}

	public void setFpg(String fpg) {
		this.fpg = fpg;
	}

	public String getCrp() {
		return crp;
	}

	public void setCrp(String crp) {
		this.crp = crp;
	}

	public String getPbg() {
		return pbg;
	}

	public void setPbg(String pbg) {
		this.pbg = pbg;
	}

	public String getEntyDate() {
		return entyDate;
	}

	public void setEntyDate(String entyDate) {
		this.entyDate = entyDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bmi == null) ? 0 : bmi.hashCode());
		result = prime * result + ((crp == null) ? 0 : crp.hashCode());
		result = prime * result + ((dbp == null) ? 0 : dbp.hashCode());
		result = prime * result
				+ ((entyDate == null) ? 0 : entyDate.hashCode());
		result = prime * result + ((fpg == null) ? 0 : fpg.hashCode());
		result = prime * result + ((ghb == null) ? 0 : ghb.hashCode());
		result = prime * result + ((hdl == null) ? 0 : hdl.hashCode());
		result = prime * result + ((hr == null) ? 0 : hr.hashCode());
		result = prime * result + ((ldl == null) ? 0 : ldl.hashCode());
		result = prime * result + ((oxy == null) ? 0 : oxy.hashCode());
		result = prime * result + ((pbg == null) ? 0 : pbg.hashCode());
		result = prime * result + ((sbp == null) ? 0 : sbp.hashCode());
		result = prime * result + ((tc == null) ? 0 : tc.hashCode());
		result = prime * result + ((tg == null) ? 0 : tg.hashCode());
		result = prime * result + ((waist == null) ? 0 : waist.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		InterveneItems other = (InterveneItems) obj;
		if (bmi == null) {
			if (other.bmi != null)
				return false;
		} else if (!bmi.equals(other.bmi))
			return false;
		if (crp == null) {
			if (other.crp != null)
				return false;
		} else if (!crp.equals(other.crp))
			return false;
		if (dbp == null) {
			if (other.dbp != null)
				return false;
		} else if (!dbp.equals(other.dbp))
			return false;
		if (entyDate == null) {
			if (other.entyDate != null)
				return false;
		} else if (!entyDate.equals(other.entyDate))
			return false;
		if (fpg == null) {
			if (other.fpg != null)
				return false;
		} else if (!fpg.equals(other.fpg))
			return false;
		if (ghb == null) {
			if (other.ghb != null)
				return false;
		} else if (!ghb.equals(other.ghb))
			return false;
		if (hdl == null) {
			if (other.hdl != null)
				return false;
		} else if (!hdl.equals(other.hdl))
			return false;
		if (hr == null) {
			if (other.hr != null)
				return false;
		} else if (!hr.equals(other.hr))
			return false;
		if (ldl == null) {
			if (other.ldl != null)
				return false;
		} else if (!ldl.equals(other.ldl))
			return false;
		if (oxy == null) {
			if (other.oxy != null)
				return false;
		} else if (!oxy.equals(other.oxy))
			return false;
		if (pbg == null) {
			if (other.pbg != null)
				return false;
		} else if (!pbg.equals(other.pbg))
			return false;
		if (sbp == null) {
			if (other.sbp != null)
				return false;
		} else if (!sbp.equals(other.sbp))
			return false;
		if (tc == null) {
			if (other.tc != null)
				return false;
		} else if (!tc.equals(other.tc))
			return false;
		if (tg == null) {
			if (other.tg != null)
				return false;
		} else if (!tg.equals(other.tg))
			return false;
		if (waist == null) {
			if (other.waist != null)
				return false;
		} else if (!waist.equals(other.waist))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

}
