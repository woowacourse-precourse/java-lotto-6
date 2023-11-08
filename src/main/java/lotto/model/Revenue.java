package lotto.model;

public record Revenue(Double number) {

    private static final String ROUND_FORMAT = "%.1f";
    private static final Integer PERCENTAGE = 100;

    public String getPercentage() {
        return String.format(ROUND_FORMAT, number * PERCENTAGE);
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
