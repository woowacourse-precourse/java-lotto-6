package lotto.model.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningLottoNumberTest {

    @Test
    void matchLottoCalculate() {
        List<Integer> winningNumbers = List.of(1, 2, 3);
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto lotto3 = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        Lotto lotto4 = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4);

        WinningLottoNumber winningLottoNumber = new WinningLottoNumber();
        winningLottoNumber.setWinningNumberWithBonusNumber(winningNumbers);

        List<Integer> list = winningLottoNumber.matchLottoCalculate(lottos);
        Assertions.assertThat(list).contains(1,2,3,0);

    }
}