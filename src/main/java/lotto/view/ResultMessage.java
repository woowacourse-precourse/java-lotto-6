package lotto.view;

import lotto.domain.Amount;
import lotto.domain.Lotto;

import java.util.List;

public class ResultMessage {

    private static final int LOTTO_SIZE=6;
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public static void setPurchaseMessage(Amount amount, List<Lotto> lotto){
        System.out.println();
        System.out.println(amount.getCount() + PURCHASE_MESSAGE);
        printPurchaseLottoNum(amount.getCount(),lotto);
    }

    private static void printPurchaseLottoNum(int purchaseAmount, List<Lotto> lotto) {
        for (int count = 0; count < purchaseAmount; count++) {
            System.out.println(lotto.get(count).getNumbers());
        }

        System.out.println();
    }
}
