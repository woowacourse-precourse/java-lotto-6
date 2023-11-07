package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidPurchaseCostException;


public class InputView {
    private final InvalidPurchaseCostException invalidPurchaseCostException = new InvalidPurchaseCostException();

    public int inputPriceView() {
        try {
            String price = Console.readLine();
            invalidPurchaseCostException.validatePurchaseCostException(price);
            return toIntStringNumberParser(price);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
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

    public static int toIntStringNumberParser(String number) {
        return Integer.parseInt(number);
    }


}
