package lotto.domain.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {
  public List<Lotto> generateLottoGroup(int createLottoCount) {
    List<Lotto> lottoList = new ArrayList<>();

    while (lottoList.size() < createLottoCount) {
      lottoList.add(generateLotto());
    }

    return lottoList;
  }

  public Lotto generateLotto() {
    LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
    return new Lotto(lottoNumbersGenerator.generateLottoNumbers());
  }
}