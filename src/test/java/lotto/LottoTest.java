package lotto;

import static lotto.constants.ErrorMessage.ERROR_LOTTO_NUMBER_DUPLICATE;
import static lotto.constants.ErrorMessage.ERROR_LOTTO_NUMBER_RANGE_OVER;
import static lotto.constants.ErrorMessage.ERROR_LOTTO_NUMBER_SIZE;
import static lotto.constants.TestGlobalConstant.ERROR_PREFIX_TEXT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, ERROR_LOTTO_NUMBER_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, ERROR_LOTTO_NUMBER_DUPLICATE.getMessage());
    }

    // 아래에 추가 테스트 작성 가능
    // 발행된 로또의 번호가 1 ~ 45 사이의 숫자 인지 확인 기능
    @ParameterizedTest
    @MethodSource("errorLottoData")
    @DisplayName("로또 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
    void createLottoByOverRangeNumber(List<Integer> lottoNumber) {
        assertThatThrownBy(() -> new Lotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, ERROR_LOTTO_NUMBER_RANGE_OVER.getMessage());
    }

    static Stream<Arguments> errorLottoData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 46)),
                Arguments.of(List.of(0, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(-1, 2, 3, 4, 5, 6))
        );
    }

    @Test
    @DisplayName("로또의 번호 생성 테스트")
    void createLottoNumberRangeCheckTest() {
        List<Integer> createLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        // new Lotto 생성 시 로또 범위 1 ~ 45 / 로또 번호 중복 / 로또 갯수 검증
        Assertions.assertThatNoException().isThrownBy(() -> new Lotto(createLottoNumber));
    }

}