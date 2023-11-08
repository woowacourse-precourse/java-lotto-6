package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.Price;
import lotto.utils.LottoGenerator;
import lotto.utils.NumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    public void run() {
        Price purchasePrice = getPurchasePrice();

        List<Lotto> lottos = getLottos(purchasePrice.getPossibleLotto());
        OutputView.printLottoResult(purchasePrice.getPossibleLotto(), lottos);

        Lotto winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber();

        LottoResult result = new LottoResult(lottos, winningNumber, bonusNumber);
        OutputView.printResultStatistics(result.getResult());
        OutputView.printProfitPercentage(result.getProfitPercentage(purchasePrice.getPrice()));
    }

    private Price getPurchasePrice() {
        String userInput = InputView.getInputPurchaseAmount();
        return toPrice(userInput);
    }

    private Price toPrice(String userInput) {
        try {
            return new Price(userInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
        System.out.println();
        return getPurchasePrice();
    }

    private List<Lotto> getLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i=0; i<amount; ++i) {
            lottos.add(new Lotto(LottoGenerator.generateLottoNumbers()));
        }

        return lottos;
    }

    private Lotto getWinningNumber() {
        String userInput = InputView.getInputWinningNumber();
        return toLotto(userInput);
    }

    private Lotto toLotto(String userInput) {
        try {
            return new Lotto(Arrays.stream(userInput.split(","))
                    .map(Integer::parseInt).toList());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }

        return getWinningNumber();
    }

    private int getBonusNumber() {
        String userInput = InputView.getInputBonusNumber();
        return toBonusNumber(userInput);
    }

    private int toBonusNumber(String userInput) {
        try {
            NumberValidator.validate(userInput);
            return Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }

        return getBonusNumber();
    }
}
