package lotto.output;

import lotto.Lotto;
import lotto.Rank;
import lotto.WinningInformation;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class OutputProcessor {
    public static final String NUMBER_OF_BOUGHT_PROMPT = "%d개를 구매했습니다.";
    public static final String DEFAULT_SEPARATOR = ", ";
    public static final String LEFT_BRACKET = "[";
    public static final String RIGHT_BRACKET = "]";
    public static final String WINNING_INFORMATION_PROMPT = "%d개 일치 (%s원) - %d개";
    public static final String WINNING_INFORMATION_HEADER_PROMPT = "당첨통계\n---";
    public static final String AMOUNT_PATTERN = "#,###";
    public static final String PROFITABILITY_PATTERN = "#,##0.00";
    public static final String PURCHASE_MONEY_INPUT_PROMPT = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_PROMPT = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_PROMPT = "보너스 번호를 입력해 주세요.";
    public static final String PROFITABILITY_PROMPT = "총 수익률은 %s원입니다.";
    private final OutputSender outputSender;

    public OutputProcessor(OutputSender outputSender) {
        this.outputSender = outputSender;
    }

    public void outputPurchaseMoneyInputMessage() {
        outputSender.send(PURCHASE_MONEY_INPUT_PROMPT);
    }

    public void outputWinningNumberInputMessage() {
        outputSender.send(WINNING_NUMBER_INPUT_PROMPT);
    }

    public void outputBonusNumberInputMessage() {
        outputSender.send(BONUS_NUMBER_INPUT_PROMPT);
    }

    public void outputNumberOfLottos(int numberOfLottos) {
        outputSender.send(String.format(NUMBER_OF_BOUGHT_PROMPT, numberOfLottos));
    }

    public void outputLotto(Lotto lotto) {
        List<String> numbers = lotto.getLottoNumbers().stream()
                .map(String::valueOf)
                .toList();
        outputSender.send(LEFT_BRACKET +
                String.join(DEFAULT_SEPARATOR, numbers) +
                RIGHT_BRACKET);
    }

    public void outputWinningInformation(WinningInformation winningInformation) {
        outputSender.send(WINNING_INFORMATION_HEADER_PROMPT);
        outputWinningDetails(winningInformation.getWinningCount());
        outputProfitability(winningInformation.getProfitability());
    }

    public void outputProfitability(double profitability) {
        DecimalFormat amountFormat = new DecimalFormat(PROFITABILITY_PATTERN);
        String formattedProfitability = amountFormat.format(profitability);
        outputSender.send(String.format(PROFITABILITY_PROMPT, formattedProfitability));
    }

    private void outputWinningDetails(Map<Rank, Integer> winningCounts) {
        Arrays.stream(Rank.values())
                .sorted(Comparator.comparingInt(Rank::getPlace))
                .filter(rank -> rank != Rank.LOSER)
                .forEach(rank -> outputWinningDetail(rank, winningCounts));
    }

    private String formatIntegerToAmount(int amount) {
        DecimalFormat amountFormat = new DecimalFormat(AMOUNT_PATTERN);
        return amountFormat.format(amount);
    }

    private void outputWinningDetail(Rank rank, Map<Rank, Integer> winningCounts) {
        String formattedPrompt = String.format(
                WINNING_INFORMATION_PROMPT,
                rank.getMatchingNumberCount(),
                formatIntegerToAmount(rank.getPrize()),
                winningCounts.get(rank)
        );
        outputSender.send(formattedPrompt);
    }
}
