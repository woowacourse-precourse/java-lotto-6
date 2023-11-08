package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LOTTO_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputLottoAmount(){
        System.out.println(LOTTO_AMOUNT_MESSAGE);
        return Console.readLine();
    }

//    public static
//
//    public static String inputUserNumber(){
//        System.out.println(LOTTO_NUMBER_MESSAGE);
//        return Console.readLine();
//    }

}


