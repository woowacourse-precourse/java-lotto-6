package lotto.model;

import lotto.view.Output;

public enum WinnerJudge {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_5000_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, 0, "");

    WinnerJudge(int matchNum, int price, String message) {
        this.matchNum = matchNum;
        this.price = price;
        this.message = message;
    }

    private final int matchNum;
    private final int price;
    private final String message;

    public static WinnerJudge match(int matchNum, boolean matchBonus) {
        if (matchNum < 3) {
            return MISS;
        }
        if (SECOND.isSame(matchNum) && matchBonus) {
            return SECOND;
        }
        for (WinnerJudge winnerJudge : values()) {
            if (winnerJudge.isSame(matchNum) && winnerJudge != SECOND) {
                return winnerJudge;
            }
        }
        throw new IllegalArgumentException("[ERROR] 수식에 오류가 있습니다.");
    }

    public int getPrice() {
        return price;
    }

    public boolean isSame(int matchNum) {
        return this.matchNum == matchNum;
    }

    public void printMessage(int count) {
        if (this != MISS) {
            Output.matchMessage(message, count);
        }
    }
}
