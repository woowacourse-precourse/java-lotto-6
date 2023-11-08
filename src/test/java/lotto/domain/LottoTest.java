package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 유효한 범위(1~45)를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByInvalidNumber() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 생성할 수 있다.")
    @Test
    void generateRandomLotto() {
        Lotto lotto = Lotto.generateRandomLotto();
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).hasSize(6);
        assertThat(numbers).allMatch(num -> num >= 1 && num <= 45);
    }

}