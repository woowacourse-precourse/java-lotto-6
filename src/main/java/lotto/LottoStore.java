package lotto;

import java.util.List;

public class LottoStore {
    private final int LOTTO_PRICE = 1000;
    private final int START_NUM = 1;
    private final int END_NUM = 45;
    private final int NUM_COUNT = 6;
    private final int MIN_PRICE = 1000;

    private long chargedMoney;
    private long lottoCount;
    private List<Lotto> lottoPapers;

    public void getMoney(final String moneyInput) throws IllegalArgumentException{
        this.validateMoneyInput(moneyInput);
        this.chargeMoney(moneyInput);
        validateChargedMoney();
    }


    public void validateMoneyInput(final String moneyInput) {
        moneyInput.chars().forEach(o -> {
            if (!Character.isDigit(o)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
            }
        });
    }

    public void chargeMoney(final String moneyInput) {
        this.chargedMoney = Long.parseLong(moneyInput);
    }

    public void validateChargedMoney() {
        if (this.chargedMoney < MIN_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 부터입니다.");
        }
        if (this.chargedMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위 입니다.");
        }
    }
}
