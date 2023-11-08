package lotto.view;

import static lotto.messages.OutputMessages.PURCHASE_COUNT_MESSAGE;
import static lotto.messages.OutputMessages.THREE_DIVIDING_LINES_MESSAGE;
import static lotto.messages.OutputMessages.WINNING_STATISTICS_MESSAGE;

import java.util.List;

import lotto.domain.entity.WinningResult;
import lotto.domain.dto.PurchaseDto;
import lotto.util.OutputUtil;

public class ConsoleOutputView implements OutputView {

    @Override
    public void outputPurchaseLottoList(PurchaseDto purchaseDto) {
        List<List<Integer>> lottos = purchaseDto.getPurchaseLottos();

        System.out.println(purchaseCountMessage(lottos.size()));
        lottos.forEach(lotto -> System.out.println(lotto));
        OutputUtil.printEmptyLine();
    }

    private String purchaseCountMessage(int count) {
        return count + PURCHASE_COUNT_MESSAGE.getMessage();
    }

    @Override
    public void outputWinningStatistics(WinningResult winningResult) {
        System.out.println(WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println(THREE_DIVIDING_LINES_MESSAGE.getMessage());
        System.out.println(winningResult.buildRankingMessage());
        System.out.println(winningResult.buildRateOfReturnMessage());
    }
}
