package lotto;

import java.util.HashMap;
import java.util.List;
import lotto.view.Input;
import lotto.view.Output;

public class Controller {
    private final Input input = new Input();
    private final Output output = new Output();
    private List<List<Integer>> lottos;

    void buy() {
        Integer paymentAmount = input.readPaymentAmount();
        LottoMachine lottoMachine = new LottoMachine(paymentAmount);
        lottoMachine.issue();
        output.printPurchaseCount(lottoMachine.getCount());
        this.lottos = lottoMachine.getLottos();
        output.printLottos(lottos);
    }

    void win() {
        List<Integer> winningNumbers = input.readWinningNumbers();
        Integer bonusNumber = input.readBonusNumber();

        HashMap<String, Integer> count = (new Rank(lottos, winningNumbers, bonusNumber).getCount());
        output.printResult(count);
    }
}
