package lotto.view;

import static lotto.domain.constants.LottoConstants.MATCH_FIVE_COUNT;
import static lotto.domain.constants.LottoConstants.MATCH_FOUR_COUNT;
import static lotto.domain.constants.LottoConstants.MATCH_SIX_COUNT;
import static lotto.domain.constants.LottoConstants.MATCH_THREE_COUNT;
import static lotto.view.message.OutputMessage.ANNOUNCE_FOR_PURCHASE_COUNT;
import static lotto.view.message.OutputMessage.ANNOUNCE_FOR_TOTAL_PROFIT_PERCENTAGE_FORMAT;
import static lotto.view.message.OutputMessage.WINNING_STATISTICS;
import static lotto.view.message.OutputMessage.WinningStatisticsDetails.FIVE_AND_BONUS_MATCH;
import static lotto.view.message.OutputMessage.WinningStatisticsDetails.FIVE_MATCH;
import static lotto.view.message.OutputMessage.WinningStatisticsDetails.FOUR_MATCH;
import static lotto.view.message.OutputMessage.WinningStatisticsDetails.SIX_MATCH;
import static lotto.view.message.OutputMessage.WinningStatisticsDetails.THREE_MATCH;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.result.LottoCalculateResult;
import lotto.domain.result.LottoMatchResult;
import lotto.domain.result.LottoPurchaseResult;
import lotto.domain.Purchase;
import lotto.dto.LottoResultDto;
import lotto.view.message.OutputMessage;
import lotto.view.message.OutputMessage.WinningStatisticsDetails;

public class LottoView {
    public String readInput() {
        return Console.readLine();
    }

    public void displayMessage(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    private void displayFormattedMessage(OutputMessage message, int number) {
        System.out.printf(message.getMessage() + "%n", number);
    }

    private void displayFormattedMessage(OutputMessage message, float percentage) {
        System.out.printf(message.getMessage() + "%n", percentage);
    }

    private void displayFormattedMessage(WinningStatisticsDetails details, int number) {
        System.out.printf(details.getDetail(number) + "%n");
    }

    public void displayPurchasePrice(OutputMessage message, int ticket) {
        displayFormattedMessage(message, ticket);
    }

    public void displayPurchaseResult(LottoPurchaseResult lottoPurchaseResult) {
        Purchase purchase = lottoPurchaseResult.getPurchase();
        List<Lotto> lottos = lottoPurchaseResult.getLottos();

        displayPurchasePrice(ANNOUNCE_FOR_PURCHASE_COUNT, purchase.getFinalRound());
        displayLottoNumber(lottos);
    }

    public void displayLottoNumber(List<Lotto> lottos) {
        lottos.stream().map(Lotto::getNumbers)
                .map(numbers -> numbers.stream().sorted().toList())
                .forEach(System.out::println);
    }

    public void displayResult(LottoResultDto lottoResultDto) {
        LottoMatchResult matchResult = lottoResultDto.getLottoMatchResult();
        LottoCalculateResult calculateResult = lottoResultDto.getLottoCalculateResult();

        displayStatistics(matchResult);
        displayProfitPercentage(calculateResult);
    }

    public void displayStatistics(LottoMatchResult lottoMatchResult) {
        displayMessage(WINNING_STATISTICS);
        displayFormattedMessage(THREE_MATCH, lottoMatchResult.getMatchCounts(MATCH_THREE_COUNT));
        displayFormattedMessage(FOUR_MATCH, lottoMatchResult.getMatchCounts(MATCH_FOUR_COUNT));
        displayFormattedMessage(FIVE_MATCH, lottoMatchResult.getMatchCounts(MATCH_FIVE_COUNT));
        displayFormattedMessage(FIVE_AND_BONUS_MATCH, lottoMatchResult.getBonusMatchCount());
        displayFormattedMessage(SIX_MATCH, lottoMatchResult.getMatchCounts(MATCH_SIX_COUNT));
    }

    public void displayProfitPercentage(LottoCalculateResult calculateResult) {
        float profitPercentage = calculateResult.getProfitPercent();
        displayFormattedMessage(ANNOUNCE_FOR_TOTAL_PROFIT_PERCENTAGE_FORMAT, profitPercentage);
    }
}
