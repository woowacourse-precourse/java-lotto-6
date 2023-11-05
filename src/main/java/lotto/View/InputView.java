package lotto.View;

import static lotto.Exception.ExceptionMessage.TYPE_ERROR;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public static int inputAmount() {
        try {
            System.out.println(INPUT_LOTTO_AMOUNT);
            return Integer.parseInt(Console.readLine());
        }catch (IllegalArgumentException e){
            System.out.println("\n"+TYPE_ERROR.getExceptionMessage());
            return inputAmount();
        }
    }

    public static List<Integer> inputWinningNumbers(){
        try {
            System.out.println(INPUT_WINNING_NUMBERS);
            return Arrays.stream((Console.readLine().split(",")))
                    .map(Integer::parseInt).toList();
        }catch (IllegalArgumentException e){
            System.out.println("\n" + TYPE_ERROR.getExceptionMessage());
            return inputWinningNumbers();
        }
    }

    public static int inputBonusNumber(){
        try {
            System.out.println(INPUT_WINNING_NUMBERS);
            return Integer.parseInt(Console.readLine());
        }catch (IllegalArgumentException e){
            System.out.println("\n" + TYPE_ERROR.getExceptionMessage());
            return inputBonusNumber();
        }
    }

}
