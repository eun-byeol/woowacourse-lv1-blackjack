package model.result;

import java.util.List;
import model.dealer.Dealer;
import model.player.Players;

public class GameResult {

    private static final String NOT_EXIST_PLAYER = "존재하는 플레이어가 없습니다.";

    private final ParticipantScore dealerScore;
    private final List<ParticipantScore> playersScore;

    private GameResult(ParticipantScore dealerScore, List<ParticipantScore> playersScore) {
        this.dealerScore = dealerScore;
        this.playersScore = playersScore;
    }

    public static GameResult of(Dealer dealer, Players players) {
        ParticipantScore dealerScore = ParticipantScore.from(dealer);
        List<ParticipantScore> playersScore = players.getGroup()
            .stream()
            .map(ParticipantScore::from)
            .toList();
        return new GameResult(dealerScore, playersScore);
    }

    public ResultStatus decideResultStatus(ParticipantScore self, ParticipantScore opponent) {
        int selfScore = self.getScore();
        int opponentScore = opponent.getScore();

        if (self.isBurst() && opponent.isBurst() || selfScore == opponentScore) {
            return ResultStatus.PUSH;
        }
        if (self.isBurst() || (opponent.isNotBurst() && opponentScore > selfScore)) {
            return ResultStatus.LOOSE;
        }
        return ResultStatus.WIN;
    }

    public int findDealerScore() {
        return dealerScore.getScore();
    }

    public int findPlayerScore(String playerName) {
        return playersScore.stream()
            .filter(playerScore -> playerScore.getParticipantName().equals(playerName))
            .findFirst()
            .map(ParticipantScore::getScore)
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_PLAYER));
    }

    public String dealerName() {
        return dealerScore.getParticipantName();
    }

    public ParticipantScore getDealerScore() {
        return dealerScore;
    }

    public List<ParticipantScore> getPlayersScore() {
        return playersScore;
    }
}