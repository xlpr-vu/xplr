package com.xlpr.model;

import java.util.Date;

public class Event {

	private int id;
	private String title;
	private String img;
	private String short_description;
	private String long_description;;
	private Float longitude;
	private Float latitude;
	private Date begin_date;
	private Date end_date;
	private String contact_email;
	private String address;
	private String ps1, ps2, ps3, ps4, ps5;
	private String val1, val2, val3, val4, val5;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getLong_description() {
		return long_description;
	}

	public void setLong_description(String long_description) {
		this.long_description = long_description;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Date getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPs1() {
		return ps1;
	}

	public void setPs1(String ps1) {
		this.ps1 = ps1;
	}

	public String getPs2() {
		return ps2;
	}

	public void setPs2(String ps2) {
		this.ps2 = ps2;
	}

	public String getPs3() {
		return ps3;
	}

	public void setPs3(String ps3) {
		this.ps3 = ps3;
	}

	public String getPs4() {
		return ps4;
	}

	public void setPs4(String ps4) {
		this.ps4 = ps4;
	}

	public String getPs5() {
		return ps5;
	}

	public void setPs5(String ps5) {
		this.ps5 = ps5;
	}

	public String getVal1() {
		return val1;
	}

	public void setVal1(String val1) {
		this.val1 = val1;
	}

	public String getVal2() {
		return val2;
	}

	public void setVal2(String val2) {
		this.val2 = val2;
	}

	public String getVal3() {
		return val3;
	}

	public void setVal3(String val3) {
		this.val3 = val3;
	}

	public String getVal4() {
		return val4;
	}

	public void setVal4(String val4) {
		this.val4 = val4;
	}

	public String getVal5() {
		return val5;
	}

	public void setVal5(String val5) {
		this.val5 = val5;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", img=" + img + ", short_description=" + short_description
				+ ", long_description=" + long_description + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", begin_date=" + begin_date + ", end_date=" + end_date + ", contact_email=" + contact_email
				+ ", address=" + address + ", ps1=" + ps1 + ", ps2=" + ps2 + ", ps3=" + ps3 + ", ps4=" + ps4 + ", ps5="
				+ ps5 + ", val1=" + val1 + ", val2=" + val2 + ", val3=" + val3 + ", val4=" + val4 + ", val5=" + val5
				+ "]";
	}

}
