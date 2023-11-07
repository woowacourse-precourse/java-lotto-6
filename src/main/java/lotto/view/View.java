package lotto.view;

import static lotto.view.LottoMessage.BONUS_BALL_MATCH_MESSAGE;
import static lotto.view.LottoMessage.ENTER_BONUS_NUMBER;
import static lotto.view.LottoMessage.ENTER_WINNING_LOTTO_NUMBER;
import static lotto.view.LottoMessage.MATCH_AND_PRIZE_MESSAGE;
import static lotto.view.LottoMessage.PURCHASE_AMOUNT_MESSAGE;
import static lotto.view.LottoMessage.PURCHASE_LOTTO_AMOUNT_MESSAGE;
import static lotto.view.LottoMessage.TOTAL_PROFIT_RATE_MESSAGE;
import static lotto.view.LottoMessage.WINNING_STATISTICS_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;

public class View {

    public String requestPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public void printPurchasedLottoAmount(int purchasedLottoTickets) {
        System.out.printf(PURCHASE_LOTTO_AMOUNT_MESSAGE.getMessage(), purchasedLottoTickets);
    }

    public void printLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.println(numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]")));
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public String requestWinningNumbers() {
        printMessage(ENTER_WINNING_LOTTO_NUMBER.getMessage());
        return Console.readLine();
    }

    public String requestBonusNumber() {
        printMessage(ENTER_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void displayResults(LottoResult lottoResult) {
        printMessage(WINNING_STATISTICS_MESSAGE.getMessage());
        printRankResults(lottoResult);
        printTotalProfitRate(lottoResult.getProfitRate());
    }

    private void printRankResults(LottoResult lottoResult) {
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .sorted(Comparator.comparingInt(Rank::ordinal).reversed())
                .forEach(rank -> {
                    String bonusMatchMessage = rank == Rank.SECOND ? BONUS_BALL_MATCH_MESSAGE.getMessage() : "";
                    String message = String.format(
                            MATCH_AND_PRIZE_MESSAGE.getMessage(),
                            rank.getMatchCount(),
                            bonusMatchMessage,
                            rank.getPrizeMoney(),
                            lottoResult.getLottoResult().getOrDefault(rank, 0)
                    );
                    printMessage(message);
                });
    }

    private void printTotalProfitRate(BigDecimal profitRate) {
        printMessage(String.format(TOTAL_PROFIT_RATE_MESSAGE.getMessage(), profitRate));
    }
}
