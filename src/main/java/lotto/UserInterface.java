package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {
    enum Message{
        INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
        INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
        INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
        OUTPUT_PURCHASED_LOTTO("\n%d개를 구매했습니다.\n"),
        OUTPUT_STATISTICS("\n당첨 통계\n---\n"),
        OUTPUT_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");


        private String consoleMessage;

        Message(String consoleMessage) {
            this.consoleMessage = consoleMessage;
        }

        String getMessage(){
            return consoleMessage;
        }


        }
    public int getPurchaseAmount(){
        System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());
        return Integer.valueOf(Console.readLine());
    }
    public List<Integer> getWinningNumber(){
        System.out.println(Message.INPUT_WINNING_NUMBER.getMessage());
        String[] winningNumbersInput = Console.readLine().split(",");
        List<Integer> winningNumbers =  Arrays.asList(winningNumbersInput)
                .stream()
                .map((i) -> Integer.valueOf(i))
                .collect(Collectors.toList());
        return winningNumbers;
    }
    public int getBonusNumber(){
        System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
        return Integer.valueOf(Console.readLine());
    }

    public void printPurchaedLotto(List<Lotto> lottos){
        System.out.printf(Message.OUTPUT_PURCHASED_LOTTO.getMessage(), lottos.size());
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStatistics(HashMap<Winning, Integer> winningCount, double rate){
        System.out.printf(Message.OUTPUT_STATISTICS.getMessage());


        for(Winning winning : Winning.values()) {
            System.out.printf(winning.getPrintMessage(), winningCount.getOrDefault(winning, 0));
        }

        System.out.printf(Message.OUTPUT_RATE_OF_RETURN.getMessage(),rate);


    }
}
