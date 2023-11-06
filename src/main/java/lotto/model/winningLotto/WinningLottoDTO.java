package lotto.model.winningLotto;

import java.util.List;
import lotto.model.lotto.Lotto;

public record WinningLottoDTO(
        Lotto winningNumber,
        int bonusNumber) {

    public static WinningLottoDTO of(Lotto winningNumber, int bonusNumber){
        return new WinningLottoDTO(winningNumber, bonusNumber);
    }

}
