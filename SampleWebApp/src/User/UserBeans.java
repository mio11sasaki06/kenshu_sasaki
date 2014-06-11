package User;



public class UserBeans{
	private String username;
	private String address;
	private String phone;
	public void checkValues(){
		if(username != null && address != null && phone != null){
			username += "(チェック済）";
		}
	}
	public String getUsername(){
		return username;
	};
	public void setUsername(String username){
		this.username= username;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address= address;
	}
	public String getphone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone= phone;
	}
	
}

