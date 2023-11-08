package lotto.domain.model;

import lotto.constant.IllegalArgumentExceptionType;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBonusNumberTest {

    @DisplayName("번호_범위_검증_성공_테스트")
    @Test
    void createBonusNumberByNumberInRange() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThatCode(() -> new LottoBonusNumber(1)).doesNotThrowAnyException();
        softAssertions.assertThatCode(() -> new LottoBonusNumber(20)).doesNotThrowAnyException();
        softAssertions.assertThatCode(() -> new LottoBonusNumber(45)).doesNotThrowAnyException();

        softAssertions.assertAll();
    }

    @DisplayName("번호_범위_검증_실패_테스트")
    @Test
    void createBonusNumberByNumberOutOfRange() {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThatThrownBy(() -> new LottoBonusNumber(-1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgumentExceptionType.LOTTO_RANGE_ERROR.getMessage());

        softAssertions.assertThatThrownBy(() -> new LottoBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.LOTTO_RANGE_ERROR.getMessage());

        softAssertions.assertThatThrownBy(() -> new LottoBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.LOTTO_RANGE_ERROR.getMessage());

        softAssertions.assertAll();
    }
}