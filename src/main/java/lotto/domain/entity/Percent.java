package lotto.domain.entity;

public class Percent {

    private final Double percent;

    private Percent(Double percent) {
        this.percent = percent;
    }

    public static Percent create(Double percent) {
        return new Percent(percent);
    }

    public double getPercent() {
        return percent;
    }
}
