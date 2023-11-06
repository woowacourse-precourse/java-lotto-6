package lotto.constants;

public enum Prize {
    FIRST(1, 6, false, "2,000,000,000원"),
    SECOND(2, 5, true, "30,000,000원"),
    THIRD(3, 5, false, "1,500,000원"),
    FOURTH(4, 4, false, "50,000원"),
    FIFTH(5, 3, false, "5,000원");

    private final int rank; // 순위
    private final int match; // 일치하는 숫자 개수
    private final boolean bonusMatch; // 보너스 번호 일치 여부 (1: 일치, 0: 불일치)
    private final String money; // 상금 금액

    Prize(int rank, int match, boolean bonusMatch, String money) {
        this.rank = rank;
        this.match = match;
        this.bonusMatch = bonusMatch;
        this.money = money;
    }

    public int getRank() {
        return rank;
    }
}