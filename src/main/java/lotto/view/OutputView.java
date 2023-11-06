package lotto.view;

import lotto.Prize;

import java.util.Map;

public class OutputView {

    private static final String INPUT_BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUM_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_RESULT_BAR_MESSAGE = "당첨 통계";
    private static final String TOTAL_RATE_MESSAGE = "총 수익률은 ";

    public static void inputBuyMessage(){
        System.out.println(INPUT_BUY_MESSAGE);
    }

    public static void inputWinningNumMessage(){
        System.out.println(INPUT_WINNING_NUM_MESSAGE);
    }

    public static void inputBonusNumMessage(){
        System.out.println(INPUT_BONUS_NUM_MESSAGE);
    }

    public static void printBlank(){
        System.out.println();
    }

    public static void ticketCountMessage(int ticketCount){
        System.out.println(ticketCount+TICKET_COUNT_MESSAGE);
    }

    public static void printResultBar(){
        System.out.println(LOTTO_RESULT_BAR_MESSAGE);
        System.out.println("---");
    }

    public static void printResult(Map<Prize,Integer> lottoResult){
        for (Map.Entry<Prize, Integer> entry : lottoResult.entrySet()) {
            Prize prize = entry.getKey();
            int count = entry.getValue();
            String reward = formatReward(prize.getReward());
            if (prize == Prize.SECOND_GRADE){
                System.out.println(prize.getMatchCount()+"개 일치, 보너스 볼 일치 ("+reward+"원) - "+count+"개");
                continue;
            }
            if (prize.getMatchCount()==0){
                continue;
            }
            System.out.println(prize.getMatchCount()+"개 일치 ("+reward+"원) - "+count+"개");
        }
    }

    private static String formatReward(int amount) {
        return String.format("%,d", amount);
    }

    public static void printTotalRate(int money, int price) {
        double totalRate = ((double) price / money) * 100;
        System.out.println(TOTAL_RATE_MESSAGE + String.format("%.1f%%", totalRate) + "입니다.");
    }
}
