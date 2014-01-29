

public class Card {
	//number cards in each suit
	private static final int NUMBEROFCARDS_IN_EACH_DECK = 13;

	//value of the card 
	private Value value = null;

	//suit of the card
	private Suit suit = null;

	public enum Suit { 
		DIAMONDS("\u2666"),HEARTS("\u2665"),CLUBS("\u2663"),SPADES("\u2660"); 
		public String value;
		//the value parameter, is the unicode for different symbols (heart, diamonds, clubs and Spades)
		private Suit (String value){
			this.value = value;
		}
	}


	public enum Value {	
		ACE("A",1),TWO("2",2),THREE("3",3),FOUR("4",4),FIVE("5",5),SIX("6",6),SEVEN("7",7),EIGHT("8",8),NINE("9",9),TEN("10",10),JACK("J",11),QUEEN("Q",12),KING("K",13);
		//value of the card
		public int value;
		//name of the card 
		public String name;
		private Value (String name, int value){
			this.value = value;
			this.name = name;
		}
	}

	/*
	 *Constructor for the card class
	 *@param i  a number between 0 and 52 represent each card in a deck
	 */
	public Card(int i) {
		if (i<0 || i > 51) {
			throw new RuntimeException( i + " is not representation of a card, the number has to be between 0 and 51.");
		}
		int s = i / NUMBEROFCARDS_IN_EACH_DECK;
		int c = i % NUMBEROFCARDS_IN_EACH_DECK;
		value = Value.values()[c];
		suit = Suit.values()[s];
	}

	//print the card
	public String toString () {
		return (this.value.name + "" + this.suit.value);
	}
}
