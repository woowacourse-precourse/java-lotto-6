package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.LottoResultStatus;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.LottoResult;

public class OutputView {

    public static void announceLottoPurchaseQuantity(int purchaseQuantity) {
        System.out.println(purchaseQuantity + "개를 구매했습니다.");
    }

    public static void announceMultipleLottoNumbers(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void announceLottoResult(LottoManager lottoManager) {
        Map<LottoResult, Integer> lottoWinningResult = lottoManager.getLottoWinningResult();

        for (Map.Entry<LottoResult, Integer> entry : lottoWinningResult.entrySet()) {
            LottoResult lottoResult = entry.getKey();
            int matchingCount = lottoResult.getMatchingCount();
            boolean hasBonusNumber = lottoResult.isHasBonusNumber();
            int matchingNumber = entry.getValue();

//            int winningAmount =
//            String bonusString = "";
//            if(hasBonusNumber) {
//                bonusString = ", 보너스 볼 일치";
            }

//            String resultString = matchingCount + "개 일치" + bonusString + " (" + winningAmount + "원) - " + matchingNumber + "개";
//            System.out.println(resultString);
        }
}
