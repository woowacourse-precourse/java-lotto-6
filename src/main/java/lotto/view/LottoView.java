package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class LottoView {

    private final InputView inputView;
    private final OutputView outputView;


    public LottoView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int inputPurchaseAmount() {
        while (true) {
            try {
                return inputView.inputPurchaseAmount();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }

    public void printLottos(List<Lotto> lottos) {
        outputView.printLottos(lottos);
    }

    public List<Integer> inputWinningNumber(){
        while (true) {
            try {
                return inputView.inputWinningNumber();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                return inputView.inputBonusNumber();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }

    public void printResult(Map<Rank, Long> results, double profitRate) {
        outputView.printResult(results, profitRate);
    }
}
