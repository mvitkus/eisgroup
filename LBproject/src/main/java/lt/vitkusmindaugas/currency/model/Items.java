package lt.vitkusmindaugas.currency.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Items implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Item> item;
	private String type;

	public Items() {
	}

	public Items(List<Item> item, String type) {
		this.item = item;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
}
