package blackjack.domain.card;

import blackjack.domain.card.exceptions.DeckException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public final class Deck implements Drawable {
	public static final int TWO = 2;

	private final Stack<Card> cards;

	private Deck(Stack<Card> cards) {
		this.cards = cards;
	}

	public static Deck of(List<Card> cards) {
		Stack<Card> stack = new Stack<>();
		stack.addAll(cards);
		return new Deck(stack);
	}

	@Override
	public Card draw() {
		if (cards.isEmpty()) {
			throw new DeckException("뽑을 카드가 없습니다.");
		}
		return cards.pop();
	}

	@Override
	public List<Card> drawTwoCards() {
		List<Card> drawn = new ArrayList<>();
		for (int i = 0; i < TWO; i++) {
			drawn.add(draw());
		}
		return drawn;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Deck deck1 = (Deck) o;
		return Objects.equals(cards, deck1.cards);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cards);
	}

	@Override
	public String toString() {
		return "Deck{" +
				"deck=" + cards +
				'}';
	}
}