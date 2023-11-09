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
        int totalWinnings = 0;
        for (LottoRank rank : lottoRanks) {
            totalWinnings += rank.getPrizeMoney();
        }
        return totalWinnings;
    }


    public double calculateReturnOfRate(int totalPurchaseAmount, int totalWinnings) {
        if (totalPurchaseAmount == 0) {
            return 0;
        }
        return ((double) totalWinnings / totalPurchaseAmount) * 100;
    }
}
