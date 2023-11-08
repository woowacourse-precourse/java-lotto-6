package lotto.domain;

import static lotto.domain.LottoStore.LOTTO_PRICE;

import java.util.List;
import lotto.constants.LottoRank;
import lotto.view.InputView;

public class Money {

    private static final String LOTTO_PRICE_PER_THOUSAND = "[ERROR] 로또 금액은 1000원 단위로 판매할 수 있습니다.";
    private final int money;

    public Money(Integer money) {
        validInputMoney(money);
        this.money = money;
    }

    private int validInputMoney(int money) {
        try {
            if (money % LOTTO_PRICE != 0 || money <= 0) {
                throw new IllegalArgumentException(LOTTO_PRICE_PER_THOUSAND);
            }
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return validInputMoney(new InputView().askPrice());
        }
    }

    public int getMoney() {
        return money;
    }

    public int calculateTotalWinnings(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToInt(LottoRank::getPrizeMoney)
                .sum();
    }

    public double calculateReturnOfRate(int totalSpent, int totalWinnings) {
        double profit = totalWinnings - totalSpent;
        double rateOfReturn = (profit / totalSpent) * 100;
        return 100 - Math.abs(rateOfReturn);
    }
}
