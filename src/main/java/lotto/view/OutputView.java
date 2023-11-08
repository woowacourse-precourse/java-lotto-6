package lotto.view;

import lotto.constants.Constants;
import lotto.constants.message.PurchasedMessage;
import lotto.constants.message.RequestMessage;
import lotto.constants.message.StatisticsMessage;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void requestPayment() {
        System.out.println(RequestMessage.PAYMENT);
    }

    public void requestWinningNumbers() {
        System.out.println(RequestMessage.WINNING_NUMBERS);
    }

    public void requestBonusNumber() {
        System.out.println(RequestMessage.BONUS_NUMBER);
    }

    public void printStatisticsStart() {
        System.out.println(StatisticsMessage.START);
    }

    public void printStatisticsStartLine() {
        System.out.println(StatisticsMessage.START_LINE);
    }

    public void printPurchasedLotto(List<Integer> lottoNumbers) {
        String formattedLotto = formatLottoNumbers(lottoNumbers);

        System.out.printf("%s%s%s\n",
                PurchasedMessage.PURCHASED_LOTTO_START,
                formattedLotto,
                PurchasedMessage.PURCHASED_LOTTO_END);
    }

    private String formatLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(PurchasedMessage.PURCHASED_LOTTO_DELIMITER));
    }

    public void printPurchasedAmount(int amount) {
        System.out.printf(PurchasedMessage.PURCHASE_AMOUNT, amount);
    }

    public void printStatisticsIncludeBonusNumber(int hitCount, int prize, int rankCount) {
        String formattedStatics
                = formatStatistics(StatisticsMessage.CONTENT_INCLUDE_BONUS_NUMBER, hitCount, prize, rankCount);
        System.out.println(formattedStatics);
    }

    public void printStatisticsContent(int hitCount, int prize, int rankCount) {
        String formattedStatics
                = formatStatistics(StatisticsMessage.CONTENT, hitCount, prize, rankCount);
        System.out.println(formattedStatics);
    }

    private String formatStatistics(String message, int hitCount, int prize, int rankCount) {
        DecimalFormat df = new DecimalFormat("###,###");
        String formattedPrize = df.format(prize);
        return String.format(message,
                hitCount,
                formattedPrize,
                rankCount);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(StatisticsMessage.PROFIT_RATE, profitRate);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.printf("%s %s\n",
                Constants.ERROR_PREFIX,
                errorMessage);
    }
}