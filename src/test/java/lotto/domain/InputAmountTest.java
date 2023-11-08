package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

class InputAmountTest {
    @Test
    void 정수_입력_시_예외_발생안함() {
        // Given a valid input string
        String validInput = "1000";

        // When handling the input
        int result = InputAmount.handlingNumber(validInput);

        // Then it should return the parsed integer
        assertThat(result).isEqualTo(1000);
    }

}