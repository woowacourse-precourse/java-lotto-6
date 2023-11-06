package lotto.property;

public enum OutputProperty {

    PURCHASE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("%s개를 구매했습니다.");

    private String console;

    OutputProperty(String console) {
        this.console = console;
    }

    @Override
    public String toString() {
        return console;
    }
}
