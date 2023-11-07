package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidPurchaseCostException;
import lotto.util.LottoInputUtil;


public class InputView {
    private final InvalidPurchaseCostException invalidPurchaseCostException = new InvalidPurchaseCostException();
    private final LottoInputUtil lottoInputUtil = new LottoInputUtil();

    public int inputPriceView() {
        try {
            String price = Console.readLine();
            invalidPurchaseCostException.validatePurchaseCostException(price);
            return lottoInputUtil.toIntStringNumberParser(price);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
        }
    }

    public String inputLottoNumbersView() {
        String lottoNumbers = Console.readLine();
        return lottoNumbers;
    }

    public String inputBonusNumberView(){
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }


}
