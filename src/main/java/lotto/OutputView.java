package lotto;

import java.util.List;

public class OutputView {

    private static final String MESSAGE_PURCHASE_COMPLETED = "개를 구매했습니다.";

    public void writePurchaseDetails(List<Lotto> lottery) {
        System.out.println(lottery.size() + MESSAGE_PURCHASE_COMPLETED);
        for (Lotto lotto: lottery) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }
}
