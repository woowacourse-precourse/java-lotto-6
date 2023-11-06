package lotto;

import camp.nextstep.edu.missionutils.Console;
import validation.IntegerValidator;
import validation.StringValidator;

public class Input {

  public static int inputLottoNumber() {
    System.out.println("구입금액을 입력해 주세요.");
    String input = Console.readLine();
    int result = StringValidator.checkIntegerType(input);
    IntegerValidator.checkRemainderZero(result, Const.LOTTO_PRICE);
    return result;
  }
}
