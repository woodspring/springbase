package woodspring.springbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "numberbase")
public class NumberH2 {
	@Id
	@Column(name="id")
	private long numId;
	@Column(name="number_string")
	private String numberStr;
	
	public NumberH2() {
	}
	
	public NumberH2(long numId, String numberStr) {
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
