package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

public class CreateLotto {
  private static final Integer MIN_RANGE = 1;
  private static final Integer MAX_RANGE = 45;
  private static final Integer LOTTO_SIZE = 6;

  public List<Integer> createLottoNumber(){
    List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE);
    Collections.sort(lottoNumber);
    return lottoNumber;
  }

  public Lotto createLotto(){
    return new Lotto(createLottoNumber());
  }

  public List<Lotto> createLottos(int ticket){
    List<Lotto> lottos = new ArrayList<>();
    for(int i = 0 ; i < ticket; i++) {
      lottos.add(createLotto());
    }
    return lottos;
  }
}
