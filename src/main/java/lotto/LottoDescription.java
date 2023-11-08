package lotto;

public enum LottoDescription {
    THREE_NUMBERS("3개 일치 (5,000원) - "),
    FOUR_NUMBERS("4개 일치 (50,000원) - "),
    FIVE_NUMBERS("5개 일치 (1,500,000원) - "),
    BONUS_NUMBERS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_NUMBERS("6개 일치 (2,000,000,000원) - ");

    private String description;

    LottoDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}