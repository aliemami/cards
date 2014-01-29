import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;

public class CardsDeck{
	//numver if cards in a deck
	private static final int NUMCARDS = 52;

	private Stack<Card> deck = null;

	//the whole class could be define as a singleton depends on the application 
	//constructor creates and initializes the deck of cards
	public CardsDeck() {
		deck = new Stack<Card>();
		for (int i=0; i< NUMCARDS;i++) {
			deck.push(new Card(i));
		}
	}

	//pop the top card and return null if there is no element in the stack or other exceptions
	public Card deal() {
		try {
			return deck.pop();
		}catch (EmptyStackException e) {
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	//shuffle the existing deck
	public void shuffle(){
		long seed = System.nanoTime();
		Collections.shuffle(deck, new Random(seed));
	}


	public String toString() {
		//stringBuffer "theoretically" is faster but for small string manipulation
		//string class is just fast and simple 
		String str = "";
		for (int i=0; i < deck.size() ; i++) {
			str += deck.elementAt(i) + " \n";
		}
		return str + " size:" + deck.size();
	}


	//just for representation having a unit test is the right way to go
	public static void main(String [] args) {
		//create a new deck of card
		CardsDeck cardsDeck = new CardsDeck();
		//print it
		System.out.println("brand new deck.");
		System.out.println("--------------");
		System.out.println(cardsDeck);

		//shuffle it and print it again
		cardsDeck.shuffle();
		System.out.println("\n deck after shuffle.");
		System.out.println("--------------");
		System.out.println(cardsDeck);

		//deal a card and print it to the screen 
		Card card = cardsDeck.deal();
		System.out.println("\n dealt card:" + card);
		System.out.println("--------------");

		//reprint the deck
		System.out.println("\n print it again");
		System.out.println("--------------");
		System.out.println(cardsDeck);

	}
}
