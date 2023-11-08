package lotto.view;

import java.util.List;

public class OutputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MONEY_INPUT_RESULT_MESSAGE = "%d개를 구매했습니다. \n";
    private static final String LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String GAME_RESULT_MESSAGE = "당첨 통계 \n---";
    private static final String RANK_5_MESSAGE = "3개 일치 (5,000원) - %d개 \n";
    private static final String RANK_4_MESSAGE = "4개 일치 (50,000원) - %d개 \n";
    private static final String RANK_3_MESSAGE = "5개 일치 (1,500,000원) - %d개 \n";
    private static final String RANK_2_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개 \n";
    private static final String RANK_1_MESSAGE = "6개 일치 (2,000,000,000원) - %d개 \n";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다. \n";

    public void println(String message){
        System.out.println(message);
    }

    public void println(){
        System.out.println();
    }

    public void printf(String format, Object... args){
        System.out.printf(format, args);
    }

    public void resultMessage(int[] lottoRank, double rateOfReturn){
        println();
        println(GAME_RESULT_MESSAGE);
        printf(RANK_5_MESSAGE, lottoRank[5]);
        printf(RANK_4_MESSAGE, lottoRank[4]);
        printf(RANK_3_MESSAGE, lottoRank[3]);
        printf(RANK_2_MESSAGE, lottoRank[2]);
        printf(RANK_1_MESSAGE, lottoRank[1]);
        printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }

    public void bonusInputMessage(){
        println();
        println(BONUS_INPUT_MESSAGE);
    }

    public void lottoInputMessage(){
        println(LOTTO_INPUT_MESSAGE);
    }

    public void moneyInputMessage(){
        println(MONEY_INPUT_MESSAGE);
    }

    public void moneyInputResultMessage(int money){
        println();
        printf(MONEY_INPUT_RESULT_MESSAGE, money);
    }

    public void printLottoTickets(List<List<Integer>> lottoTickets){
        for(List<Integer> lotto : lottoTickets){
            System.out.println(lotto);
        }
        println();
    }
}
