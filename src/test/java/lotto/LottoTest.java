package lotto;

import lotto.Service.OutputService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("로또 번호가 1에서 45사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {46, 47, 0, -1})
    void createExceptionNumbers(int number) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, number)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 출력하기 전 로또 번호는 오름차순으로 정렬되어야 한다.")
    @Test
    void getAsencdingLottoNumbers() {
        Lotto lotto = new Lotto(List.of(10, 9, 8, 7, 6, 5));
        assertThat(lotto.getSortedNumbers()).isEqualTo((List.of(5, 6, 7, 8, 9, 10)));
    }

    @DisplayName("로또는 다른 로또와 겹치는 숫자를 반환한다.")
    @Test
    void getHowManySameNumbers() {
        Lotto lotto = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        Lotto compare = new Lotto(List.of(5, 6, 7, 11, 12, 13));
        assertThat(lotto.getHowManySameNumbers(compare)).isEqualTo(3);
    }

    @DisplayName("로또는 5개가 모두 같은 숫자를 가질 때 보너스 숫자를 포함하는지 여부를 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8})
    void checkHasBonusInLotto(int number) {
        Lotto lotto = new Lotto(List.of(10, 11, 12, 13, 14, number));
        OutputService.printLottoNumbers(lotto);
        Lotto compare = new Lotto(List.of(10, 11, 12, 13, 14, number + 20));
        assertThat(lotto.hasBonus(compare, number)).isFalse();
    }
}