package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class View {

    private static final String COMMA = ",";
    private static final String BLANK = "";
    private static final String ASK_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String SHOW_PURCHASE_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String SHOW_LOTTO_STATISTIC = "당첨 통계" + "\n" + "---";
    private static final String SHOW_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";
    private static final String ERROR_NEED_NUMBER = "[ERROR] 숫자를 입력해 주세요.";
    private static final String ERROR_INVALID_LOTTO_FORMAT = "[ERROR] 당첨 번호 6자를 %s로 구분하여 입력해 주세요.".formatted(COMMA);

    public int askPurchaseMoney() {
        println(ASK_PURCHASE_MONEY);
        return askNumber();
    }

    public List<Integer> askWinningNumbers() {
        printBlankLine();
        println(ASK_WINNING_NUMBERS);
        return askNumbers();
    }

    public int askBonusNumber() {
        printBlankLine();
        println(ASK_BONUS_NUMBER);
        return askNumber();
    }

    public void showLottoTickets(List<Lotto> lottoTickets) {
        printBlankLine();
        println(lottoTickets.size() + SHOW_PURCHASE_LOTTO_COUNT);
        for (Lotto lotto : lottoTickets) {
            println(lotto.toString());
        }
    }

    public void showLottoResult(LottoResult result) {
        printBlankLine();
        println(SHOW_LOTTO_STATISTIC);
        Map<LottoRank, Integer> rankToCount = result.rankToCount();
        for (LottoRank rank : LottoRank.valuesReverse()) {
            println(showMatchCount(rank) + " " + showWinningMoney(rank) + " - " + showRankCount(rankToCount, rank));
        }
        println(SHOW_RATE_OF_RETURN.formatted(result.rateOfReturn()));
    }

    private static String showRankCount(Map<LottoRank, Integer> rankToCount, LottoRank rank) {
        return rankToCount.getOrDefault(rank, 0) + "개";
    }

    private String showWinningMoney(LottoRank rank) {
        return "(" + NumberFormat.getInstance().format(rank.getWinningMoney()) + "원)";
    }

    private String showMatchCount(LottoRank rank) {
        return rank.getMatchCount() + "개 일치";
    }

    private int askNumber() {
        return toNumber(readLine(), ERROR_NEED_NUMBER);
    }

    private List<Integer> askNumbers() {
        String input = readLine();
        List<Integer> numbers = new ArrayList<>();
        for (String numberCandidate : input.split(COMMA)) {
            numbers.add(toNumber(numberCandidate, ERROR_INVALID_LOTTO_FORMAT));
        }
        return numbers;
    }

    private int toNumber(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(errorMessage);
        }
    }

    private void printBlankLine() {
        println(BLANK);
    }

    private String readLine() {
        return Console.readLine();
    }

    private void println(String message) {
        System.out.println(message);
    }
}
