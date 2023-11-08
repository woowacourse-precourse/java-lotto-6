package lotto.domain;

import lotto.constant.IllegalArgumentExceptionType;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RepeaterTest {

    @DisplayName("반복작업_테스트")
    @Test
    void checkRepeatProcess() {
        String repeatCompletedMessage = "반복완료";

        StringBuilder stringBuilder = new StringBuilder();
        Repeater repeater = new Repeater(stringBuilder::append);

        String result = repeater.repeatBeforeSuccess(() -> {
            if (stringBuilder.isEmpty()) {
                throw IllegalArgumentExceptionType.INSUFFICIENT_MONEY.getException();
            }
            return repeatCompletedMessage;
        });

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(stringBuilder.toString())
                .isEqualTo(IllegalArgumentExceptionType.INSUFFICIENT_MONEY.getMessage());

        softAssertions.assertThat(result).isEqualTo(repeatCompletedMessage);

        softAssertions.assertAll();
    }
}