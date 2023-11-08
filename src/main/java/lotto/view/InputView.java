package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final Character COMMA = ',';
    public static String getPurchaseMoney(){
        System.out.println(INPUT_PURCHASE_MONEY_MESSAGE);
        return validatePurchaseMoney(Console.readLine());
    }

    public static String getWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return validateWinningNumber(Console.readLine());
    }

    public static String getBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return validateBonusNumber(Console.readLine());
    }

    private static String validatePurchaseMoney(String purchaseMoney){
        isEmpty(purchaseMoney);
        return purchaseMoney;
    }

    private static String validateWinningNumber(String winningNumber){
        isEmpty(winningNumber);
        isEndWithCOMMA(winningNumber);
        return winningNumber;
    }

    private static String validateBonusNumber(String bonusNumber){
        isEmpty(bonusNumber);
        return bonusNumber;
    }

    private static void isEndWithCOMMA(String input){
        if(input.charAt(input.length() - 1) == COMMA){
            throw new IllegalArgumentException();
        }
    }

    private static void isEmpty(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException();
        }
    }
}
