package lotto.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.dto.input.UserLottoDTO;
import lotto.util.Parser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class UserLottoDTOTest {
    // 공통 예외 부터
    // 사적 예외까지 검증해야 한다
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void userLottoDTO_Lotto_변환_검증(String inputLotto) {
        UserLottoDTO userLottoDTO = new UserLottoDTO(inputLotto);
        Lotto lotto = userLottoDTO.toLotto();

        assertThat(lotto).isEqualTo(Lotto.from(Parser.inputToLottoNumbers(inputLotto)));
    }

    @ParameterizedTest(name = "인자 : {0}")
    @NullAndEmptySource
    void 아무것도_입력하지_않은_경우_예외(String inputLotto) {
        assertThatThrownBy(() -> new UserLottoDTO(inputLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("아무것도 입력하지");
    }

    @ParameterizedTest(name = "인자 : {0}")
    @ValueSource(strings = {"1,2,abc" ,"ab한글_12", "123456,,"})
    void 로또_패턴이_아닌_경우_예외(String inputLotto) {
        assertThatThrownBy(() -> new UserLottoDTO(inputLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 (,) 로");
    }

    @ParameterizedTest(name = "인자 : {0}")
    @ValueSource(strings = {"1,02,3,4,5", "1,2,3,6,012,5", "01234"})
    void 로또_번호_중_0으로_시작하는_수가_있으면_예외(String inputLotto) {
        assertThatThrownBy(() -> new UserLottoDTO(inputLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0으로 시작하는 수는");
    }

    @ParameterizedTest(name = "인자 : {0}")
    @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,6,19,105", "1,2,3,4"})
    void 로또_패턴을_유지하고_0으로_시작하는_수라면_성공(String inputLotto) {
        assertThatNoException().isThrownBy(
                () -> new UserLottoDTO(inputLotto)
        );
    }
}
