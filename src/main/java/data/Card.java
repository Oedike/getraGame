package data;

import java.util.ArrayList;
import java.util.List;

public class Card {
	private int globalId;
	private int id;
	private String name;
	private String image;
	private List<Attribute> attributList; 
	
	public Card() {
		super();
		attributList = new ArrayList<Attribute>();
	}

	public Card(Card c) {
		globalId = 0;
		this.id = c.id;
		this.name = c.name;
		this.image = c.image;
		
		attributList = new ArrayList<Attribute>();
		
		for (Attribute attribute : c.attributList) {
			this.attributList.add(new Attribute(attribute));
		}
	}

	public void addAttribute(Attribute attribute) {
		attributList.add(attribute);
	}
	
	public void removeAttribute(Attribute attribute) {
		attributList.remove(attribute);
	}
	
	public boolean hasAttribute(Attribute attribute) {
		return attributList.contains(attribute);
	}
		
	public List<Attribute> getAttributList() {
		return attributList;
	}

	public void setAttributList(List<Attribute> attributList) {
		this.attributList = attributList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Attribute> getElementList(){
		return getListByType(Attribute.TYPE_ELEMENT);
	}
	
	public List<Attribute> getElementPreRequisList(){
		return getListByType(Attribute.TYPE_ELEMENT_PREREQUIS);
	}
	
	public List<Attribute> getFamilleList(){
		return getListByType(Attribute.TYPE_FAMILLE);
	}
	
	private List<Attribute> getListByType(int type){
		List<Attribute> typeList = new ArrayList<Attribute>();
		
		for (Attribute attribute : attributList) {
			if(attribute.getType() == type) {
				typeList.add(attribute);
			}
		}
		
		return typeList;
	}
	
	public int getGlobalId() {
		return globalId;
	}

	public void setGlobalId(int globalId) {
		this.globalId = globalId;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", globalId=" + globalId + ", name=" + name + ", attributList=" + attributList + "]";
	}
}
