package lotto;

import java.util.Comparator;
import java.util.List;
import tool.Convert;
import validation.IntegerValidator;
import validation.ListValidator;
import validation.StringValidator;

public class Input {

  public static int inputLottoNumber(String input) {
    int result = StringValidator.checkIntegerType(input);
    IntegerValidator.checkRemainderZero(result, Const.LOTTO_PRICE);
    return result;
  }

  public static List<Integer> inputWinningNumbers(String input) {
    List<Integer> winningNumbers = Convert.stringToIntList(input, ",");
    winningNumbers.sort(Comparator.naturalOrder());

    return winningNumbers;
  }

  public static int inputBonusNumber(String input, List<Integer> winningNumbers) {
    int bonusNumber = StringValidator.checkIntegerType(input);
    IntegerValidator.checkRange(bonusNumber, Const.LOTTO_BEGIN, Const.LOTTO_END);
    winningNumbers.add(bonusNumber);
    ListValidator.checkDuplicate(winningNumbers);

    return bonusNumber;
  }
}
