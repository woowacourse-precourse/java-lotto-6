package lotto.service;


import java.util.List;
import lotto.domain.WinningLotto;

public interface LottoService {
    int payMoney();
    List<List<Integer>> getMyLotto(int quantity);
    List<Integer> getResult(List<List<Integer>> myLottoNumbers, WinningLotto winningLotto);
    WinningLotto settingWinningLotto();
    float getProfitability(List<Integer> result, int quantity);
}
