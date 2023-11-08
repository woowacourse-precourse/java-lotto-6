package lotto.controller;

import java.util.List;
import lotto.domain.PurchaseAmount;
import lotto.repository.BuyLottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.service.Input;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.View;

public class LottoController {

    private final LottoService lottoService = new LottoService();
    private final ResultService resultService = new ResultService();

    public void run(){
        // 구입금액 입력
        PurchaseAmount purchaseAmount = Input.purchaseAmount();
        // 금액만큼 구입개수 계산
        int purchaseCount = calculatePurchaseCount(purchaseAmount);

        // 구입개수만큼 로또자동번호 사기
        BuyLottoRepository buyLottos = lottoService.quickPick(purchaseCount);
        // 구매한 로또의 번호들을 오름차순으로 저장
        List<String> buyLottosNumber = lottoService.extractAscendingNumbers();
        // 저장한 번호들 출력
        lottoService.printNumbers(buyLottosNumber);
        // 당첨번호(+보너스 번호) 입력
        WinningLottoRepository winningLotto = lottoService.createWinningLotto();

        // 산 로또와 당첨번호(+보너스 번호)가 몇개 맞는지 확인하고 결과 출력
        resultService.checkLottoNumbers(buyLottos, winningLotto);
        // 수익률 계산하고 결과 출력
        resultService.calculateRateOfReturn(purchaseCount);
    }

    private int calculatePurchaseCount(PurchaseAmount purchaseAmount) {
        int purchaseCount = purchaseAmount.calculateCount();
        View.purchaseCount(purchaseCount);
        return purchaseCount;
    }
}
