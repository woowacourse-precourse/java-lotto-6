package lotto.controller;


import java.util.List;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.enumerate.NumberType;
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

        WinningLotto winningLotto = getBonusNumber(onlyWinningNumber);

        LottoResult result = lottos.determine(winningLotto);
        OutputView.printLottoResult(result.getRanks(), result.calculateRate(purchaseMoney));
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
                .map(number -> WinningNumber.of(number, NumberType.ORIGINAL)).toList();
    }


    private static WinningLotto getBonusNumber(List<WinningNumber> winningNumbers) {
        try{
            WinningNumber bonus = WinningNumber.of(InputView.getBonusNumber(), NumberType.BONUS);
            return WinningLotto.of(winningNumbers, bonus);
        } catch(IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());

            return getBonusNumber(winningNumbers);
        }
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
