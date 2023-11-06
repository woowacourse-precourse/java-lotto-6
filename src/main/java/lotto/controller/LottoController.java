package lotto.controller;

import java.util.List;
import lotto.controller.dto.LottoResponseDtos;
import lotto.controller.dto.ResultResponseDto;
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
        try {
            PurchasePrice purchasePrice = getPurchasePrice();
            int lottoCount = getLottoCount(purchasePrice);
            Lottos lottos = new Lottos(lottoService.generateLotto(lottoCount));
            LottoResponseDtos responseDtos = lottos.toResponseDtos();
            OutputView.printLottosValue(responseDtos);
            Lotto userLotto = getUserLottoNumber();
            int userBonusNumber = getUserBonusNumber();

            List<LottoResult> results = lottoService.returnLottoResult(userLotto, lottos,
                    userBonusNumber);
            List<ResultResponseDto> dtos = lottoService.convertToDto(results);
            OutputView.printLottoResult(dtos);
            extractEarningRate(purchasePrice, dtos);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private int getLottoCount(PurchasePrice purchasePrice) {
        int lottoCount = purchasePrice.getLottoCount();
        OutputView.printPurchaseLotto(lottoCount);
        return lottoCount;
    }

    private static void extractEarningRate(PurchasePrice purchasePrice,
            List<ResultResponseDto> resultResponseDtos) {
        double earningRate = purchasePrice.calculatePriceRate(resultResponseDtos);
        OutputView.printEarningRate(earningRate);
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
