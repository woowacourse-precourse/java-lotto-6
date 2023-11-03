package lotto;

import java.util.List;

public class LottoStore {
    private final int LOTTO_PRICE = 1000;
    private final int START_NUM = 1;
    private final int END_NUM = 45;
    private final int NUM_COUNT = 6;
    private final int MIN_PRICE = 1000;

    private long customerMoney;
    private long lottoCount;
    private List<Lotto> lottoPapers;

    public void getMoney(final String moneyInput) throws IllegalArgumentException{
        validateMoneyInput(moneyInput);
    }

    public void validateMoneyInput(final String moneyInput) {
        moneyInput.chars().forEach(o -> {
            if (!Character.isDigit(o)) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
        });
    }
}
