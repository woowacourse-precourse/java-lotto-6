package lotto.view;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoWinningTier;
import lotto.dto.LottoStatisticsResult;
import lotto.dto.LottoTickets;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ConsoleOutputView implements OutputView {
    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PRINT_LOTTO_TICKETS_SIZE = "개를 구매했습니다.";
    private static final String PRINT_LOTTO_NUMBERS = "[%s]%n";
    private static final String REQUEST_LOTTO_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ALERT_STATISTICS = "당첨 통계\n---";
    private static final String MATCH_COUNT = "%d개 일치";
    private static final String REQUIRE_MATCH_BONUS = ", 보너스 볼 일치";
    private static final String PRIZE_AMOUNT = " (%s원)";
    private static final String WINNING_COUNT = " - %d개";
    private static final String PERCENT_OF_TOTAL_WINNING_AMOUNT = "총 수익률은 %.1f%%입니다.";

    @Override
    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
    }

    @Override
    public void printLottoTickets(LottoTickets lottoTickets) {
        List<Lotto> tickets = lottoTickets.getLottoTickets();
        System.out.println(tickets.size() + PRINT_LOTTO_TICKETS_SIZE);
        tickets.forEach(this::printLottoNumbers);
    }

    private void printLottoNumbers(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getSortedLottoNumbers();
        String numbersJoinComma = lottoNumbers.stream()
                .map(LottoNumber::lottoNumberValue)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.printf(PRINT_LOTTO_NUMBERS, numbersJoinComma);
    }

    @Override
    public void requestLottoWinningNumbers() {
        System.out.println(REQUEST_LOTTO_WINNING_NUMBERS);
    }

    @Override
    public void requestBonusLottoNumber() {
        System.out.println(REQUEST_BONUS_LOTTO_NUMBER);
    }

    @Override
    public void printLottoStatisticsResult(LottoStatisticsResult lottoStatisticsResult) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(ALERT_STATISTICS);
        lottoStatisticsResult.getWinningCounts()
                .forEach((tier, count) -> createStatisticsWinningCount(stringJoiner, tier, count));
        stringJoiner.add(String.format(PERCENT_OF_TOTAL_WINNING_AMOUNT,
                lottoStatisticsResult.getPercentOfTotalWinningAmount()));
        System.out.println(stringJoiner);
    }

    private void createStatisticsWinningCount(StringJoiner stringJoiner, LottoWinningTier tier, int count) {
        Amount prizeAmount = tier.getPrizeAmount();

        stringJoiner.add(new StringBuilder()
                .append(String.format(MATCH_COUNT, tier.getMatchCount()))
                .append(createBonusText(tier.isRequireMatchBonus()))
                .append(String.format(PRIZE_AMOUNT, prizeAmount.getDecimalFormatAmount()))
                .append(String.format(WINNING_COUNT, count))
        );
    }

    private String createBonusText(boolean requireMatchBonus) {
        if (requireMatchBonus) {
            return REQUIRE_MATCH_BONUS;
        }

        return "";
    }

    @Override
    public void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
