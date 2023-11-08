package lotto.domain;

import lotto.domain.lotto.*;
import lotto.domain.mock.MockNumberPicker;
import lotto.domain.result.Result;
import lotto.dto.ResultDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @Test
    void 로또_게임을_진행하고_결과를_반환한다() {
        LottoAmount lottoAmount = new LottoAmount(10000);
        Lottos lottos = Lottos.generateByAmount(lottoAmount, MockNumberPicker.setNumbers(
                List.of(1, 2, 3, 12, 13, 14),
                List.of(1, 2, 3, 4, 12, 13),
                List.of(12, 13, 14, 15, 16, 17),
                List.of(12, 13, 14, 15, 16, 17),
                List.of(12, 13, 14, 15, 16, 17),
                List.of(12, 13, 14, 15, 16, 17),
                List.of(12, 13, 14, 15, 16, 17),
                List.of(12, 13, 14, 15, 16, 17),
                List.of(12, 13, 14, 15, 16, 17),
                List.of(12, 13, 14, 15, 16, 17)));
        WinningLotto winningLotto = WinningLottoGenerator.generateWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoGame lottoGame = new LottoGame(lottos, winningLotto, lottoAmount);
        ResultDto result = lottoGame.getResult();

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, result.statistics().get(Result.FIFTH)),
                () -> Assertions.assertEquals(1, result.statistics().get(Result.FOURTH)),
                () -> Assertions.assertEquals(0, result.statistics().get(Result.FIRST)),
                () -> Assertions.assertEquals(550.0, result.profit())
        );
    }
}