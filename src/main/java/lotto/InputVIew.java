package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputVIew {
    private static final String INPUT_TICKETS_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputTicketsAmount(){
        System.out.println(INPUT_TICKETS_AMOUNT);
        return Console.readLine();
    }
    public static List<Integer> inputWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS);
        String input = Console.readLine();
        return toWinningNumbers(input);
    }
    public static int inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
    private static List<Integer> toWinningNumbers(String input){
        String[] strWinningNums = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for(String s : strWinningNums){
            winningNumbers.add(Integer.parseInt(s.trim()));
        }
        return winningNumbers;
    }

}
