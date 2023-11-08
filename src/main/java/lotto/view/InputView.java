package lotto.view;

import static lotto.util.InputUtil.toIntStringNumberParser;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.UserBuyingException;

public class InputView {
    private final UserBuyingException userBuyingException = new UserBuyingException();

    public int inputBuyingPriceView() {
        String buyingPrice;
        while (true) {
            try {
                buyingPrice = Console.readLine();
                userBuyingException.validateBuyingException(buyingPrice);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return toIntStringNumberParser(buyingPrice);
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
