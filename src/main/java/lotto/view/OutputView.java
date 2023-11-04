package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.domain.Judgement;

public class OutputView {
    public void outputLottosNumbers(List<Lotto> inputLotto) {
        System.out.printf("\n%d개를 구매했습니다.\n", inputLotto.size());
        for (Lotto lotto : inputLotto) {
            System.out.println(lotto);
        }
        System.out.println("");
    }

    public void outputTotalResult(Judgement judgement) {
        judgement.outputResult();
    }
}
