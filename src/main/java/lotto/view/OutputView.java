package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;

public class OutputView {
    public void printLotto(List<Lotto> lottos) {
        System.out.println(ClientMessage.AFTER_BUY.getMessage().formatted(lottos.size()));
        lottos.forEach(l -> System.out.println(l));
    }

    public void printResultMessage() {
        System.out.println(ClientMessage.WINNING_RESULT.getMessage());
        System.out.println(ClientMessage.SEPARATOR.getMessage());
    }

    public void printLottoResult(LottoResult lottoResult, int count) {
        String resultMessage = ClientMessage.LOTTO_RESULT
                .getMessage()
                .formatted(lottoResult.getResultMessage(), count);
        System.out.println(resultMessage);
    }

    public void printProfit(float profit) {
        String profitMessage = ClientMessage.TOTAL_PROFIT.getMessage().formatted(profit);
        System.out.println(profitMessage);
    }

    public void printError(Exception exception) {
        String errorMessage = ClientMessage.ERROR.getMessage();
        System.out.println(errorMessage.formatted(exception.getMessage()));
    }
}
