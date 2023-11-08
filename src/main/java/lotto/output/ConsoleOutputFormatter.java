package lotto.output;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningInformation;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ConsoleOutputFormatter implements OutputFormatter {
    private static final String NUMBER_OF_BOUGHT_PROMPT = "%d개를 구매했습니다.";
    private static final String DEFAULT_SEPARATOR = ", ";
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";
    private static final String WINNING_INFORMATION_PROMPT = "%d개 일치%s (%s원) - %d개";
    private static final String SECOND_PLACE_ADDITIONAL_MESSAGE = ", 보너스 볼 일치";
    private static final String WINNING_INFORMATION_HEADER_PROMPT = "당첨 통계\n---";
    private static final String AMOUNT_PATTERN = "#,###";
    private static final String PROFITABILITY_PATTERN = "#,##0.0";
    private static final String NEW_LINE = "\n";
    private static final String PURCHASE_MONEY_INPUT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String PROFITABILITY_PROMPT = "총 수익률은 %s%%입니다.";
    public static final String ERROR_MESSAGE_HEADER = "[ERROR] ";

    @Override
    public String formatPurchaseMoneyInputMessage() {
        return PURCHASE_MONEY_INPUT_PROMPT;
    }

    @Override
    public String formatWinningNumberInputMessage() {
        return WINNING_NUMBER_INPUT_PROMPT;
    }

    @Override
    public String formatBonusNumberInputMessage() {
        return BONUS_NUMBER_INPUT_PROMPT;
    }

    @Override
    public String formatNumberOfLottos(int numberOfLottos) {
        return String.format(NUMBER_OF_BOUGHT_PROMPT, numberOfLottos);
    }

    @Override
    public String formatLotto(Lotto lotto) {
        List<String> numbers = lotto.getLottoNumbers().stream()
                .sorted()
                .map(String::valueOf)
                .toList();

        return LEFT_BRACKET +
                String.join(DEFAULT_SEPARATOR, numbers) +
                RIGHT_BRACKET;
    }

    @Override
    public String formatWinningInformation(WinningInformation winningInformation) {
        outputWinningDetails(winningInformation.getWinningCounts());
        return WINNING_INFORMATION_HEADER_PROMPT +
                NEW_LINE +
                outputWinningDetails(winningInformation.getWinningCounts()) +
                formatProfitability(winningInformation.getProfitability());
    }

    private String formatProfitability(double profitability) {
        DecimalFormat amountFormat = new DecimalFormat(PROFITABILITY_PATTERN);
        String formattedProfitability = amountFormat.format(profitability);
        return String.format(PROFITABILITY_PROMPT, formattedProfitability);
    }

    @Override
    public String formatError(String errorMessage) {
        return ERROR_MESSAGE_HEADER + errorMessage;
    }

    private String outputWinningDetails(Map<Rank, Integer> winningCounts) {
        StringBuilder result = new StringBuilder();
        Arrays.stream(Rank.values())
                .sorted(Comparator.comparingInt(Rank::getPrize))
                .filter(rank -> rank != Rank.LOSER)
                .forEach(rank -> {
                    result.append(outputWinningDetail(rank, winningCounts))
                            .append(NEW_LINE);
                });

        return result.toString();
    }

    private String formatIntegerToAmount(int amount) {
        DecimalFormat amountFormat = new DecimalFormat(AMOUNT_PATTERN);
        return amountFormat.format(amount);
    }

    private String outputWinningDetail(Rank rank, Map<Rank, Integer> winningCounts) {
        String additionalMessage = "";
        if (rank == Rank.SECOND) {
            additionalMessage = SECOND_PLACE_ADDITIONAL_MESSAGE;
        }
        return String.format(
                WINNING_INFORMATION_PROMPT,
                rank.getMatchingNumberCount(),
                additionalMessage,
                formatIntegerToAmount(rank.getPrize()),
                winningCounts.get(rank)
        );
    }
}
