package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utils.Constants.MIN_NUMBER_IN_RANGE;
import static lotto.utils.Constants.MAX_NUMBER_IN_RANGE;
import static lotto.utils.ErrorMessages.CHECK_NUMBER_IN_RANGE;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class GenerateRandomNumTest {
//    @Test
//    @DisplayName("pickNumber 메서드 테스트")
//    public void pickNumber() {
//        int num = GenerateRandomNum.pickNumber();
//        assertThat(num).isBetween(MIN_NUMBER_IN_RANGE, MAX_NUMBER_IN_RANGE);
//    }

//    @Test
//    @DisplayName("[ERROR] checkNumberInRange 메서드 테스트 - 1과 45사이의 범위에 해당하지 않을 경우")
//    public void checkNumberInRange() {
//        int num = 0;
//        assertThatExceptionOfType(IllegalArgumentException.class)
//                .isThrownBy(() -> GenerateRandomNum.checkNumberInRange(num))
//                .withMessageMatching(CHECK_NUMBER_IN_RANGE);
//    }
}