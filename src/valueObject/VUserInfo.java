package valueObject;

public class VUserInfo {
	private String name;
	private String name2;
	private int credit;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	} 
	
	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName2() {
		return name2;
	} 
	
	public void setCredit(String credit) {
		this.credit = Integer.parseInt(credit);
	}
	
	public int getCredit() {
		return this.credit;
	}
}

//source generate get 뭐시기 하면 한번에 만들어 진다. 