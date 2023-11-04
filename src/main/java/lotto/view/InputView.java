package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.util.InputConvertUtil;
import lotto.util.InputValidator;

public class InputView {

    public static int inputPurchaseAmount(){
        String purchaseAmount = Console.readLine();
        InputValidator.validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> inputLottoNumber(){
        String lottoInput = Console.readLine();
        List<String> lottoNumbers = InputConvertUtil.lottoNumberToLottoList(lottoInput);
        InputValidator.validateLottoNumber(lottoNumbers);
        return InputConvertUtil.lottoNumberToIntegerList(lottoNumbers);
    }

}
