package blackjack.domain.player;

public class User extends AbstractPlayer {
    private static final String YES = "y";
    private static final String NO = "n";
    private boolean isDrawStop = false;

    public User(String name) {
        super(name);
    }

    public boolean isDrawStop() {
        return isDrawStop;
    }

    public void stopDraw() {
        isDrawStop = true;
    }

    @Override
    public boolean isCanDraw() {
        return !(isDrawStop() || isOverBlackJack());
    }

    public boolean isDrawContinue(String input) {
        drawInputValidate(input);
        if (YES.equals(input)) {
            return true;
        }
        stopDraw();
        return false;
    }

    private void drawInputValidate(String value) {
        if (!(YES.equals(value) || NO.equals(value))) {
            throw new IllegalArgumentException("입력은 y 또는 n만 가능합니다.");
        }
    }

    private boolean isOverBlackJack() {
        return getValue() > BLACKJACK;
    }
}
