package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.InputView;

public class LottoWinningNumbersValidator {
  public static final String LOTTO_NUMBERS_LENGTH_INVALID_MESSAGE = "[ERROR] 6개의 번호를 입력하시오. ";
  public static final String DUPLICATE_LOTTO_NUMBERS_MESSAGE= "[ERROR] 중복된 번호가 있습니다.";

  public static void isLottoNumbersLengthValid (List<String> winningNumbers) {
    try {
      if (winningNumbers.size() != 6) {
        throw new IllegalArgumentException(LOTTO_NUMBERS_LENGTH_INVALID_MESSAGE);
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      InputView.inputWinningNumber();
    }
  }

  public static void isNoDuplicateLottoNumbers (List<String> winningNumbers) throws IllegalArgumentException {
    try {
      Set<String> uniqueNumbers = new HashSet<>();
      for (String winningNumber : winningNumbers) {
        if (!uniqueNumbers.add(winningNumber)) {
          throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBERS_MESSAGE);
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      InputView.inputWinningNumber();
    }
  }
}
