package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.message.OutputMessage;

public class OutputView {

    public static void printIssueResults(List<Lotto> lottos) {
        OutputMessage.ISSUED_LOTTO_COUNT.print(lottos.size());
        lottos.forEach(Lotto::printNumbers);
    }
}
