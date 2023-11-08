package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.Dto.TotalResultDto;
import lotto.constant.constants.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class LottoComputerTest {
    Lotto winningLotto;
    Lottos boughtLottos;
    LottoComputer lottoComputer;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        boughtLottos = new Lottos();
        lottoComputer = new LottoComputer();
        boughtLottos.add(winningLotto);
        lottoComputer.configWinningLotto(winningLotto);
        lottoComputer.configBonus("7");
        lottoComputer.configBoughtLottos(boughtLottos);
    }

    @Test
    @DisplayName("로또 컴퓨터 생성 테스트")
    void createLottoComputer() {
        assertThatCode(LottoComputer::new).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("컴퓨터 시뮬레이션 테스트")
    void Given_SimulateResult_When_CalculateWonResult_Then_SixMatchIsOne() {
        // Given
        TotalResultDto totalResultDto = lottoComputer.simulate();
        // When
        List<Integer> wonResult = new ArrayList<>();
        for (int i = 0; i < totalResultDto.size(); i++) {
            wonResult.add(totalResultDto.get(i).getWon());
        }
        // Then
        assertThat(wonResult).isEqualTo(List.of(0, 0, 0, 0, 1)); // [3,4... all matched]
    }

    @ParameterizedTest
    @ValueSource(strings = {"65", "-1", "0", "abc", "", "12019251090"})
    @DisplayName("로또 컴퓨터의 보너스 수 입력 검증에 대한 예외 처리")
    void Given_InvalidString_When_validatedBonus_Then_ThrowsIllegalArgumentException(String input) {
        assertThatThrownBy(() -> new LottoComputer().validateBonus(input)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoComputer().validateBonus(input)).hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("컴퓨터 수익률 테스트")
    void Given_SimulatedResult_When_GetProfit_Then_ProfitIsExpected() {
        // Given
        // When
        TotalResultDto totalResultDto = lottoComputer.simulate();
        // Then
        assertThat(totalResultDto.getProfit()).isEqualTo(Prize.SIX_MATCHED.getPrize() / 1000 * 100);
    }
}