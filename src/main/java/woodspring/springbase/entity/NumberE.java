package woodspring.springbase.entity;

import javax.persistence.Entity;


public class NumberE {
	
	private long numId;
	private String numberStr;
	public NumberE(long numId, String numberStr) {
		super();
		this.numId = numId;
		this.numberStr = numberStr;
	}
	public long getNumId() {
		return numId;
	}
	public void setNumId(long numId) {
		this.numId = numId;
	}
	public String getNumberStr() {
		return numberStr;
	}
	public void setNumberStr(String numberStr) {
		this.numberStr = numberStr;
	}
	@Override
	public String toString() {
		return "NumberE [numId=" + numId + ", numberStr=" + numberStr + "]";
	}
	
	

}
