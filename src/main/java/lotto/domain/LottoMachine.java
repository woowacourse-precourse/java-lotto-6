package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
  public void generateLottoNumbers(ArrayList<Lotto> reciept, Integer lottoAmount) {
    while (reciept.size() < lottoAmount) {
      List<Integer> lottoDigits = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      reciept.add(new Lotto(lottoDigits));
    }
  }

  
}
