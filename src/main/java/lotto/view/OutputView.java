package lotto.view;

import java.util.List;
import lotto.utility.io.Writer;
import lotto.vo.response.LottoResponse;
import lotto.vo.response.ProfitResponse;
import lotto.vo.response.WinningResponse;

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

    public void informProfit(ProfitResponse profitResponse) {
        Writer.println(profitResponse.createMessage());
    }

    public void informErrorMessage(String message) {
        Writer.println(message);
    }
}
