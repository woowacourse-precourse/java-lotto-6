package lotto.Controller;

import lotto.domian.BoughtLotto;
import lotto.domian.Lotto;
import lotto.domian.LottoAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private List<List<Integer>> boughtLottos = new ArrayList<>();
    private Lotto lotto;
    private List<Integer> numbers;
    private int bonusNuber;
    public void run() {
        start();
    }

    private void start() {
        long lottoAmount = inputLottoAmount();
        OutputView.printLottoAmount(lottoAmount);

        printBoughtLotto(lottoAmount);
        printWinningAndBonusNumber();
    }

    private long inputLottoAmount() {
        LottoAmount lottoAmountCount = new LottoAmount(InputView.inputAmount());
        return lottoAmountCount.calculateLottoAmount();
    }

    private void printBoughtLotto(long lottoAmount) {
        long count = lottoAmount;
        while (count-- > 0) {
            BoughtLotto boughtLotto = new BoughtLotto();
            boughtLottos.add(boughtLotto.generateLottoNumbers());
        }
        for (List<Integer> lotto : boughtLottos) {
            System.out.println(lotto);
        }
    }

    private void printWinningAndBonusNumber() {
        System.out.println();
        numbers = InputView.inputWinningNumbers();
        System.out.println();
        bonusNuber = InputView.inputBonusNumber();
    }
}
