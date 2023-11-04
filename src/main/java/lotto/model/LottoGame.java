package lotto.model;

import java.util.List;

public class LottoGame {

  public int countMatchingNumbers(List<Integer> ticket, List<Integer> numbers) {
    int matchedNumbers = 0;
    for (int userNumber : numbers) {
      if (ticket.contains(userNumber)) {
        matchedNumbers++;
      }
    }
    return matchedNumbers;
  }


}