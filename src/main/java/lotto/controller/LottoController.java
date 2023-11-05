package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void run() {
        PurchasePrice purchasePrice = getPurchasePrice();
        int lottoCount = purchasePrice.getLottoCount();
        OutputView.printPurchaseLotto(lottoCount);
        Lottos lottos = new Lottos(lottoService.generateLotto(lottoCount));
        OutputView.printLottosValue(lottos.toResponseDto());
        // 당첨 번호를 입력해 주세요.
        Lotto userLotto = getUserLottoNumber();
        // 보너스 번호를 입력해 주세요.
        int userBonusNumber = getUserBonusNumber();
        // 당첨 통계
        List<LottoResult> results = lottoService.returnLottoResult(userLotto, lottos,
                userBonusNumber);
        // 출력
        OutputView.printLottoResult(lottoService.convertToDto(results));
        // 수익률

    }

    private static int getUserBonusNumber() {
        OutputView.printGetBonusNumber();
        return InputView.getUserBonusNumber();
    }

    private static Lotto getUserLottoNumber() {
        OutputView.printGetInputNumber();
        List<Integer> userLottoNumbers = InputView.getUserLottoNumber();
        return new Lotto(userLottoNumbers);
    }

    private PurchasePrice getPurchasePrice() {
        OutputView.printInputPrice();
        int price = InputView.getPurchaseLottoPrice();
        return new PurchasePrice(price);
    }

}
