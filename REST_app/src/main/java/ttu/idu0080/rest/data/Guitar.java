package ttu.idu0080.rest.data;
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  

@Entity
@Table(name="GUITAR")
public class Guitar implements java.io.Serializable  {
	@Id  
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	private String name ;
	private String firm ;
	private int strings ;
	private String tuning ;


	public Guitar() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFirm() {
		return firm;
	}


	public void setFirm(String firm) {
		this.firm = firm;
	}


	public String getTuning() {
		return tuning;
	}


	public void setTuning(String tuning) {
		this.tuning = tuning;
	}


	public int getStrings() {
		return strings;
	}


	public void setStrings(int strings) {
		this.strings = strings;
	}



}
