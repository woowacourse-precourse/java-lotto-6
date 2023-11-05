package lotto.view;

public class OutputView {

    private static final String INPUT_BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUM_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계";

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
}
