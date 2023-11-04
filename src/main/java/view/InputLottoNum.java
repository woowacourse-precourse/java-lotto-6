package view;

import domain.Lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private static final String WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_PRICE = "구입금액을 입력해 주세요.";

    private static List<Integer> winningNumber;

    public static List<Integer> createWinningNumber(){
        System.out.println(WINNING_LOTTO_NUMBER);
        convertToInteger(readLine());
        winningNumber.add(createBonusNumber());
        return winningNumber;
    }

    public static int enterPurchaseAmount() {
        System.out.println(LOTTO_PRICE);
        return Lotto.checkInteger(readLine());
    }

    public static int createBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return Integer.parseInt(readLine());
    }

    public static void convertToInteger(String input){
        for (String num : input.split(",")){
            winningNumber.add(Lotto.checkInteger(num));
        }
    }

}
