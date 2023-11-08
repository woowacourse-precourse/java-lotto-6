package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.service.LottoService;
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
        Lotto WinningNumbers = getWinningNumbers();
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

}
