package data;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	List<Card> handList;

	public Hand() {
		handList = new ArrayList<Card>();
	}
	
	public Hand addCard(Card c) {
		handList.add(c);
		return this;
	}

	public Hand removeCard(Card c) {
		handList.remove(c);
		return this;
	}
	
	public void display() {
		for(int i=0;i<handList.size();i++) {
			System.out.println(i + ":" + handList.get(i));
		}
	}

	public Card TakeCardAt(int index) {
		if((index < 0 ) || (index >= handList.size())){
			return null;
		}
		Card c = handList.remove(index);
		return c;
	}
	
	public void addCard(List<Card> cardList2) {
		for (Card card : cardList2) {
			addCard(card);
		}
	}
	
	public List<Card> getCardList(){
		return handList;
	}
}
