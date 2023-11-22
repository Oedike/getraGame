package datamanager;

import java.util.List;

import data.Attribute;
import data.Card;

public class ScoreManager {
	
	private static ScoreManager instance;

	private static int SCORE_ANCIEN_FULL = 150;
	private static int SCORE_ARTIFICIER_UNIT = 20;
	

	public static ScoreManager getInstance() {
		if (instance == null) {
			instance = new ScoreManager();
		}
		return instance;
	}

	private ScoreManager() {
		/*

		ancien	4 cartes dans tout le paquet = beaucoup de point et il les faut tous demande des prerequis ? chaque carte fait de plus en plus de points ?								15 par carte 100 les 4	15	25 par carte
		duo	fait un peu de points quand on en a exactement 2 ?								30	0	15 par carte
		aplha et omega	deux carte beaucoup de points, mais beaucoup de prerequis très différents								100	30	50 par carte
		artificier	plus on en a plus ca score, mais demande d'avoir au moins une alumette avec								10	5	10
		allumette/piromane ?	fait pas grand chose, mais permet d'allumer les artificier								1	1	10
		maitre des elements	un par element, si on a les 6 gros bonus, sinon bonus constant								120	10	20
		assasin	plus on en a plus on score		1	2	4	8	16	32			
		archer	carte basique tjrs la meme valeur		2	4	6	8	10	12			
		guerrier	(inciter a en avoire au moins 3 ?)		4	8	12	13	14	15	16		
		pretre	famille risquer mais avec grosse récompense arriver un certain nombre		1	1	1	1	2	8	32		


		// ajouter des chainage avec des id spécifiques ??? si tu as une carte en particulier tu peux prendre cette carte / carte avec deux face ? un coté eveillé si tu as des prérequis ?

		// prévoir des facon de scoré qui rapporte beaucoup mais qui ressemble a des quetes (genre en début de parti tu essayes de partir sur une strat quand tu connais le jeu)

		 */
	}

	public int getScore(List<Card> cardList) {
		int scoreFamille = CalculScoreFamille(cardList);
		int scoreElement = CalculScoreElement(cardList);
		return scoreFamille + scoreElement;
	}

	private int CalculScoreElement(List<Card> cardList) {
		return cardList.size()*10;
	}

	private int CalculScoreFamille(List<Card> cardList) {
		int scoreFamilleTotal = 0;


		//calcul du score des anciens
		scoreFamilleTotal += calculAncienScore(cardList);
		scoreFamilleTotal += calculArtificierScore(cardList);

		return scoreFamilleTotal;
	}

	private int calculArtificierScore(List<Card> cardList) {
		int artificierCount = 0;
		boolean hasPyromane = false;
		
		for (Card card : cardList) {
			List<Attribute> attribList = card.getAttributList();
			for (Attribute attrib : attribList) {
				if(attrib.getType() == Attribute.TYPE_FAMILLE) {
					int subType = attrib.getSubType();
					int value = attrib.getValue();

					if(subType == Attribute.FAMILLE_ARTIFICIER){
						artificierCount += value;
					}
					if(subType == Attribute.FAMILLE_PYROMANE){
						hasPyromane = true;
					}
				}
			}
		}

		if(hasPyromane) {
			return artificierCount * SCORE_ARTIFICIER_UNIT;
		}

		return 0;
	}

	private int calculAncienScore(List<Card> cardList) {
		int ancienCount = 0;

		for (Card card : cardList) {
			List<Attribute> attribList = card.getAttributList();
			for (Attribute attrib : attribList) {
				if(attrib.getType() == Attribute.TYPE_FAMILLE) {
					int subType = attrib.getSubType();
					int value = attrib.getValue();

					if(subType == Attribute.FAMILLE_ANCIEN){
						ancienCount += value;
						if(ancienCount > 4) {
							ancienCount = 4;
						}
					}
				}
			}
		}

		int []ancienScoreTab = new int[5];
		ancienScoreTab[0] = 0;
		ancienScoreTab[1] = 0;
		ancienScoreTab[2] = 0;
		ancienScoreTab[3] = 0;
		ancienScoreTab[4] = SCORE_ANCIEN_FULL;

		return ancienScoreTab[ancienCount];
	}
}
