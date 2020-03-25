package blackjack.domain.result;

import blackjack.domain.user.Playable;

public final class Result {
	private Playable player;
	private ResultType result;

	public Result(Playable player, ResultType result) {
		this.player = player;
		this.result = result;
	}

	public Playable getPlayable() {
		return player;
	}

	public ResultType getResultType() {
		return result;
	}
}