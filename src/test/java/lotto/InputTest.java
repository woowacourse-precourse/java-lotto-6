package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class InputTest extends NsTest{
        private static final String ERROR_MESSAGE = "[ERROR]";
        
        @Test
        @DisplayName("구매 입력에 문자열을 포함할때 예외")
        void 문자열_입력_예외_테스트() {
                assertSimpleTest(() -> {
                        runException("1000j");
                        assertThat(output()).contains(ERROR_MESSAGE);
                });
        }

        @Test
        @DisplayName("구매 단위가 1000원 단위가 아닐 때")
        void 천단위_가아닌_테스트() {
                assertSimpleTest(() -> {
                        runIllegalArgumentException("1500");
                        assertThat(output()).contains(ERROR_MESSAGE);
                });
        }

        @Test
        @DisplayName("당첨번호와 보너스 번호 중복 입력 테스트")
        void 당첨번호_보너스번호_중복테스트() {
                assertThatThrownBy(() -> Input.bonusNumberDuplicateCheck(new Lotto(List.of(31, 24, 43, 44, 23, 44)), 44))
                        .isInstanceOf(IllegalStateException.class);
        }

        @Test
        @DisplayName("보너스 번호 범위 초과 테스트")
        void 보너스번호_범위_테스트() {
                assertThatThrownBy(() -> Input.numberInRangeCheck(46))
                        .isInstanceOf(IllegalArgumentException.class);
        }

        @Override
        public void runMain() {
                Application.main(new String[]{});
        }

        protected final void runIllegalArgumentException(final String... args) {
                try {
                        run(args);
                } catch (final IllegalArgumentException ignore) {
                }
        }
}
