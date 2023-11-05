package lotto.view;

import static lotto.util.InputConvertUtil.*;
import static lotto.util.InputValidator.*;

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
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> inputLottoNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoInput = Console.readLine();
        List<String> lottoNumbers = lottoNumberToLottoList(lottoInput);
        validateLottoNumber(lottoNumbers);
        return lottoNumberToIntegerList(lottoNumbers);
    }

    public static int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
