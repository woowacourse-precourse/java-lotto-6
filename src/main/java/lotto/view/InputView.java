package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.util.InputConvertUtil;
import lotto.util.InputValidator;

public class InputView {

    public static int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        InputValidator.validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> inputLottoNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoInput = Console.readLine();
        List<String> lottoNumbers = InputConvertUtil.lottoNumberToLottoList(lottoInput);
        InputValidator.validateLottoNumber(lottoNumbers);
        return InputConvertUtil.lottoNumberToIntegerList(lottoNumbers);
    }

    public int inputBonusNumber(){
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }
}
