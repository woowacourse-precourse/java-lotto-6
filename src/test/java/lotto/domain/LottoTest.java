package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Lotto.randomLottery;
import static lotto.utils.Constants.CHECK_NUMBER_SIZE;
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
                .withMessageMatching(CHECK_NUMBER_SIZE);
    }

    @Test
    @DisplayName("randomLottery 메서드 테스트 - 리스트의 숫자가 1과 45사이의 범위에 있는지")
    public void checkRandomLotteryInRange(){
        List<Integer> randomLottery = randomLottery();
        for (int number : randomLottery) {
            assertThat(number).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("isDuplicateNum 메서드 테스트 - 중복이 아닐 경우 false반환")
    public void checkDuplicatedNumFalse() {
        List<Integer> originNums = List.of(1, 2, 3, 4, 5);
        int addNum = 6;

        boolean isDuplicated = Lotto.isDuplicatedNum(originNums, addNum);

        assertThat(isDuplicated).isFalse();
    }

    @Test
    @DisplayName("isDuplicateNum 메서드 테스트 - 중복일 경우 true반환")
    public void checkDuplicatedNumTrue() {
        List<Integer> originNums = List.of(1, 2, 3, 4, 5);
        int addNum = 3;

        boolean isDuplicated = Lotto.isDuplicatedNum(originNums, addNum);

        assertThat(isDuplicated).isTrue();
    }
}