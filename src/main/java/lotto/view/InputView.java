package lotto.view;

import static lotto.view.constant.ConstantMessage.INPUT_AMOUNT_MESSAGE;
import static lotto.view.constant.ConstantMessage.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.view.constant.ConstantMessage.INPUT_LOTTO_NUMBER_MESSAGE;


import camp.nextstep.edu.missionutils.Console;
import lotto.view.constant.ConstantMessage;

public class InputView {
    public static int inputAmountView(){
        printConstantMessage(INPUT_AMOUNT_MESSAGE);

        return Integer.parseInt(Console.readLine());
    }

    public static void inputBonusNumberView(){
        printConstantMessage(INPUT_BONUS_NUMBER_MESSAGE);
        printNewLine();
        Console.readLine();
    }

    public static void inputLottoNumberView(){
        printConstantMessage(INPUT_LOTTO_NUMBER_MESSAGE);
        printNewLine();
        Console.readLine();
    }

    private static void printConstantMessage(ConstantMessage message){
        System.out.print(message);
        printNewLine();
        Console.readLine();
    }

    private static void printNewLine(){
        System.out.print("\n");
    }
}
