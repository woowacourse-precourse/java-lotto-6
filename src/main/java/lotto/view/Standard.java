package lotto.view;

public enum Standard {
    STANDARD_NUMBER("-?\\\\d+"),
    STANDARD_OF_SPLIT(",");

    private final String standard;

    Standard(String standard) {
        this.standard = standard;
    }

    public String getStandard() {
        return standard;
    }
}
