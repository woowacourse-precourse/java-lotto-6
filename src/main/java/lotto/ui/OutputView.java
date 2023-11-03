package lotto.ui;

import lotto.domain.Lotto;
import lotto.ui.message.OutputMessage;

import java.util.List;

public class OutputView {

    public void print(OutputMessage outputMessage) {
        System.out.println(outputMessage.getComment());
    }

    public void printLottoCount(Integer lottoCount) {
        System.out.println("" + lottoCount + OutputMessage.PRINT_LOTTO_COUNT.getComment());
    }

    //TODO: getter사용 고민해보기
    public void printLottoBundle(List<Lotto> lottoBundle) {
        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.getNumbers());
        }
    }
}
