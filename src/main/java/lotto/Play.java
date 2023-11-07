package lotto;

import lotto.model.Lotto;
import lotto.model.WinningLottoDTO;

import java.util.List;

public interface Play {
    void start();
    List<Lotto> purchase();
    WinningLottoDTO lottery();
    void checkResult(List<Lotto> myLotto, WinningLottoDTO winningLotto);
}
