package data;

import java.util.List;

public class Player {
	int idPlayer;
	Hand handCard;
	
	public Player(int idPlayer) {
		this.idPlayer = idPlayer;
		handCard = new Hand();
	}

	public void drawCard(Deck deck) {
		Card c = deck.drawCard();
		handCard.addCard(c);
	}
	
	public void addCard(Card card) {
		handCard.addCard(card);
	}
	
	public List<Card> getHandCardList(){
		return handCard.getCardList();
	}
}
