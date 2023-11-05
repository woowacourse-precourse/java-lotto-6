package lotto.domain;

import static lotto.enums.ErrorMassage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(createLottoNumbers(List.of(1, 2, 3, 4, 5, 6, 7))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INCORRECT_LOTTO_COUNT.getMassage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(createLottoNumbers(List.of(1, 1, 2, 3, 4, 5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBER.getMassage());
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .toList();
    }
}