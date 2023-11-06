package lotto.view;

import java.util.List;
import lotto.domain.IssuedLottos;
import lotto.utility.io.Writer;
import lotto.utility.vo.LottoResponse;
import lotto.utility.vo.WinningResponse;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_MESSAGE = "\n당첨 통계\n---";

    public void informIssuedLottos(List<LottoResponse> lottos) {
        Writer.println(" ");
        Writer.print(lottos.size());
        Writer.println(NUMBER_OF_LOTTOS_MESSAGE);

        lottos.stream()
            .map(LottoResponse::createMessage)
            .forEach(Writer::println);
    }

    public void informWinningResult(WinningResponse winningResponse) {
        Writer.println(WINNING_MESSAGE);
        winningResponse.createdMessage()
            .stream()
            .forEach(Writer::println);
    }
}
