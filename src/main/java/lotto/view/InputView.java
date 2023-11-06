package lotto.view;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    private static final String INPUT_LOTTO_AMOUNT ="구입금액을 입력해 주세요.";
    private static final String TYPE_ERROR ="숫자가 아닌 값을 입력하셨습니다.";

    public static int inputPlayerAmount(){
        System.out.println(INPUT_LOTTO_AMOUNT);
        return convertToInt(Console.readLine());
    }

    public static int convertToInt(String inputAmount)
    {
        return Integer.parseInt(inputAmount);
    }


}
