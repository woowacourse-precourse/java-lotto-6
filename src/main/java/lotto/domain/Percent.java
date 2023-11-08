package lotto.domain;

public class Percent {

    private final Double percent;

    private Percent(Double percent) {
        this.percent = percent;
    }

    public Percent create(Double percent) {
        return new Percent(percent);
    }

    public double getPercent() {
        return percent;
    }
}
