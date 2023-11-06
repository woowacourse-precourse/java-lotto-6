package lotto.utility;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandlingTest {

    @DisplayName("입력된 로또를 쉼표로 구분하여 문자열 리스트로 분리하기")
    @Test
    void split() {

        // given
        String lotto = "1,2,3,4,5,6";

        // when, then
        assertThat(Handling.split(lotto)).isEqualTo(List.of("1", "2", "3", "4", "5", "6"));
    }

}