package lotto.observer;

import lotto.dto.WinningLottoDto;
import lotto.service.LottoRank;

public interface Observer {
    void compare(WinningLottoDto winningLotto);
}
