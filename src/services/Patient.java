/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;


public class Patient {

	public Integer id;
        public String user_name;
	public String first_name;
	public String last_name;
	public String birthday;
	public String address;
        public String work;
        public String temperature;
        public String diagnoz_admission;
        public String diagnoz_call;
        public String diagnoz_dispansery;
        public String diagnoz_hospital;
        public String diagnoz_infections;
        public String date_from;
        public String date_to;
        public String date_diagnoz;
        public String date_SES;
        public String vactination;
        public String vactin_refused;
        public String date_to_refused;
        public String diagnoz;

  
        

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
        public String getUserName() {
		return user_name;
	}

	public void setUserName(String user_name) {
		this.user_name = user_name;
        }
        public String getDate_to_refused() {
		return date_to_refused;
	}

	public void setDate_to_refused(String date_to_refused) {
		this.date_to_refused = date_to_refused;
        }
        public String getTemp() {
		return temperature;
	}

	public void setTemp(String temp) {
		this.temperature = temp;
        }
        public String getVactin_refused() {
		return vactin_refused;
	}

	public void setVactin_refused(String vactin_refused) {
		this.vactin_refused = vactin_refused;
        }
        public String getDiagnoz_call() {
		return diagnoz_call;
	}

	public void setDiagnoz_call(String diagnoz_call) {
		this.diagnoz_call = diagnoz_call;
        }
        public String getDiagnoz_dispansery() {
		return diagnoz_dispansery;
	}

	public void setDiagnoz_dispansery(String diagnoz_dispansery) {
		this.diagnoz_dispansery = diagnoz_dispansery;
        }
        public String getDiagnoz_hospital() {
		return diagnoz_hospital;
	}

	public void setDiagnoz_hospital(String diagnoz_hospital) {
		this.diagnoz_hospital = diagnoz_hospital;
        }
        public String getDiagnoz_infections() {
		return diagnoz_infections;
	}

	public void setDiagnoz_infections(String diagnoz_infections) {
		this.diagnoz_infections = diagnoz_infections;
        }
        public String getDate_from() {
		return date_from;
	}

	public void setDate_from(String date_from) {
		this.date_from = date_from;
        }
        public String getDate_to() {
		return date_to;
	}

	public void setDate_to(String date_to) {
		this.date_to = date_to;
        }
        public String getDate_diagnoz() {
		return date_diagnoz;
	}

	public void setDate_diagnoz(String date_diagnoz) {
		this.date_diagnoz = date_diagnoz;
        }
        public String getDate_SES() {
		return date_SES;
	}

	public void setDate_SES(String date_SES) {
		this.date_SES = date_SES;
	}
        public String getVactination() {
		return vactination;
	}

	public void setVactination(String vactination) {
		this.vactination = vactination;
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
        public String getDiagnoz_admission() {
		return diagnoz_admission;
	}

	public void setDiagnoz(String diagnoz) {
		this.diagnoz = diagnoz;
	}
               public String getDiagnoz() {
		return diagnoz;
	}

	public void setDiagnoz_admission(String diagnoz_admission) {
		this.diagnoz_admission = diagnoz_admission;
	}

	public Patient(Integer id, String user_name, String first_name, String last_name, 
			 String birthday, String address,  String work, String diagnoz,String temperature, String diagnoz_admission, String diagnoz_call,
                         String diagnoz_dispansery, String diagnoz_hospital,  String diagnoz_infections, 
                         String date_from, String date_to,String date_diagnoz, String date_SES, String vactination,  String vactin_refused,
                         String date_to_refused) {
		this.id = id;
                this.user_name = user_name;
		this.first_name = first_name;
		this.last_name = last_name;
		this.birthday = birthday;
		this.address =address;
		this.work = work;
                this.diagnoz = diagnoz;
                this.temperature = temperature;
                this.diagnoz_admission = diagnoz_admission;
                this.diagnoz_call = diagnoz_call;
                this.diagnoz_dispansery = diagnoz_dispansery;
                this.diagnoz_hospital = diagnoz_hospital;
                this.diagnoz_infections = diagnoz_infections;
                this.date_from = date_from;
                this.date_to = date_to;
                this.date_diagnoz = date_diagnoz;
                this.date_SES = date_SES;
                this.vactination = vactination;
                this.vactin_refused = vactin_refused;
                this.date_to_refused = date_to_refused;

	}

}
