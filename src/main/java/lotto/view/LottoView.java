package lotto.view;

import static lotto.model.LottoStatistics.*;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.util.ErrorMessage;

public class LottoView { //게임 시작 메세지 출력, 구입 금액, 당첨 번호, 보너스 번호 입력 요청, 당첨 통계 및 결과 메세지 출력, 에러 메세지 출력

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBER_PROMPT = "당첨 번호를 입력해 주세요";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요";
    private static final String LOTTO_STATISTICS_HEADER = "당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String COUNT_PRIZE_FORMAT = "%s (%s원) - %d개";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public static String readWinningNumber() {
        System.out.println(LOTTO_NUMBER_PROMPT);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public static String readBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public static void printLottoTickets(Integer purchaseNumber, ArrayList<Lotto> lottoTickets) {
        System.out.println(String.format(LOTTO_PURCHASE_MESSAGE, purchaseNumber));
        lottoTickets.forEach(lottoNumber -> {
            List<Integer> numbers = new ArrayList<>(lottoNumber.getNumbers());
            numbers.sort(Comparator.naturalOrder());
            System.out.println(numbers);
        });
        System.out.println();
    }

    public static void printLottoStatistics(LinkedHashMap<PrizeInformation, Integer> lottoStatistics) {
        System.out.println(LOTTO_STATISTICS_HEADER);
        System.out.println(SEPARATOR);

        lottoStatistics.forEach((key, value) -> {
            String rankMessage = key.getRankMessage();
            String prizeAmount = DECIMAL_FORMAT.format(key.getPrizeAmount());
            int winningCount = value;
            System.out.println(String.format(COUNT_PRIZE_FORMAT, rankMessage, prizeAmount, winningCount));
        });
    }

    public static void printLottoProfit(double profit) {
        System.out.println(String.format(TOTAL_PROFIT_MESSAGE, profit));
    }

    public static void displayErrorMessage(Exception ex) {
        System.out.println(ErrorMessage.ERROR_MESSAGE_HEADER + ex.getMessage());
    }
}
