package lotto.domain.constants;

public enum LottoSetting {
    LOTTO_NUMBER_RANGE_START(1),
    LOTTO_NUMBER_RANGE_END(45),
    LOTTO_WINNING_NUMBERS_COUNT(6),
    LOTTO_PRICE(1000);

    private final int settingNumber;

    LottoSetting(int settingNumber) {
        this.settingNumber = settingNumber;
    }

    public int getNumber() {
        return settingNumber;
    }
}
