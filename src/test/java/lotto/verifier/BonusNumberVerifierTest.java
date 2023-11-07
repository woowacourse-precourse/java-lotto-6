package lotto.verifier;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.system.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BonusNumberVerifierTest extends NsTest {

    @Nested
    class ValidInputTest {
        @Test
        void 정상입력이_주어진경우() {
            Assertions.assertSimpleTest(() -> {
                assertThatCode(() -> run("14000", "1,2,3,4,5,6","7"))
                        .doesNotThrowAnyException();
            });
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ExceptionTest {

        private final Verifier bonusNumberVerifier = new BonusNumberVerifier();
        @ParameterizedTest
        @DisplayName("checkNumeric 메서드 테스트")
        @CsvSource(value = {"13f","183j33", "10k00", "k832", "0/1?"})
        void 숫자가아닌_보너스번호가_주어진경우(String input) {
            assertThatThrownBy(() -> bonusNumberVerifier.check(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_NUMERIC);
        }
        @ParameterizedTest
        @DisplayName("checkTypeRange 메세드 테스트")
        @ValueSource(strings = {
                "-9223372036854775809",
                "9223372036854775808",
                "812878316387112231331"
        })
        void Long_타입으로변환될수없는_보너스번호가_주어진경우(String input){
            assertThatThrownBy(() -> bonusNumberVerifier.check(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_OUT_OF_TYPE_RANGE);
        }
        @ParameterizedTest
        @DisplayName("checkRange 메서드 테스트")
        @MethodSource("parameterProvider")
        void 보너스번호가_1부터45사이의_숫자가_아닌경우(String input) {
            assertThatThrownBy(() -> bonusNumberVerifier.check(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_EACH_OUT_OF_RANGE);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of( "72"),
                    Arguments.of("4823"),
                    Arguments.of("-24")

            );
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}