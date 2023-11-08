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
        String formattedLotto = lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(PurchasedMessage.PURCHASED_LOTTO_DELIMITER));
        String content = String.format("%s%s%s",
                PurchasedMessage.PURCHASED_LOTTO_START,
                formattedLotto,
                PurchasedMessage.PURCHASED_LOTTO_END
        );
        System.out.println(content);
    }

    public void printStatisticsContent(int hitCount, int prize, int rankCount) {
        DecimalFormat df = new DecimalFormat("###,###");
        String prizeWithComma = df.format(prize);
        String content = String.format(StatisticsMessage.CONTENT,
                hitCount,
                prizeWithComma,
                rankCount);
        System.out.println(content);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.printf("%s %s",
                Constants.ERROR_PREFIX,
                errorMessage);
    }
}