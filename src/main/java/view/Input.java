package view;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private static final String WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static List<Integer> winningNumber;

    public static List<Integer> createWinningNumber(){
        System.out.println(WINNING_LOTTO_NUMBER);
        convertToInteger(readLine());
        winningNumber.add(createBonusNumber());
        return winningNumber;
    }

    public static int createBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return Integer.parseInt(readLine());
    }

    public static void convertToInteger(String input){
        for (String num : input.split(",")){
            winningNumber.add(checkInteger(num));
        }
    }

    private static int checkInteger(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            ExceptionMessage.typeException();
            throw new IllegalArgumentException();
        }
    }
}
