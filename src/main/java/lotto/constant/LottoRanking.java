package lotto.constant;

public enum LottoRanking {
    FIFTH_RANK(5000L, "3개 일치 (5,000원)", 3, JudgeBonus.BONUS_NO_MATTER),
    FOURTH_RANK(50000L, "4개 일치 (50,000원)", 4, JudgeBonus.BONUS_NO_MATTER),
    THIRD_RANK(1500000L, "5개 일치 (1,500,000원)", 5, JudgeBonus.BONUS_UNEQUAL),
    SECOND_RANK(30000000L, "5개 일치, 보너스 볼 일치 (30,000,000원)", 5, JudgeBonus.BONUS_EQUAL),
    FIRST_RANK(2000000000L, "6개 일치 (2,000,000,000원)", 6, JudgeBonus.BONUS_NO_MATTER)
    ;

    private final Long price;
    private final String message;
    private final Integer matchNumber;
    private final JudgeBonus judgeBonus;
    private Integer count;

    LottoRanking(final Long price, final String message, final Integer matchNumber, final JudgeBonus judgeBonus) {
        this.price = price;
        this.message = message;
        this.matchNumber = matchNumber;
        this.judgeBonus = judgeBonus;
        this.count = 0;
    }

    public Long toPrice() {
        return price * count;
    }

    public String toPrintMessage() {
        return message + " - " + count +"개";
    }

    public void ismatched(Integer matchNumber, JudgeBonus judgeBonus) {
        if(this.matchNumber.equals(matchNumber) && this.judgeBonus.equals(judgeBonus)) {
            count++;
        }
    }
}
