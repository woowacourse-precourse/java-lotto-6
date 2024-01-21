package lotto.service;

import static lotto.domain.Lotto.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.MIN_LOTTO_NUMBER;
import static lotto.domain.Lotto.SIZE_OF_LOTTO;
import static lotto.domain.PurchaseAmount.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class LottoGenerator {

  public static List<Lotto> generateLottos(PurchaseAmount purchaseAmount) {
    int numberOfLotto = purchaseAmount.getAmount() / LOTTO_PRICE;
    System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");

    List<Lotto> generatedLottos = new ArrayList<>();

    for (int i = 0; i < numberOfLotto; i++) {
      List<Integer> lottoNumbers =
          Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, SIZE_OF_LOTTO);

      try {
        Lotto lotto = new Lotto(lottoNumbers);
        generatedLottos.add(lotto);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        i--;
      }
    }

    return generatedLottos;
  }

}
