package lotto.Domain;

public enum LottoGrade {
    THREE_MATCH(3,"5,000"),
    FOUR_MATCH(4,"50,000"),
    FIVE_MATCH(5,"1,500,000"),
    FIVE_MATCH_BONUS(5,"30,000,000"),
    SIX_MATCH(6,"2,000,000,000"),
    LOSING(0,"0");

    private int matchNumber;
    private String money;

    LottoGrade(int matchNumber, String money) {
        this.matchNumber = matchNumber;
        this.money = money;
    }


}
