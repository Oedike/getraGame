package data;

import java.util.ArrayList;
import java.util.List;

public class Deck {

	List<Card> cardList;

	public Deck() {
		cardList = new ArrayList<Card>();
	}
	
	public Deck(List<Card> cardList) {
		this.cardList = cardList;
	}

	public void shuffel() {
		List<Card> tmpCardList = new ArrayList<Card>();
		while(!cardList.isEmpty()) {
			int moveIndex = Dice.roll(0,cardList.size()-1);
			tmpCardList.add(cardList.remove(moveIndex));
		}
		cardList = tmpCardList;
	}

	public Card drawCard() {
		if(cardList.isEmpty()) {
			return null;
		}
		return cardList.remove(0);
	}
	
	public List<Card> drawCard(int count) {
		List<Card> cardList = new ArrayList<Card>();
		for(int i=0;i<count;i++) {
			Card c = drawCard();
			if(c == null) {
				return cardList;
			}
			cardList.add(c);
		}
		return cardList;
	}

	public void add(Card c) {
		if(c != null) {
			cardList.add(c);
		}
	}
}
