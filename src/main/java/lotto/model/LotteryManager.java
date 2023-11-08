package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import lotto.validation.LotteryNumberValidator;

public class LotteryManager extends LotteryPolicy {


  public static List<Integer> generateLottoNumbers() {
    return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_SIZE);
  }

  public static List<Integer> getWinningLotto(String numbers) {
    StringTokenizer st = splitLottoNumbers(numbers);
    List<Integer> winningNumbers = new ArrayList<>();
    while (st.hasMoreTokens()) {
      String strNumber = st.nextToken();
      LotteryNumberValidator.validateNumberFormat(strNumber);
      int number = Integer.parseInt(strNumber);
      LotteryNumberValidator.validateNumberRange(number);
      winningNumbers.add(number);
    }
    return winningNumbers;
  }

  public static int getBonusNumber(String bonus) {
    return Integer.parseInt(bonus);
  }

  private static StringTokenizer splitLottoNumbers(String lottoNumbers) {
    StringTokenizer lottoNumberTokens = new StringTokenizer(lottoNumbers, SEPARATOR);
    LotteryNumberValidator.validateNumberOfToken(lottoNumberTokens.countTokens());
    return lottoNumberTokens;
  }
}
