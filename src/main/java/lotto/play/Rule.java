package lotto.play;

public enum Rule {
    FIFTH(3, "3개 일치 (5,000원) - "), FOURTH(4, "4개 일치 (50,000원) - "), THIRD(5, "5개 일치 (1,500,000원) - "), SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, "6개 일치 (2,000,000,000원) - ");
    private int value_1;

    private String value_2;

    Rule(int value_1, String value_2) {
        this.value_1 = value_1;
        this.value_2 = value_2;
    }

    public String addString(int count) {
        return value_2 + count + "개";
    }

    public int getValue_1() {
        return value_1;
    }

    public String getValue_2() {
        return value_2;
    }
}
