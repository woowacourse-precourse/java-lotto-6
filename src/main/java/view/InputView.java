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

    public static String enterAmount(){
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return Console.readLine();
    }
}
