package datamanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import data.Attribute;
import data.Card;

public class DeckBuilder {

	private static DeckBuilder instance;
	private List<Card> gameDeck;
	private int globalId;
	
	
	public static DeckBuilder getInstance() {
		if (instance == null) {
			instance = new DeckBuilder();
		}
		return instance;
	}

	private DeckBuilder() {
		gameDeck = new ArrayList<Card>();
		globalId = 1;
		
		String line = null;

		try {
			String path = new File(".").getCanonicalPath();
			FileReader fileReader = new FileReader(path+"/src/main/resources/deck.txt");
			BufferedReader br = new BufferedReader(fileReader);

			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if(line.startsWith("#")) {
					continue;
				}
				List<Card> c = createCards(line);
				if(c != null) {
					gameDeck.addAll(c);
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
	}

	private List<Card> createCards(String cardData) {
		String[] splitCardData = cardData.split(";");

		List<Card> cardList = new ArrayList<Card>();
		
		if(splitCardData.length < 3) {
			System.out.println("Erreur data manquante : " + cardData);
			return null;
		}

		int id = Integer.parseInt(splitCardData[0]);

		int cardCount = Integer.parseInt(splitCardData[1]);
		
		Card c = new Card();
		c.setGlobalId(globalId++);
		c.setId(id);
		c.setName(splitCardData[2]);
		c.setImage("/art/image_" + id + ".png");

		for(int i = 3;i<splitCardData.length;i++) {
			String attributDesc = splitCardData[i];
			String[] splitAttribute = attributDesc.split("_");

			if(splitAttribute.length<3) {
				System.out.println("Attention attribut incomplete, attribute ignoré");
				continue;
			}

			int type = Integer.parseInt(splitAttribute[0]);
			int subType = Integer.parseInt(splitAttribute[1]);
			int value = Integer.parseInt(splitAttribute[2]);


			Attribute a = new Attribute(type, subType, value);
			c.addAttribute(a);
		}
		
		
		for(int i=0;i<cardCount;i++) {
			Card c2 = new Card(c);
			c2.setGlobalId(globalId++);
			cardList.add(c2);
		}
		
		return cardList;
	}

	public List<Card> getGameDeck() {
		return gameDeck;
	}
}
