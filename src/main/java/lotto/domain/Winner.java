package lotto.domain;

import java.text.NumberFormat;
import java.util.Locale;

public enum Winner {

    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FRIST(6, false, 2000000000);

    private int sameCount;
    private boolean isSameBonusNumber;
    private int winningMoney;

    Winner(int sameCount, boolean isSameBonusNumber, int winningMoney) {
        this.sameCount = sameCount;
        this.isSameBonusNumber = isSameBonusNumber;
        this.winningMoney = winningMoney;
    }

    public static Winner of(int sameCount, boolean isSameBonusNumber) {
        Winner findWinner;
        for (Winner winner : Winner.values()) {
            findWinner = getWinner(sameCount, isSameBonusNumber, winner);
            if (findWinner != null) {
                return findWinner;
            }
        }
        return null;
    }

    private static Winner getWinner(int sameCount, boolean isSameBonusNumber, Winner winner) {
        if (winner.sameCount == sameCount && (!winner.isSameBonusNumber || isSameBonusNumber)) {
            return winner;
        }
        return null;
    }

    public int getSameCount() {
        return sameCount;
    }

    public boolean isSameBonusNumber() {
        return isSameBonusNumber;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NumberFormat format = NumberFormat.getNumberInstance(Locale.KOREA);
        String formattedNumber = format.format(winningMoney) + "원";
        sb.append(sameCount + "개 일치");
        if (isSameBonusNumber) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (" + formattedNumber + ")");
        return sb.toString();
    }
}
