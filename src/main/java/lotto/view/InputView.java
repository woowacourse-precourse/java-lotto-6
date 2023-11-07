package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String REQUEST_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


    public String inputLottoPrice() {
        System.out.println(REQUEST_PURCHASE_PRICE_MESSAGE);
        return readLine();
    }

    public String inputLottoNumbers() {
        System.out.println(REQUEST_LOTTO_NUMBER_MESSAGE);
        return readLine();
    }

    public String inputLottoBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
        return readLine();
    }
}
