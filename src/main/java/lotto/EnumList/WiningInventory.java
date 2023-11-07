package lotto.EnumList;

public enum WiningInventory {
    FIRST("First"),
    SECOND("Second"),
    THIRD("Third"),
    FOURTH("Fourth"),
    FIFTH("Fifth"),
    PRINT_FIRST("6개 일치 (2,000,000,000원) - "),
    PRINT_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    PRINT_THIRD("5개 일치 (1,500,000원) - "),
    PRINT_FOURTH("4개 일치 (50,000원) - "),
    PRINT_FIFTH("3개 일치 (5,000원) - ");

    private final String message;

    WiningInventory(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
