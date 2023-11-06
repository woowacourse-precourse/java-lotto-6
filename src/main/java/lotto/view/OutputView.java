package lotto.view;

import java.util.List;

public class OutputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MONEY_INPUT_RESULT_MESSAGE = "%d개를 구매했습니다. \n";

    public void printMoneyInputMessage(){
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void printMoneyInputResultMessage(int money){
        System.out.printf(MONEY_INPUT_RESULT_MESSAGE, money);
        System.out.println();
    }

    public void printLottoTickets(List<List<Integer>> lottoTickets){
        for(List<Integer> lotto : lottoTickets){
            System.out.println(lotto);
        }
        System.out.println();
    }
}
