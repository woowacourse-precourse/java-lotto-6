package lotto.view;

import static lotto.util.InputConvertUtil.lottoNumberToIntegerList;
import static lotto.util.InputConvertUtil.lottoNumberToLottoList;
import static lotto.util.InputValidator.validateBonusNumber;
import static lotto.util.InputValidator.validateLottoNumber;
import static lotto.util.InputValidator.validatePurchaseAmount;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

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
