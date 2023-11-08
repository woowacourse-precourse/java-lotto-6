package lotto.view;

import static lotto.utils.constants.ErrorConstants.formatError;
import static lotto.utils.constants.LottoConstants.MATCH_FIVE_COUNT;
import static lotto.utils.constants.LottoConstants.MATCH_FOUR_COUNT;
import static lotto.utils.constants.LottoConstants.MATCH_SIX_COUNT;
import static lotto.utils.constants.LottoConstants.MATCH_THREE_COUNT;
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
import lotto.domain.result.CalculateResult;
import lotto.domain.result.MatchResult;
import lotto.domain.result.PurchaseResult;
import lotto.domain.Purchase;
import lotto.dto.ResultDto;
import lotto.exception.LottoException;
import lotto.view.message.OutputMessage;
import lotto.view.message.OutputMessage.WinningStatisticsDetails;

public class View {
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

    public void displayPurchaseResult(PurchaseResult purchaseResult) {
        Purchase purchase = purchaseResult.getPurchase();
        List<Lotto> lottos = purchaseResult.getLottos();

        displayPurchasePrice(ANNOUNCE_FOR_PURCHASE_COUNT, purchase.getFinalRound());
        displayLottoNumber(lottos);
    }

    public void displayLottoNumber(List<Lotto> lottos) {
        lottos.stream().map(Lotto::getNumbers)
                .map(numbers -> numbers.stream().sorted().toList())
                .forEach(System.out::println);
    }

    public void displayResult(ResultDto resultDto) {
        MatchResult matchResult = resultDto.getLottoMatchResult();
        CalculateResult calculateResult = resultDto.getLottoCalculateResult();

        displayStatistics(matchResult);
        displayProfitPercentage(calculateResult);
    }

    public void displayStatistics(MatchResult matchResult) {
        displayMessage(WINNING_STATISTICS);
        displayFormattedMessage(THREE_MATCH, matchResult.getMatchCounts(MATCH_THREE_COUNT));
        displayFormattedMessage(FOUR_MATCH, matchResult.getMatchCounts(MATCH_FOUR_COUNT));
        displayFormattedMessage(FIVE_MATCH, matchResult.getMatchCounts(MATCH_FIVE_COUNT));
        displayFormattedMessage(FIVE_AND_BONUS_MATCH, matchResult.getBonusMatchCount());
        displayFormattedMessage(SIX_MATCH, matchResult.getMatchCounts(MATCH_SIX_COUNT));
    }

    public void displayProfitPercentage(CalculateResult calculateResult) {
        float profitPercentage = calculateResult.getProfitMargin();
        displayFormattedMessage(ANNOUNCE_FOR_TOTAL_PROFIT_PERCENTAGE_FORMAT, profitPercentage);
    }

    public void displayErrorMessage(LottoException e) {
        System.out.println(formatError(e.getMessage()));
    }

}
