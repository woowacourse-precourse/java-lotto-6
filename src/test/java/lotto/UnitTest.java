package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UnitTest extends NsTest {
    @DisplayName("입력 금액의 입력이 제대로 되었는지 확인")
    @Test
    void input_money_Test() {
        assertSimpleTest(() -> {
            run("1900","a","2000");
            assertThat(output()).contains(
                    "[ERROR] 입력 금액은 1000의 배수로 입력해주세요.",
                    "[ERROR] 숫자를 입력해 주세요",
                    "2000");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}