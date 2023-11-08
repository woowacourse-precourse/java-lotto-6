package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("유효한 입력으로 객체를 생성한다.")
    @Test
    void createByValidNumbers() {
        assertThat(winningLottoOf(List.of(1, 2, 3, 4, 5, 6), 10)).isNotNull();
    }

    @DisplayName("로또 번호의 개수가 6개를 넘어가면 예외가 발생한다.")
    @Test
    void createByOverSize() {
        assertThatThrownBy(() -> winningLottoOf(List.of(1, 2, 3, 4, 5, 6, 7), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void createByUnderSize() {
        assertThatThrownBy(() -> winningLottoOf(List.of(1, 2, 3, 4, 5), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createByDuplicatedNumbers() {
        assertThatThrownBy(() -> winningLottoOf(List.of(1, 2, 3, 4, 5, 5), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1에서 45사이의 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createByInvalidRangeNumbers() {
        assertThatThrownBy(() -> winningLottoOf(List.of(0, 1, 2, 3, 4, 46), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> winningLottoOf(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Customer가 구매한 로또와 당첨 로또, 보너스 번호를 비교해 당첨 결과를 생성한다.")
    @Test
    void result() {
        WinningLotto winningLotto = winningLottoOf(List.of(1, 2, 3, 4, 5, 6), 7);
        Customer customer = new Customer(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 11, 12, 13)),
                new Lotto(List.of(11, 12, 13, 4, 5, 6)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))
        ));
        LottoResult lottoResult = winningLotto.result(customer);

        assertThat(lottoResult.count(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.count(LottoRank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.count(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoResult.count(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(lottoResult.count(LottoRank.FIFTH)).isEqualTo(2);
        assertThat(lottoResult.count(LottoRank.NONE)).isEqualTo(1);
    }

    private WinningLotto winningLottoOf(List<Integer> lottoNumbers, int bonusNumber) {
        return new WinningLotto(new Lotto(lottoNumbers), LottoNumber.from(bonusNumber));
    }
}
