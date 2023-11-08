package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.UserBuyingException;
import lotto.utils.InputUtil;

public class InputView {

    private final UserBuyingException userBuyingException = new UserBuyingException();

    public int inputBuyingPriceView() {
        try {
            String buyPrice = Console.readLine();
            userBuyingException.validateBuyingException(buyPrice);
            return InputUtil.toIntStringNumberParser(buyPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다");
        }
    }
    public String inputLottoNumbersView() {
        String lottoNumbers = Console.readLine();
        return lottoNumbers;
    }
}
