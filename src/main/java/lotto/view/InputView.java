package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.UserBuyingException;
import lotto.utils.InputUtil;

public class InputView {

    private final UserBuyingException userBuyingException = new UserBuyingException();

    public int inputBuyingPriceView() {
        while (true) {
            try {
                String buyPrice = Console.readLine();
                userBuyingException.validateBuyingException(buyPrice);
                return InputUtil.toIntStringNumberParser(buyPrice);
            } catch (IllegalArgumentException e) {
//                throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다");
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputLottoNumbersView() {
        String lottoNumbers = Console.readLine();
        return lottoNumbers;
    }

    public String inputBonusNumberView() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}