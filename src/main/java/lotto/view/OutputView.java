package lotto.view;

import java.util.List;
import lotto.message.OutMessage;
import lotto.model.Lotto;

public class OutputView {


    public void printNumberOfLotto(List<Lotto> lottos) {
        System.out.println(String.format(OutMessage.OUT_NUMBER_OF_LOTTO.getMessage(), lottos.size()));
        for (var lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStatics() {
        System.out.println(OutMessage.OUT_WINNING_STATISTICS.getMessage());
    }

    public void printTotalReturn(double totalReturn) {
        System.out.println(String.format(OutMessage.OUT_TOTAL_RETURN.getMessage(), totalReturn));
    }
}
