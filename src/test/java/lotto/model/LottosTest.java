package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("최종 번호를 받고 로또들의 결과를 계산한다.")
    @Test
    void 구입한로또_결과_확인() {
        //given
        Lotto lottoOne = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoTwo = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        Lotto lottoThree = new Lotto(List.of(44, 43, 42, 41, 40, 39));
        Lottos lottos = new Lottos(List.of(lottoOne, lottoTwo, lottoThree));

        GameNumbers gameNumbers = new GameNumbers(new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)));
        gameNumbers.addBonusNumber(new BonusNumber(45));

        //when
        List<Result> results = lottos.getResults(gameNumbers);

        //then
        Assertions.assertThat(results).contains(Result.SIX, Result.THREE, Result.FAIL);
    }

}
