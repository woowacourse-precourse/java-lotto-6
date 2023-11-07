package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

import java.util.Arrays;
import java.util.List;

import static lotto.util.Validator.*;

public class InputView {
    public static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputAmount(){
        System.out.println(INPUT_AMOUNT_MESSAGE);
        String amountStr ="";
        while(true){
            amountStr = Console.readLine();
            try {
                validateAmount(amountStr);
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        return Integer.parseInt(amountStr);
    }

    public static List<Integer> inputWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String numberStr = "";
        while(true){
            numberStr = Console.readLine();
            try {
                validateWinningNumber(numberStr);
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        return Arrays.stream(numberStr.split(","))
                .map(Integer::parseInt).toList();
    }

    public static int inputBonusNumbers(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String numberStr = "";
        while(true){
            numberStr = Console.readLine();
            try {
                validateBonusNumber(numberStr);
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        return Integer.parseInt(numberStr);
    }




}
