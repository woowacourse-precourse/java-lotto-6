package lotto.controller;

import lotto.model.*;
import lotto.util.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Money money = inputLottoMoney();
        List<Lotto> lottos = purchaseLottos(money);
        Lottos lottoStore = Lottos.of(lottos);
        outputView.outputPurchaseLottos(lottoStore, money.availableLottoCount());

        List<Integer> winningNumber = inputWinningNumber();
        Integer bonusNumber = inputBonusNumber();
        WinningNumbers winningNumbers = winningNumbers(winningNumber, bonusNumber);

        LottoResult lottoResult = LottoResult.of(lottoStore, winningNumbers);
        outputView.outputWinningResult(lottoResult, money.getMoney());
    }

    private WinningNumbers winningNumbers(List<Integer> winningNumber, Integer bonusNumber) {
        try {
            return WinningNumbers.from(winningNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return winningNumbers(winningNumber, inputBonusNumber());
        }
    }

    private List<Integer> inputWinningNumber() {
        try {
            return inputView.inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    private Integer inputBonusNumber() {
        try {
            Integer input = inputView.inputBonusNumber();
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    private static List<Lotto> purchaseLottos(Money money) {
        try {
            List<Lotto> lottos = addLottoByMoney(money);
            return lottos;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseLottos(money);
        }
    }

    private static List<Lotto> addLottoByMoney(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.availableLottoCount(); i++) {
            lottos.add(new Lotto(LottoGenerator.lottoGenerator()));
        }
        return lottos;
    }

    private Money inputLottoMoney() {
        try {
            return new Money(inputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoMoney();
        }
    }

}
