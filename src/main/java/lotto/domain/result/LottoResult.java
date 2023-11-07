package lotto.domain.result;

import java.util.Objects;
import lotto.Option.GameStatus;

public class LottoResult {
    private GameStatus gameStatus;

    private int equalCount;

    private int bonusCount;

    public LottoResult(int equalCount, int bonusCount) {
        this.equalCount = equalCount;
        this.bonusCount = bonusCount;
        setGameStatus();
    }

    public LottoResult(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setGameStatus() {
        if (isThreeEqual()) {
            return;
        }
        if (isFourEqual()) {
            return;
        }
        if (isFiveEqual()) {
            return;
        }
        isSixEqual();
    }

    private boolean isThreeEqual() {
        if (equalCount + bonusCount == 3) {
            gameStatus = GameStatus.THREE_EQUAL;
            return true;
        }
        return false;
    }

    private boolean isFourEqual() {
        if (equalCount + bonusCount == 4) {
            gameStatus = GameStatus.FOUR_EQUAL;
            return true;
        }
        return false;
    }

    private boolean isFiveEqual() {
        if (equalCount + bonusCount == 5) {
            gameStatus = GameStatus.FIVE_EQUAL;
            return true;
        }
        return false;
    }

    private void isSixEqual() {
        if (equalCount + bonusCount == 6) {
            if (bonusCount == 1) {
                gameStatus = GameStatus.FIVE_AND_BONUS_EQUAL;
                return;
            }
            gameStatus = GameStatus.SIX_EQUAL;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoResult other = (LottoResult) object;
        return gameStatus == other.gameStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameStatus);
    }
}
