package lotto.domain;

public class WinningStat {
    private Integer count;

    private WinningStat() {
        count = 0;
    }

    public static WinningStat create() {
        return new WinningStat();
    }

    public void adder() {
        count++;
    }
}
