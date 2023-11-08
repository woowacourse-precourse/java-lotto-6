package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerationService {

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;
  private static final int LOTTO_SIZE = 6;

  public List<Lotto> generateLottoTickets(int count) {
    List<Lotto> tickets = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      List<Integer> numbers = createRandomNumbers();
      Lotto lotto = new Lotto(numbers);
      tickets.add(lotto);
    }
    return tickets;
  }

  private List<Integer> createRandomNumbers() {
    return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
  }
}