package lotto;

import java.util.List;

public interface Play {
    void start();
    List<Lotto> purchase();
    WinningLottoDTO lottery();
    void checkResult(List<Lotto> myLotto, WinningLottoDTO winningLotto);
}
