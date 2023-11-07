package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.view.constant.OutputMessage;

import java.util.List;

import static lotto.view.constant.OutputMessage.*;

public class OutputView {
    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d" + COUNT.getMessage() + "\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void result(Result result) {
        System.out.println(STATICS.getMessage());
        System.out.printf(FIFTH.getMessage() + "%d\n" +
                FOURTH.getMessage()+ "%d\n" +
                THIRD.getMessage() +"%d\n" +
                SECOND.getMessage() +"%d\n" +
                FIRST.getMessage() + "%d\n",
                result.getFifth(), result.getFourth(), result.getThird(), result.getSecond(), result.getFirst());
    }


}
