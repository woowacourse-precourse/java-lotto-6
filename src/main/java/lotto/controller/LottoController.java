package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
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
        printWinningStatics(winningStatics, purchasePrice);
    }

    private int getPurchasePrice() {
        while (true) {
            try {
                String input = inputView.getPurchasePrice();
                PurchasePriceValidator.validIsInt(input);
                int purchasePrice = Integer.parseInt(input);
                PurchasePriceValidator.validIsMultiplesOfThousand(purchasePrice);
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> purchaseLottos(int price) {
        List<Lotto> lottos = lottoService.publishLottos(price);
        outputView.printPurchaseLottos(lottos);
        return lottos;
    }

    private Lotto getWinningNumbers() {
        while (true) {
            try {
                String input = inputView.getWinningNumbers();
                WinningNumbersValidator.validate(input);
                return convertStringToLotto(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto convertStringToLotto(String input) {
        String[] digits = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String digit : digits) {
            WinningNumbersValidator.validDigitIsInt(digit);
            winningNumbers.add(Integer.parseInt(digit));
        }
        Collections.sort(winningNumbers);
        return new Lotto(winningNumbers);
    }

    private Bonus getBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                String input = inputView.getBonusNumber();
                BonusNumberValidator.validIsInt(input);
                int bonusNumber = Integer.parseInt(input);
                BonusNumberValidator.validIsNotDuplicateWithWinningNumbers(bonusNumber, winningNumbers);
                return new Bonus(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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

    private void printWinningStatics(WinningStatics winningStatics, int purchasePrice) {
        float rateOfReturn = winningStatics.getRateOfReturn(purchasePrice);
        outputView.printWinningStatics(winningStatics);
        outputView.printRateOfReturn(rateOfReturn);
    }

}
