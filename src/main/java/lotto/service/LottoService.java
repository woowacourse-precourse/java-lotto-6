package lotto.service;


import java.util.List;
import lotto.domain.WinningLotto;

public interface LottoService {
    List<List<Integer>> buyLotto();
    List<Integer> getResult(List<List<Integer>> myLottoNumbers, WinningLotto winningLotto);
    WinningLotto settingWinningLotto();
    float getProfitability(List<Integer> result);
}
