package lotto.view;

public enum InputStandard {
    STANDARD_NUMBER("-?\\\\d+"),
    STANDARD_OF_SPLIT(",");


    private final String standard;

    InputStandard(String standard) {
        this.standard = standard;
    }

    public String getStandard() {
        return standard;
    }
}
