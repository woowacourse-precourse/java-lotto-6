package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Prize;

public class CompareNumber {

  public static int[] compareNumber(List<Lotto> lottos, List<Integer> winning, int bonus) {
    int[] result = new int[6];

    for (Lotto lotto : lottos) {
      int matchedNumbers = countMatchingNumbers(lotto, winning);
      boolean hasBonusNumber = containsNumber(lotto, bonus);
      updateResult(result, matchedNumbers, hasBonusNumber);
    }
    return result;
  }

  public static int countMatchingNumbers(Lotto lotto, List<Integer> winning) {
    int count = 0;
    List<Integer> lottoNumbers = lotto.getNumbers();
    for (int lottoNumber : lottoNumbers) {
      if (winning.contains(lottoNumber)) {
        count++;
      }
    }
    return count;
  }

  public static boolean containsNumber(Lotto lotto, int bonus) {
    List<Integer> lottoNumbers = lotto.getNumbers();
    for (int lottoNumber : lottoNumbers) {
      if (bonus == lottoNumber) {
        return true;
      }
    }
    return false;
  }

  public static void updateResult(int[] result, int matchedNumbers, boolean hasBonusNumber) {
    Prize prize = getPrize(matchedNumbers, hasBonusNumber);

    if (prize != null) {
      result[prize.getIndex()]++;
    }
  }

  public static Prize getPrize(int matchedNumbers, boolean hasBonusNumber) {
    if (matchedNumbers == 6) {
      return Prize.FIRST;
    } else if (matchedNumbers == 5 && hasBonusNumber) {
      return Prize.SECOND;
    } else if (matchedNumbers == 5) {
      return Prize.THRID;
    } else if (matchedNumbers == 4) {
      return Prize.FOURTH;
    } else if (matchedNumbers == 3) {
      return Prize.FIFTH;
    } else {
      return null;
    }
  }
}
