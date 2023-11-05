package lotto.model.winningLotto;

import java.util.List;
import lotto.model.lotto.Lotto;

public record WinningLottoDTO(
        Lotto winningNumber,
        int bonusNumber) {

    public static WinningLottoDTO of(WinningLotto winningLotto){
        return new WinningLottoDTO(winningLotto.winningNumber, winningLotto.bonusNumber);
    }

}
