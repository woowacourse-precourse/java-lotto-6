package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import java.util.List;

import static lotto.controller.LottoController.*;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        // 로또 구매 금액 입력
        int totalPurchaseMoney = lottoController.receiveMoneyUntilPass();

        // 입력 금액 만큼 로또 구매
        int purchaseCount = totalPurchaseMoney / ONE_LOTTO_PRICE;
        List<Lotto> lottoList = lottoController.generateLottoList(purchaseCount);

        // 구매 결과 출력
        lottoController.showPurchaseResult(lottoList, totalPurchaseMoney);

        // 정답 로또 번호 입력
        Lotto answer = lottoController.registerWinningLottoCombinationUntilPass();

        // 보너스 숫자 입력
        int bonusNumber = lottoController.registerBonusNumberUntilPass();

        // 통계 결과 출력
        lottoController.showStatisticsResult(lottoList,answer,bonusNumber);
    }


}
