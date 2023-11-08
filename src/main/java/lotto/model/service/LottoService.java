package lotto.model.service;

import java.util.List;
import java.util.Map;
import lotto.utils.enums.LottoCount;

public interface LottoService {

    List<List<Integer>> createLotto(int lottoCount);

    Map<LottoCount, Integer> compareLottoToWinningAndBonus(List<List<Integer>> createdLottos,
                                                           List<Integer> winningNumbers,
                                                           int bonusNumber);

    long getTotalWinningPrice(Map<LottoCount, Integer> lottoResult);

}
