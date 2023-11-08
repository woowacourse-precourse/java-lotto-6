package lotto.controller;

import java.util.List;
import lotto.controller.dto.LottoResponseDtos;
import lotto.controller.dto.ResultResponseDto;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.domain.UserLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void run() {
        try {
            OutputView.printInputPrice();
            PurchasePrice purchasePrice = getPurchasePrice();
            int lottoCount = getLottoCount(purchasePrice);
            Lottos lottos = new Lottos(lottoService.generateLotto(lottoCount));
            printLottoValues(lottos);
            UserLotto userLotto = getUserLotto();
            List<LottoResult> results = lottoService.returnLottoResult(userLotto, lottos);
            returnGameResult(results, purchasePrice);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private void returnGameResult(List<LottoResult> results, PurchasePrice purchasePrice) {
        try {
            List<ResultResponseDto> dtos = lottoService.convertToDto(results);
            OutputView.printLottoResult(dtos);
            extractEarningRate(purchasePrice, dtos);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            returnGameResult(results, purchasePrice);
        }

    }

    private static void printLottoValues(Lottos lottos) {
        try {
            LottoResponseDtos responseDtos = lottos.toResponseDtos();
            OutputView.printLottosValue(responseDtos);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            printLottoValues(lottos);
        }
    }

    private UserLotto getUserLotto() {
        try {
            Lotto userLotto = getUserLottoNumber();
            int userBonusNumber = getUserBonusNumber();
            return new UserLotto(userLotto, userBonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getUserLotto();
        }
    }

    private int getLottoCount(PurchasePrice purchasePrice) {
        try {
            int lottoCount = purchasePrice.getLottoCount();
            OutputView.printPurchaseLotto(lottoCount);
            return lottoCount;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getLottoCount(purchasePrice);
        }
    }

    private static void extractEarningRate(PurchasePrice purchasePrice,
            List<ResultResponseDto> resultResponseDtos) {
        try {
            double earningRate = purchasePrice.calculatePriceRate(resultResponseDtos);
            OutputView.printEarningRate(earningRate);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            extractEarningRate(purchasePrice, resultResponseDtos);
        }
    }

    private static int getUserBonusNumber() {
        OutputView.printGetBonusNumber();
        try {
            return InputView.getUserBonusNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getUserBonusNumber();
        }
    }

    private static Lotto getUserLottoNumber() {
        OutputView.printGetInputNumber();
        try {
            List<Integer> userLottoNumbers = InputView.getUserLottoNumber();
            return new Lotto(userLottoNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getUserLottoNumber();
        }
    }

    private PurchasePrice getPurchasePrice() {
        try {
            int price = InputView.getPurchaseLottoPrice();
            return new PurchasePrice(price);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getPurchasePrice();
        }
    }

}
