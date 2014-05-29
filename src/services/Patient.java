/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;


public class Patient {

	public Integer id;
	public String first_name;
	public String last_name;
	public String birthday;
	public String address;
        public String work;
        public String diagnoz;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
        public String getDiagnoz() {
		return diagnoz;
	}

	public void setDiagnoz(String diagnoz) {
		this.diagnoz = diagnoz;
	}

	public Patient(Integer id, String first_name, String last_name,
			 String birthday, String address,  String work, String diagnoz) {
		this.id=id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.birthday = birthday;
		this.address =address;
		this.work = work;
                this.diagnoz = diagnoz;

	}

}
