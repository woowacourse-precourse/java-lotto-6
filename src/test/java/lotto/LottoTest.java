package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void create_lotto_under_size() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위의 최대를 넘어서면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void create_lotto_over_max_number() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위의 최소를 벗어나면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void create_lotto_under_min_number() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호의 중복된 수만큼 반환해야한다.")
    @Test
    void calculate_result() {
        List<Integer> commonNumber = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> lottoNumber = new ArrayList<>(commonNumber);
        List<Integer> winningNumber = new ArrayList<>(commonNumber);
        lottoNumber.add(10);
        winningNumber.add(11);

        Lotto lotto = new Lotto(lottoNumber);
        WinningNumber winning = new WinningNumber(winningNumber);
        winning.addBonusNumber(13);

        assertThat(lotto.getCalculateResult(winning)).isEqualTo(commonNumber.size());
    }

    @DisplayName("로또 번호에 당첨번호가 존재하면 true를 반환해야한다.")
    @Test
    void calculate_bonus() {
        int bonus = 6;
        List<Integer> commonNumber = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> lottoNumber = new ArrayList<>(commonNumber);
        List<Integer> winningNumber = new ArrayList<>(commonNumber);
        lottoNumber.add(bonus);
        winningNumber.add(11);

        Lotto lotto = new Lotto(lottoNumber);
        WinningNumber winning = new WinningNumber(winningNumber);
        winning.addBonusNumber(bonus);

        assertThat(lotto.isBonusNumberIn(winning)).isTrue();
    }
}