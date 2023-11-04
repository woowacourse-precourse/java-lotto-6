package view;

import java.util.List;
import lotto.Lotto;

public class Output {
    public static final String PURCHASE_AMOUNT_MESSAGE = "%d개를 구매했습니다.";

    public static List<Lotto> getLottoNumbers(int purchaseAmount) {
        int lottoAmount = purchaseAmount / 1000;
        System.out.printf(PURCHASE_AMOUNT_MESSAGE + "%n", lottoAmount);

        List<Lotto> lottoList = null; // 구현 예정

        return lottoList;
    }
}
