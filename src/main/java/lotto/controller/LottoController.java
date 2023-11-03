package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoController {

  private lotto.model.Lotto Lotto;

  public List<List<Integer>> createLottos(int calculateLottoCount) {
    List<List<Integer>> lottos = new ArrayList<>();
    for (int i = 0; i < calculateLottoCount; i++) {
      List<Integer> lotto = Lotto.createRandomLottoNumber();
      lottos.add(lotto);
    }
    return lottos;
  }
}
