package lotto.handler;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.OutputUtil;
import lotto.view.OutputView;

public class OutputHandler {
    public static void outputLottosInfo(List<Lotto> lottos){
        OutputView.printMessageBlankLine();
        OutputUtil.outputLottoAmount(lottos.size());
        OutputView.printMessagesWithBlankLine(lottos);
    }
}
