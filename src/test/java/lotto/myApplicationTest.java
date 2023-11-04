package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.User;
import lotto.utility.GameUtility;
import lotto.validator.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

public class myApplicationTest {

    @Nested
    @DisplayName("구입 금액 테스트")
    public class 구입_금액_테스트 {

        @ParameterizedTest
        @DisplayName("입력이 정수가 아니면 예외를 날리는 지 테스트한다.")
        @ValueSource(strings = {",", "a"})
        void 입력_정수테스트(String input) {
            Assertions.assertThatThrownBy(() -> Validator.validatePurchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @DisplayName("음수나 0을 넣었을 때 예외를 던지는 지 테스트한다.")
        @ValueSource(strings = {"-1", "0"})
        void 입력_음수테스트(String input) {
            Assertions.assertThatThrownBy(() -> Validator.validatePurchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @DisplayName("로또금액 단위에 안 맞으면 예외를 던지는 지 테스트한다.")
        @ValueSource(strings = {"100", "1100"})
        void 입력_단위테스트(String input) {
            Assertions.assertThatThrownBy(() -> Validator.validatePurchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @DisplayName("구입 금액 통합 테스트")
        @ValueSource(strings = {"1000", "5000"})
        void 구입_금액_통합테스트(String input) {
            Assertions.assertThatCode(() -> Validator.validatePurchaseAmount(input))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("로또 발행 테스트")
    public class 로또_발행테스트 extends NsTest {
        @ParameterizedTest
        @DisplayName("지불 금액만큼 로또가 발행되었는 지 테스트한다.")
        @CsvSource(value = "10000, 10")
        void 로또_발행테스트(int payment, int lottoAmount) {
            // given
            User user;
            // when
            user = GameUtility.buyLotties(payment);
            // then
            assertEquals(user.getLotties().size(), lottoAmount);
        }

        @Test
        @DisplayName("로또 번호가 오름차순인지 테스트 한다.")
        void 로또_오름차순_저장테스트() {
            // given

            List<Integer> LottoNumbers = new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43));

            // when, then
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        User user;
                        user = GameUtility.buyLotties(1000);
                        assertEquals(user.getLotties().get(0).getNumbers(),LottoNumbers);
                    },
                    Arrays.asList(43, 41, 42, 23, 21, 8)
            );
        }

        @Override
        protected void runMain() {
        }
    }
}
