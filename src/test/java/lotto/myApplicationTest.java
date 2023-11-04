package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.dto.LottoTicketsDTO;
import lotto.utility.GameUtility;
import lotto.validator.LottoNumberValidator;
import lotto.validator.Validator;
import lotto.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
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
            user = GameUtility.buyTickets(payment);
            // then
            assertEquals(user.getLottoTickets().size(), lottoAmount);
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
                        user = GameUtility.buyTickets(1000);
                        assertEquals(user.getLottoTickets().get(0).getNumbers(), LottoNumbers);
                    },
                    Arrays.asList(43, 41, 42, 23, 21, 8)
            );
        }

        @Override
        protected void runMain() {
        }
    }

    @Nested
    @DisplayName("발행한 로또 수량 및 번호를 출력하는 기능 테스트")
    public class 발행_로또_수량_및_번호_테스트 {

        private static ByteArrayOutputStream outputMessage;

        @BeforeEach
        void setUpStreams() {
            outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
            System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
        }

        @AfterEach
        void restoresStreams() {
            System.setOut(System.out); // 원상복귀
        }

        @Test
        @DisplayName("발행한 로또 수량 및 로또 번호를 형식에 맞게 출력하는 지 테스트한다.")
        void 발행_로또_수량_및_번호_테스트() {
            // given
            Lotto lotto1 = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43));
            Lotto lotto2 = new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38));
            List<Lotto> lottoTickets = new ArrayList<>();
            lottoTickets.add(lotto1);
            lottoTickets.add(lotto2);
            LottoTicketsDTO lottoTicketsDTO = new LottoTicketsDTO(lottoTickets.size(), lottoTickets);
            // when
            // then

            OutputView.printLottoTickets(lottoTicketsDTO);
            assertThat(outputMessage.toString()).contains(
                    "2개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]"
            );
        }
    }

    @Nested
    @DisplayName("당첨 번호 입력 테스트")
    public class 당청_번호_입력_테스트 {


    }
}
