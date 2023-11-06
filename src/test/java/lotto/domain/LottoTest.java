package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

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

    @DisplayName("로또 번호가 유효한 경우 정상적으로 생성되는지 확인한다.")
    @Test
    void createLottoWithValidNumbers() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertThat(lotto.getNumbers()).containsExactlyElementsOf(validNumbers);
    }


    @DisplayName("로또 번호에 유효하지 않은 번호(범위를 벗어난 번호)가 포함된 경우 예외가 발생한다.")
    @Test
    void createLottoWithInvalidNumbers() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(invalidNumbers));
    }


    @DisplayName("로또 번호에 중복된 번호가 포함된 경우 예외가 발생한다.")
    @Test
    void createLottoWithDuplicateNumbers() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(duplicateNumbers));
    }


    @DisplayName("로또 번호와 당첨 번호를 비교하여 일치하는 번호 개수 반환")
    @Test
    void countMatchWithMatchingNumbers() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        int matchCount = userLotto.countMatch(winningLotto);
        assertThat(matchCount).isEqualTo(3);
    }


    @DisplayName("로또 번호와 당첨 번호를 비교하여 일치하는 번호가 없는 경우 0 반환")
    @Test
    void countMatchWithNoMatchingNumbers() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        int matchCount = userLotto.countMatch(winningLotto);
        assertThat(matchCount).isZero();
    }

}
