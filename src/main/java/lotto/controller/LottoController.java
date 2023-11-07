package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private LottoStore lottoStore = new LottoStore();
    private List<Lotto> purchaseLottoList;

    public void start() {
        InputPurchaseAmount();
        OutputView.printLottoList(purchaseLottoList);
        InputWinningNumbers();
        InputBonusNumber();
    }

    public void InputPurchaseAmount() {
        try {
            OutputView.askPurchaseAmount();
            String purchaseAmount = InputView.getUserInput();
            purchaseLottoList = lottoStore.buyLottos(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void InputWinningNumbers() {
        OutputView.askWinningNumbers();
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        lottoStore.setWinningNumbers(winningNumbers);
    }

    private void InputBonusNumber() {
        OutputView.askBonusNumber();
        Integer bonusNumber = InputView.inputBonusNumber();
        lottoStore.setBonusNumber(bonusNumber);
    }
}
