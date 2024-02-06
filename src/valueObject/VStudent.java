package valueObject;

public class VStudent {

	private int studentId;
	private int creditLimit;
	private int result;
	
	public int getCreditLimit() {
		return creditLimit;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int setStudentId) {
		this.studentId = setStudentId;
	}

}
