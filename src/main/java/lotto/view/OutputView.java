package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.message.Output;

public class OutputView {

    public static void printIssueResults(List<Lotto> lottos) {
        Output.ISSUED_LOTTO_COUNT.print(lottos.size());
        lottos.forEach(Lotto::printNumbers);
    }
}
