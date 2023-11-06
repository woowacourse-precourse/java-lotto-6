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

        WinningNumbers winningNumbers = inputWinningNumbers();

        LottoResult lottoResult = LottoResult.of(lottoStore, winningNumbers);
        outputView.outputWinningResult(lottoResult, money.getMoney());
    }

    private WinningNumbers inputWinningNumbers() {
        WinningNumbers winningNumbers = WinningNumbers.from(stringToInteger(inputView.inputWinningNumbers()), Integer.parseInt(inputView.inputBonusNumber()));
        return winningNumbers;
    }

    private static List<Lotto> purchaseLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.availableLottoCount(); i++) {
            lottos.add(new Lotto(LottoGenerator.lottoGenerator()));
        }
        return lottos;
    }

    private Money inputLottoMoney() {
        return new Money(Integer.parseInt(inputView.inputMoney()));
    }

    private List<Integer> stringToInteger(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] split = input.split(",");
        for (String s : split) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }
}
