package lotto.view.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ErrorMessageTest {

    @DisplayName("예외 처리 문자열을 \"[ERROR]\"와 \"\\n\"을 붙여 반환한다.")
    @Test
    void getRankMessageByRank() {
        assertThat(ErrorMessage.CANT_DIVIDE.getMessage())
                .contains("[ERROR]", "\n");
    }

}