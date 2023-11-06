package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoView { //게임 시작 메세지 출력, 구입 금액, 당첨 번호, 보너스 번호 입력 요청, 당첨 통계 및 결과 메세지 출력, 에러 메세지 출력

    private static final DecimalFormat decimalFormat = new DecimalFormat("#,###");
    private static final String PURCHASE_AMOUNT_PROMPT = "구입 금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBER_PROMPT = "당첨 번호를 입력해 주세요";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요";
    private static final String LOTTO_STATISTICS_HEADER = "당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String COUNT_PRIZE_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

    public static String readLottoNumber() {
        System.out.println(LOTTO_NUMBER_PROMPT);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        return Console.readLine();
    }

    public static void writeLottoTickets(Integer purchaseAmount, List<ArrayList<Integer>> lottoTickets) {
        System.out.println(String.format(LOTTO_PURCHASE_MESSAGE, purchaseAmount));
        lottoTickets.forEach(System.out::println);
    }

    public static void writeLottoStatistics(ArrayList<HashMap<String, Integer>> lottoStatistics) {
        System.out.println(LOTTO_STATISTICS_HEADER);
        System.out.println(SEPARATOR);

        lottoStatistics.forEach(statisticsEntity -> {
            int matchCount = statisticsEntity.get("matchCount");
            String prizeAmount = decimalFormat.format(statisticsEntity.get("prizeAmount"));
            int winningCount = statisticsEntity.get("winningCount");
            System.out.println(String.format(COUNT_PRIZE_FORMAT, matchCount, prizeAmount, winningCount));
        });
    }


}
