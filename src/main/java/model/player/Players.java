package model.player;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import model.card.Card;

public class Players {

    private static final String INVALID_PLAYERS_SIZE = "플레이어 수는 1명 이상이어야 합니다.";
    private static final String NOT_EXIST_PLAYER = "존재하는 플레이어가 없습니다.";
    private static final int CARDS_PER_PLAYER = 2;

    private final List<Player> players;

    private Players(List<Player> players) {
        validateEmptyPlayers(players);
        this.players = players;
    }

    public static Players from(List<String> playerNames) {
        return playerNames.stream()
            .map(Player::new)
            .collect(collectingAndThen(toList(), Players::new));
    }

    private void validateEmptyPlayers(List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException(INVALID_PLAYERS_SIZE);
        }
    }

    public Players addCards(List<Card> cardsElement) {
        int index = 0;
        List<Player> updatedPlayers = new ArrayList<>();
        for (Player player : players) {
            List<Card> cards = cardsElement.subList(index, index + CARDS_PER_PLAYER);
            Player updatedPlayer = player.addCards(cards);
            updatedPlayers.add(updatedPlayer);
            index += CARDS_PER_PLAYER;
        }
        return new Players(updatedPlayers);
    }

    public Players hit(Player player, Card card) {
        List<Player> updatedPlayers = new ArrayList<>(players);
        Player updatedPlayer = player.addCard(card);

        int index = updatedPlayers.indexOf(player);
        updatedPlayers.set(index, updatedPlayer);

        return new Players(updatedPlayers);
    }

    public Player findPlayer(Player player) {
        return players.stream()
            .filter(player1 -> player1.equals(player))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_PLAYER));
    }

    public int count() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
