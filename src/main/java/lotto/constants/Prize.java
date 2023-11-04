package lotto.constants;

public enum Prize {
    FIRST(6, 0, "2,000,000,000원"),
    SECOND(5, 1, "30,000,000원"),
    THIRD(5, 0, "1,500,000원"),
    FOURTH(4, 0, "50,000원"),
    FIFTH(3, 0, "5,000원");

    private final int match;     // 일치하는 숫자 개수
    private final int bonusMatch; // 보너스 번호 일치 여부 (1: 일치, 0: 불일치)
    private final String money;     // 상금 금액

    Prize(int match, int bonusMatch, String money) {
        this.match = match;
        this.bonusMatch = bonusMatch;
        this.money = money;
    }
}