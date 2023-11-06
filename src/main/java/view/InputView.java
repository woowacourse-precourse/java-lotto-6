package view;

import camp.nextstep.edu.missionutils.Console;

/**
 * packageName    : view
 * fileName       : InputView
 * author         : qkrtn_ulqpbq2
 * date           : 2023-11-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-06        qkrtn_ulqpbq2       최초 생성
 */
public class InputView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static String enterAmount(){
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String enterWinningNumbers(){
        return Console.readLine();
    }

    public static String enterBonusNumber(){
        return Console.readLine();
    }
}
