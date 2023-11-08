package lotto.model;

import java.util.List;
import lotto.model.dto.WinningNumDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    Lottos lottos;

    @BeforeEach
    void beforeEach() {
        lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))));
    }

    @DisplayName("발행된 로또가 3개일 때 로또의 수")
    @Test
    void getNumberOfLottoTest() {
        Assertions.assertThat(lottos.getNumberOfLotto()).isEqualTo(3);
    }

    @DisplayName("로또 결과 확인")
    @Test
    void checkResultTest() {
        // given
        WinningNumDTO winningNumDTO = WinningNumDTO.of("1,2,3,4,5,6", "10");
        // when
        Result result = lottos.checkResult(winningNumDTO);
        Result expected = new Result(List.of(Ranking.FIRST, Ranking.FAIL, Ranking.FAIL));
        // then
        Assertions.assertThat(result.getTotalProfit()).isEqualTo(expected.getTotalProfit());
        Assertions.assertThat(result.writeResultsOfRanks()).isEqualTo(expected.writeResultsOfRanks());
    }
}