package lotto.dto;

import lotto.domain.Lotto;
import lotto.dto.input.UserLottoDTO;
import lotto.util.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class UserLottoDTOTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void userLottoDTO_Lotto_변환_검증(String inputLotto) {
        UserLottoDTO userLottoDTO = new UserLottoDTO(inputLotto);
        Lotto lotto = userLottoDTO.toLotto();

        Assertions.assertThat(lotto).isEqualTo(Lotto.from(Parser.inputToLottoNumbers(inputLotto)));
    }

    @ParameterizedTest
    @MethodSource()
    void 예외() {

    }
}
