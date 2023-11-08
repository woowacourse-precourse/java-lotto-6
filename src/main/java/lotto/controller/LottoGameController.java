package lotto.controller;

import static lotto.domain.NumberType.ORIGINAL;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.NumberType;
import lotto.domain.PurchaseMoney;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumber;
import lotto.domain.validator.WinningNumberValidator;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoGameController(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void startGame() {
        PurchaseMoney purchaseMoney = getPurchaseMoney();
        LottoGenerator lottoGenerator =  LottoGenerator.of(lottoNumberGenerator, purchaseMoney);
        Lottos lottos = createLottos(purchaseMoney, lottoGenerator);
        List<WinningNumber> onlyWinningNumber = createWinningLotto();
    }


    private List<WinningNumber> createWinningLotto() {
        String winningNumber = InputView.getWinningNumbers();
        try {
            List<Integer> winnings = WinningNumberValidator.validateWinningNumber(winningNumber);
            return createWinningNumber(winnings);
        } catch(IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());

            return createWinningLotto();
        }
    }


    private List<WinningNumber> createWinningNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> WinningNumber.of(number, ORIGINAL)).toList();
    }





    private static PurchaseMoney getPurchaseMoney() {
        try {
            return PurchaseMoney.of(InputView.getPurchaseMoney());
        } catch(IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());

            return getPurchaseMoney();
        }
    }

    private Lottos createLottos(PurchaseMoney purchaseMoney, LottoGenerator lottoGenerator) {
        Lottos lottos = lottoGenerator.createLottos();

        OutputView.printPurchaseCount(purchaseMoney.buyCount());
        OutputView.printLottos(lottos);
        return lottos;
    }



}
