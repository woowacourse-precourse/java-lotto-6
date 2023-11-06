package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LottoTest {

    @Test
    @DisplayName("Lotto 객체 생성 - 6자리가 맞을 경우")
    public void createLotto() {
        List<Integer> nums = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(nums);

        assertThat(lotto).isNotNull();
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("[ERROR] 숫자가 6개 미만 일때 IllegalArgumentException 발생")
    public void validateWithUnderSixNumbers() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(invalidNumbers));
    }

    @Test
    @DisplayName("[ERROR] 숫자가 6개 초과 일때 IllegalArgumentException 발생")
    public void validateWithOverSixNumbers() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(invalidNumbers));
    }

    @Test
    @DisplayName("[ERROR] validate 함수 테스트 - 숫자가 6자리가 아닐 경우 IllegalArgumentException 발생")
    public void checkValidate() {
        List<Integer> nums = List.of(1,2,3,4,5);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Lotto.validate(nums))
                .withMessageMatching("숫자는 6개보다 작거나 초과할 수 없습니다.");
    }
}