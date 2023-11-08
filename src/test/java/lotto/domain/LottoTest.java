package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    public static WinningNumbers winningNumbers;
    @BeforeAll
    static void setUp() {
        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1에서 45사이가 아니면 예외가 발생한다.")
    @Test
    void createLottoByCheckInRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 46, 43, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 테스트")
    @Test
    void createLotto() {
        Assertions.assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("당첨 번호와 로또 번호의 일치 개수 테스트")
    @Test
    void countContainsLottoNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(lotto.countContainsLottoNumber(winningNumbers)).isEqualTo(3);
    }

    @DisplayName("당첨 번호와 로또 번호가 3개 일치할 경우 테스트")
    @Test
    void getResultReturnFIFTH() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(lotto.getResult(winningNumbers)).isEqualTo(LottoResult.FIFTH);
    }

    @DisplayName("당첨 번호와 로또 번호가 4개 일치할 경우 테스트")
    @Test
    void getResultReturnFOURTH() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        assertThat(lotto.getResult(winningNumbers)).isEqualTo(LottoResult.FOURTH);
    }

    @DisplayName("당첨 번호와 로또 번호가 5개 일치할 경우 테스트")
    @Test
    void getResultReturnTHIRD() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(lotto.getResult(winningNumbers)).isEqualTo(LottoResult.THIRD);
    }

    @DisplayName("당첨 번호와 로또 번호가 5개, 보너스번호가 일치할 경우 테스트")
    @Test
    void getResultReturnSECOND() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(lotto.getResult(winningNumbers)).isEqualTo(LottoResult.SECOND);
    }

    @DisplayName("당첨 번호와 로또 번호가 6개 일치할 경우 테스트")
    @Test
    void getResultReturnFIRST() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getResult(winningNumbers)).isEqualTo(LottoResult.FIRST);
    }
}