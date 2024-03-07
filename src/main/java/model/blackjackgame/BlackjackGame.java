package model.blackjackgame;

import java.util.List;
import model.card.Card;
import model.card.Cards;
import model.dealer.Dealer;
import model.player.Player;
import model.player.Players;

public class BlackjackGame {

    private static final int SETTING_CARD_COUNT = 2;
    private Dealer dealer;
    private Players players;

    public BlackjackGame(Dealer dealer, Players players) {
        this.dealer = dealer;
        this.players = players;
    }

    public void distributeCardsForSetting(Cards cards) {
        List<Card> cardsElement = cards.getCards();
        dealer = dealer.addCards(cardsElement.subList(0, SETTING_CARD_COUNT));
        players = players.addCards(cardsElement.subList(SETTING_CARD_COUNT, cardsElement.size()));
    }

    public void hitOrStay(Player player, Answer answer, Card card) {
        if (answer.isHit()) {
            players = players.hit(player, card);
        }
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Players getPlayers() {
        return players;
    }
}
