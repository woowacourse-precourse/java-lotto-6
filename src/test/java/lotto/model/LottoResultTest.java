package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private static LottoManager lottoManager;

    @BeforeAll
    static void beforeAll() {
        final LottoMachine lottoMachine = new LottoMachine(() -> List.of(1, 2, 3, 4, 5, 6));
        lottoManager = new LottoManager(lottoMachine);
    }

    @Test
    @DisplayName("당첨 로또와 보너스 번호를 초기화한다.")
    void initWinningLottoAndBonusNumber() throws Exception {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        // when
        // then
        assertThatCode(() -> new LottoResult(winningNumbers, bonusNumber, lottoManager))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또의 등수를 계산한다.")
    void calculateGrade() throws Exception {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        final LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber, lottoManager);
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        final LottoGrade lottoGrade = lottoResult.calculateGrade(lotto);

        // then
        assertThat(lottoGrade).isEqualTo(LottoGrade.FIRST);
    }

    @Test
    @DisplayName("로또 2등을 계산한다.")
    void calculateSecondGrade() throws Exception {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        final LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber, lottoManager);
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // when
        final LottoGrade lottoGrade = lottoResult.calculateGrade(lotto);

        // then
        assertThat(lottoGrade).isEqualTo(LottoGrade.SECOND);
    }

    @Test
    @DisplayName("정답 개수가 등수에 들지 못하면 null을 반환한다.")
    void calculateNotGradeReturnNull() throws Exception {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        final LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber, lottoManager);
        final Lotto lotto = new Lotto(List.of(5, 6, 7, 8, 9, 10));

        // when
        final LottoGrade lottoGrade = lottoResult.calculateGrade(lotto);

        // then
        assertThat(lottoGrade).isNull();
    }
}
