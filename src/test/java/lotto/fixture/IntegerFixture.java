package lotto.fixture;

public enum IntegerFixture {
    VALID_A("200"),
    VALID_B("0"),
    VALID_C("-200"),

    CONTAIN_SPACE_A("200    "),
    CONTAIN_SPACE_B("    200"),
    CONTAIN_SPACE_C("2 0   0"),

    NOT_INTEGER("2000a");


    IntegerFixture(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    private final String input;
}
