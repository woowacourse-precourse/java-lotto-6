package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputPrice() {
        System.out.println(PRICE_MESSAGE);
        return Console.readLine();
    }

    public String inputLottoNumber() {
        System.out.println(LOTTO_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }

}
