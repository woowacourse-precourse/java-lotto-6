package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_PRIZE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONNER = "보너스 번호를 입력해 주세요.";
    public static String inputPrice(){
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Console.readLine();
    }
}


