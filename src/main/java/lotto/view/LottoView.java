package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.util.ErrorMessage;

public class LottoView { //게임 시작 메세지 출력, 구입 금액, 당첨 번호, 보너스 번호 입력 요청, 당첨 통계 및 결과 메세지 출력, 에러 메세지 출력

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");
    private static final String PURCHASE_AMOUNT_PROMPT = "구입 금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBER_PROMPT = "당첨 번호를 입력해 주세요";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요";
    private static final String LOTTO_STATISTICS_HEADER = "당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String COUNT_PRIZE_FORMAT = "%s (%s원) - %d개";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private enum Ranks {
        FIFTH(5, "3개 일치"),
        FOURTH(4, "4개 일치"),
        THIRD(3, "5개 일치"),
        SECOND(2, "5개 일치, 보너스 볼 일치"),
        FIRST(1, "6개 일치");

        private final int rank;
        private final String rankMessage;

        Ranks(int rank, String rankMessage) {
            this.rank = rank;
            this.rankMessage = rankMessage;
        }
        private int getRank() {
            return rank;
        }

        private String getRankMessage() {
            return rankMessage;
        }

        private static String getRankMessageByRank(int rank) {
            for (Ranks ranking : values()) {
                if(ranking.getRank() == rank) {
                    return ranking.getRankMessage();
                }
            }
            return null;
        }
    }


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
            int rank = statisticsEntity.get("rank");
            String rankMessage = Ranks.getRankMessageByRank(rank);
            String prizeAmount = DECIMAL_FORMAT.format(statisticsEntity.get("prizeAmount"));
            int winningCount = statisticsEntity.get("winningCount");
            System.out.println(String.format(COUNT_PRIZE_FORMAT, rankMessage, prizeAmount, winningCount));
        });
    }

    public static void writeLottoProfit(double profit) {
        System.out.println(String.format(TOTAL_PROFIT_MESSAGE, profit));
    }

    public static void displayErrorMessage(Exception ex) {
        System.out.println(ErrorMessage.ERROR_MESSAGE_HEADER + ex.getMessage());
    }
}
