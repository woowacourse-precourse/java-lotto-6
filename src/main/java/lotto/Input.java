package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tool.Convert;
import validation.IntegerValidator;
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
}
