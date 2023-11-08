package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Lotto 에 저장된 로또 번호를 비교하여 Lotto 객체 생성을 검증하는 테스트")
    @Test
    void testLottoCreation() {
        List<Integer> numbers = List.of(11, 12, 13, 14, 15, 16);
        Lotto lotto = Lotto.create(numbers);

        List<Integer> lottoNumbers = lotto.getNumbers();

        assertThat(lottoNumbers).containsExactly(11, 12, 13, 14, 15, 16);
    }
}