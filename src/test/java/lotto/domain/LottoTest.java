package lotto.domain;

import static common.ErrorCode.LOTTO_NUMBERS_INVALID_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 번호 검증")
class LottoTest {

    @Test
    void 로또_번호_6개_이상_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when
        // then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_INVALID_SIZE.getMessage());
    }

    @Test
    void 로또_번호_중복된_숫자_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when
        // then
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}
