package lotto.utils;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserInputTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 구입 금액 입력 오류 : NULL")
    @Test
    @Order(1)
    void 로또구매금액_NULL_입력_테스트() {
        assertSimpleTest(() -> {
            runException((String) null);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    
    @DisplayName("로또 구입 금액 입력 오류 : 문자 포함")
    @Test
    @Order(2)
    void 로또구매금액_문자_입력_테스트() {
        assertSimpleTest(() -> {
            runException("wrong123");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액 입력 오류 : 1000원 미만")
    @Test
    @Order(3)
    void 로또구매금액_부족_입력_테스트() {
        assertSimpleTest(() -> {
            runException("900");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력 오류 : NULL")
    @Test
    @Order(4)
    void 당첨번호_NULL_입력_테스트() {
        assertSimpleTest(() -> {
            runException("1000", (String) null);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력 오류 : 6개 미만 입력")
    @Test
    @Order(5)
    void 당첨번호_입력_부족_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력 오류 : 6개 초과 입력")
    @Test
    @Order(6)
    void 당첨번호_입력_초과_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력 오류 : 문자 포함")
    @Test
    @Order(7)
    void 당첨번호_문자_입력_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1a,2b,3c,4d,5e,6f");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력 오류 : 1~45 벗어남")
    @Test
    @Order(8)
    void 당첨번호_범위_이탈_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호 입력 오류 : NULL")
    @Test
    @Order(9)
    void 보너스번호_NULL_입력_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", (String) null);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호 입력 오류 : 문자 입력")
    @Test
    @Order(10)
    void 보너스번호_문자_입력_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6","aa");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호 입력 오류 : 1~45 벗어남")
    @Test
    @Order(11)
    void 보너스번호_범위_이탈_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6","47");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("정상 입력 테스트")
    @Test
    @Order(12)
    void 최종_정상_입력_테스트() {
        assertSimpleTest(() ->
                assertThatCode(() -> run("5000", "1,3,5,7,9,11","13"))
                        .doesNotThrowAnyException()
        );
    }

    @Override
    public void runMain() {
        UserInput userInput = new UserInput();

        userInput.inputLottoPrice();
        userInput.inputWinningNumbers();
        userInput.inputBonusNumber();
    }
}
