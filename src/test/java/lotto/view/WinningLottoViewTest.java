package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.consts.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoViewTest extends NsTest {
    private List<Integer> lotto;
    private int bonus;

    @DisplayName("로또번호와 보너스 번호를 받아온다")
    @Test
    void winnigLotto_입력() {
        String lottoInput = "1,2,3,4,5,6";
        String bonusInput = "10";
        assertSimpleTest(() -> {
            run(lottoInput, bonusInput);
            assertThat(lotto).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
            assertThat(bonus).isEqualTo(10);
        });
    }

    @Nested
    @DisplayName("로또번호 입력")
    class Lotto {
        @DisplayName("로또의 개수가 6개가 아닐때, 예외 처리")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
        void winningLotto_로또의_개수_6개(String lottoInput) {
            assertSimpleTest(() -> {
                runException(lottoInput);
                assertThat(output()).contains(ErrorMessage.ERROR_MESSAGE_NOT_ENOUGH_LOTTO_NUMBER.getMessage());
            });
        }

        @DisplayName("로또의 번호가 중복됐을 경우, 예외 처리")
        @Test
        void winningLotto_로또번호_중복() {
            String lottoInput = "1,2,3,4,5,5";
            assertSimpleTest(() -> {
                runException(lottoInput);
                assertThat(output()).contains(ErrorMessage.ERROR_MESSAGE_DUPLICATED_EXISTENCE.getMessage());
            });
        }

        @DisplayName("입력된 로또 번호가 숫자가 아닐 경우, 예외 처리")
        @Test
        void winningLotto_로또의_번호_숫자_아님() {
            String lottoInput = "일,이,삼,사,오,6";
            assertSimpleTest(() -> {
                runException(lottoInput);
                assertThat(output()).contains(ErrorMessage.ERROR_MESSAGE_LOTTO_NUMBER.getMessage());
            });
        }

        @DisplayName("로또의 번호가 범위를 벗어났을 경우, 예외 처리")
        @Test
        void winningLotto_로또번호_범위_밖() {
            String lottoInput = "1,2,3,49,5,45";
            assertSimpleTest(() -> {
                runException(lottoInput);
                assertThat(output()).contains(ErrorMessage.ERROR_MESSAGE_LOTTO_NUMBER.getMessage());
            });
        }

        @DisplayName("로또의 번호를 콤마가 아닌 다른 특수문자로 구분할 경우, 예외 처리")
        @Test
        void winningLotto_로또번호_구분자() {
            String lottoInput = "1.2.3,4,5,45";
            assertSimpleTest(() -> {
                runException(lottoInput);
                assertThat(output()).contains(ErrorMessage.ERROR_MESSAGE_NO_SEPARATOR.getMessage());
            });
        }

        @DisplayName("로또의 번호를 공백과 함께 입력했을 경우, 예외 처리")
        @Test
        void winningLotto_로또번호_공백과_함께_입력() {
            String lottoInput = "1, 2, 3, 4, 5, 9";
            assertSimpleTest(() -> {
                runException(lottoInput);
                assertThat(output()).contains(ErrorMessage.ERROR_MESSAGE_NO_SEPARATOR.getMessage());
            });
        }
    }

    @Nested
    @DisplayName("로또 번호 입력 후, 보너스 번호 입력")
    class Bonus {
        @DisplayName("보너스 번호가 숫자가 아닐 경우, 예외 처리")
        @Test
        void winningLotto_보너스번호_숫자_아님() {
            String lottoInput = "1,2,3,4,5,9";
            String bonusInput = "구";
            assertSimpleTest(() -> {
                runException(lottoInput, bonusInput);
                assertThat(output()).contains(ErrorMessage.ERROR_MESSAGE_LOTTO_NUMBER.getMessage());
            });
        }

        @DisplayName("보너스 번호가 범위를 벗아날 때, 예외 처리")
        @Test
        void winningLotto_보너스번호_범위_밖() {
            String lottoInput = "1,2,3,4,5,9";
            String bonusInput = "90";
            assertSimpleTest(() -> {
                runException(lottoInput, bonusInput);
                assertThat(output()).contains(ErrorMessage.ERROR_MESSAGE_LOTTO_NUMBER.getMessage());
            });
        }

        @DisplayName("보너스 번호의 형식이 틀렸을 경우, 예외 처리")
        @Test
        void winningLotto_보너스번호_형식() {
            String lottoInput = "1,2,3,4,5,8";
            String bonusInput = "09";
            assertSimpleTest(() -> {
                runException(lottoInput, bonusInput);
                assertThat(output()).contains(ErrorMessage.ERROR_MESSAGE_LOTTO_NUMBER.getMessage());
            });
        }

        @DisplayName("로또의 번호와 보너스 번호가 중복됐을 경우, 예외 처리")
        @Test
        void winningLotto_로또번호_보너스번호_중복() {
            String lottoInput = "1,2,3,4,5,9";
            String bonusInput = "9";
            assertSimpleTest(() -> {
                runException(lottoInput, bonusInput);
                assertThat(output()).contains(ErrorMessage.ERROR_MESSAGE_DUPLICATED_EXISTENCE.getMessage());
            });
        }
    }

    @Override
    protected void runMain() {
        lotto = WinningLottoView.publishLotto();
        bonus = WinningLottoView.publishBonus(lotto);
    }
}
