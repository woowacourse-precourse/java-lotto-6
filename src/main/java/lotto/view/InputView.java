package lotto.view;

import lotto.utility.enums.Messages;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private InputView(){}; //생성자로 인스턴스 생성 막기

    public static String readUserLottoPurchaseAmount() {
        System.out.println(Messages.INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage());
        return readLine();
    }
    
    public static String readWinningNumber(){
        System.out.println(Messages.INPUT_LOTTO_WINNING_NUUMBER_MESSAGE.getMessage());
        return readLine();
    }

    public static String readBonusNumber(){
        System.out.println(Messages.INPUT_LOTTO_BONUS_NUMBER_MESSAGE.getMessage());
        return readLine();
    }
}
