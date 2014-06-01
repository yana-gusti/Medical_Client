/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;


public class Graphic {

	public Integer id;
	public String user_name;
	public String mon;
	public String tue;
	public String wed;
	public String thu;
        public String fri;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMon() {
		return mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getTue() {
		return tue;
	}

	public void setTue(String tue) {
		this.tue = tue;
	}

	public String getWed() {
		return wed;
	}

	public void setWed(String wed) {
		this.wed = wed;
	}



	public String getThu() {
		return thu;
	}

	public void setThu(String thu) {
		this.thu= thu;
	}
        
	public String getFri() {
		return fri;
	}

	public void setFri(String fri) {
		this.fri= fri;
	}

	public Graphic(Integer id, String user_name, String mon, String tue,
			 String wed, String thu,  String fri) {
		this.id=id;
		this.user_name = user_name;
		this.mon = mon;
                this.fri = fri;
                this.wed = wed;
                this.tue = tue;
                this.thu = thu;

	}

}
