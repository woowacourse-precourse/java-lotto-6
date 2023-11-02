package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputMoneyForBuyingLottos() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputLottoPrice = Console.readLine();
        validate(inputLottoPrice);
        return inputLottoPrice;
    }

    private static void validate(String inputLottoPrice) {

    }

}
