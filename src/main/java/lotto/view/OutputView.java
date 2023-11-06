package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.constants.OutputMessage;
import lotto.controller.LottoController;
import lotto.domain.Judgement;

public class OutputView {
    public void outputTotalResult(Judgement judgement) {
        judgement.outputResult();
    }

    public void outputLottosNumbers(List<Lotto> MY_LOTTOS) {
        System.out.printf(String.valueOf(OutputMessage.OUTPUT_MESSAGE_HOW_MANY_BUY_LOTTOS), MY_LOTTOS.size());
        for (Lotto lotto : MY_LOTTOS) {
            System.out.println(lotto);
        }
        System.out.println("");
    }

    public void outputTotalResult(double ratioOfReturn) {
        System.out.printf(String.valueOf(OutputMessage.OUTPUT_MESSAGE_TOTAL_REWARD), ratioOfReturn);
    }
}
