package lotto;

import java.util.List;

public class LottoController {
    public static void start() {
        Lottos lottos = purchaseLotto();
        List<Integer> winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber(winningNumbers);
    }

    private static Lottos purchaseLotto() {
        /* 구입금액 입력 및 구매*/
        String requestPurchasePrice = LottoView.requestPurchasePrice();
        int purchasePrice = LottoParser.readLineToNumber(requestPurchasePrice);
        LottoInputValidator.purchasePriceIsValid(purchasePrice);
        Lottos lottos = Lottos.purchaseLottos(purchasePrice / LottoConstants.LOTTO_PRICE.getConstant());


        /* 로또 구매갯수 및 번호들 출력*/
        LottoView.printPurchasedLottos(lottos);
        return lottos;
    }

    private static List<Integer> setWinningNumbers() {
        String requestWinningNumbers = LottoView.requestWinningNumbers();
        List<Integer> winningNumbers = LottoParser.readLineToNumbers(requestWinningNumbers);
        LottoInputValidator.WinningNumbersIsValid(winningNumbers);
        return winningNumbers;
    }

    private static int setBonusNumber(List<Integer> winningNumbers) {
        String requestBonusNumber = LottoView.requestBonusNumber();
        int bonusNumber = LottoParser.readLineToNumber(requestBonusNumber);
        LottoInputValidator.bonusNumberIsValid(winningNumbers, bonusNumber);
        return bonusNumber;
    }
}
