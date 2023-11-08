package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.WinningStatics;
import lotto.service.LottoService;
import lotto.utils.BonusNumberValidator;
import lotto.utils.PurchasePriceValidator;

import lotto.utils.WinningNumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService = new LottoService();

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int purchasePrice = getPurchasePrice();
        List<Lotto> lottos = purchaseLottos(purchasePrice);
        Lotto winningNumbers = getWinningNumbers();
        Bonus bonusNumber = getBonusNumber(winningNumbers);
        WinningStatics winningStatics = getWinningStatics(lottos, winningNumbers, bonusNumber);
    }

    private int getPurchasePrice() {
        String input = inputView.getPurchasePrice();
        PurchasePriceValidator.validIsInt(input);
        int purchasePrice = Integer.parseInt(input);
        PurchasePriceValidator.validIsMultiplesOfThousand(purchasePrice);
        return purchasePrice;
    }

    private List<Lotto> purchaseLottos(int price) {
        List<Lotto> lottos = lottoService.publishLottos(price);
        outputView.printPurchaseLottos(lottos);
        return lottos;
    }

    private Lotto getWinningNumbers() {
        String input = inputView.getWinningNumbers();
        WinningNumbersValidator.validate(input);
        return convertStringToLotto(input);
    }

    private Lotto convertStringToLotto(String input) {
        String[] digits = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String digit : digits) {
            WinningNumbersValidator.validDigitIsInt(digit);
            winningNumbers.add(Integer.parseInt(digit));
        }
        return new Lotto(winningNumbers);
    }

    private Bonus getBonusNumber(Lotto winningNumbers) {
        String input = inputView.getBonusNumber();
        BonusNumberValidator.validIsInt(input);
        int bonusNumber = Integer.parseInt(input);
        BonusNumberValidator.validIsNotDuplicateWithWinningNumbers(bonusNumber, winningNumbers);
        return new Bonus(bonusNumber);
    }

    private WinningStatics getWinningStatics(
            List<Lotto> lottos, Lotto winningNumbers, Bonus bonusNumber) {
        WinningStatics winningStatics = new WinningStatics();
        for (Lotto lotto : lottos) {
            int matchCount = lottoService.getMatchCount(lotto, winningNumbers);
            boolean isMatchBonus = lottoService.getIsMatchBonus(lotto, bonusNumber);
            winningStatics.applyLottoResult(matchCount, isMatchBonus);
        }
        return winningStatics;
    }

}
