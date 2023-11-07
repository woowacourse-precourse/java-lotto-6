package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Lotto.randomLottery;
import static lotto.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    // 아래에 추가 테스트 작성 가능
    @Nested
    @DisplayName("[Lotto 객체 생성 테스트]")
    class CreateLottoTest {
        @Test
        @DisplayName("숫자의 길이가 6자리가 맞고, 중복이 없을 경우")
        public void createLotto() {
            List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
            Lotto lotto = new Lotto(nums);

            assertThat(lotto).isNotNull();
            assertThat(lotto).isInstanceOf(Lotto.class);
        }

        @Test
        @DisplayName("[ERROR] 숫자의 길이가 6개 미만 일때 IllegalArgumentException 발생")
        public void validateWithUnderSixNumbers() {
            List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> new Lotto(invalidNumbers))
                    .withMessageMatching(CHECK_NUMBER_SIZE);
        }

        @Test
        @DisplayName("[ERROR] 숫자의 길이가 6개 초과 일때 IllegalArgumentException 발생")
        public void validateWithOverSixNumbers() {
            List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> new Lotto(invalidNumbers))
                    .withMessageMatching(CHECK_NUMBER_SIZE);
        }

        @Test
        @DisplayName("[ERROR] 숫자가 중복 되었을 때 IllegalArgumentException 발생")
        public void duplicateNumbers() {
            List<Integer> invalidNumbers = List.of(1, 2, 3, 3, 4, 4);
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> new Lotto(invalidNumbers))
                    .withMessageMatching(CHECK_DUPLICATE_NUMBER);
        }
    }

    @Test
    @DisplayName("[ERROR] validate 메서드 테스트 - 숫자가 6자리가 아닐 경우 IllegalArgumentException 발생")
    public void checkValidate() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Lotto.validate(nums))
                .withMessageMatching(CHECK_NUMBER_SIZE);
    }

    @Test
    @DisplayName("[ERROR] checkDuplicate 메서드 테스트 - 중복이 있을 때 IllegalArgumentException 발생")
    public void checkDuplicate_Duplicates() {
        List<Integer> nums = List.of(1, 2, 3, 4, 4, 3);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Lotto.checkDuplicate(nums))
                .withMessageMatching(CHECK_DUPLICATE_NUMBER);
    }


    @Test
    @DisplayName("randomLottery 메서드 테스트 - 리스트의 숫자가 1과 45사이의 범위에 있는지")
    public void checkRandomLotteryInRange() {
        List<Integer> randomLottery = randomLottery();
        for (int number : randomLottery) {
            assertThat(number).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("randomLottery 메서드 테스트 - 리스트의 사이즈가 6개가 맞는지")
    public void checkRandomLotterySize() {
        List<Integer> randomLottery = randomLottery();
        assertThat(randomLottery.size()).isEqualTo(LOTTO_SIZE);
    }

    @Test
    @DisplayName("checkDuplicate 메서드 테스트 - 중복이 없을 때")
    public void checkDuplicate_WithoutDuplicates() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        Lotto.checkDuplicate(nums);
    }
}