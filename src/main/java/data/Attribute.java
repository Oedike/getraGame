package data;

public class Attribute {
	public static final int TYPE_ELEMENT = 1;
	public static final int TYPE_ELEMENT_PREREQUIS = 2;
	public static final int TYPE_FAMILLE = 3;
	
	//rang 1
	public static final int ELEMENT_FEU = 1;
	public static final int ELEMENT_EAU = 2;
	public static final int ELEMENT_GLACE = 3;
	public static final int ELEMENT_NATURE = 4;
	public static final int ELEMENT_PIERRE = 5;
	public static final int ELEMENT_AIR = 6;
	//rang 2
	public static final int ELEMENT_LUMIERE = 7;
	public static final int ELEMENT_TENEBRE = 8;
	public static final int ELEMENT_ESPRIT = 9;
	public static final int ELEMENT_ESPACE = 10;
	
	//famille
	public static final int FAMILLE_ANCIEN = 1;
	public static final int FAMILLE_DUO = 2;
	public static final int FAMILLE_ALPHA_OMEGA = 3;
	public static final int FAMILLE_ARTIFICIER = 4;
	public static final int FAMILLE_PYROMANE = 5;
	public static final int FAMILLE_MAITRE_ELEMENT = 6;
	public static final int FAMILLE_ASSASIN = 7;
	public static final int FAMILLE_ARCHER = 8;
	public static final int FAMILLE_GUERRIER = 9;
	public static final int FAMILLE_PRETRE = 10;
	
	
	private int type;
	private int subType;
	private int value;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getSubType() {
		return subType;
	}
	public void setSubType(int subType) {
		this.subType = subType;
	}
	public Attribute(int type, int subType, int value) {
		super();
		this.type = type;
		this.subType = subType;
		this.value = value;
	}
	
	public Attribute(Attribute attribute) {
		this.type =  attribute.type;
		this.subType =  attribute.subType;
		this.value =  attribute.value;	
	}
	@Override
	public String toString() {
		return "Attribute [type=" + type + ", subType=" + subType + ", value=" + value + "]";
	}

}
