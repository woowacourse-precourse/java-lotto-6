package lotto.model;

import static lotto.exception.ExceptionMessage.UNVALID_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @Test
    @DisplayName("로또에게 특정 수를 가지고 있는지 확인")
    void isLottoHaveNumberCorrectTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = LottoNumber.from("1");

        // when & then
        assertThat(lotto.isContainsNumber(lottoNumber)).isTrue();
    }

    @Test
    @DisplayName("로또에게 특정 수 목록의 교집합 갯수가 정상적으로 계산되는지 확인")
    void isLottoHaveNumbersWithSizeTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<LottoNumber> lottoNumbers = List.of(
                LottoNumber.from("1"),
                LottoNumber.from("2"),
                LottoNumber.from("3")
        );

        // when & then
        assertThat(lotto.isContainsNumbersWithSize(lottoNumbers, 3)).isTrue();
    }

    @Test
    @DisplayName("로또 숫자 중 1 ~ 45 이외의 수가 있다면 예외가 발생한다.")
    void lottoNumberValuesExceptionTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 100, 20, 30, 40, -1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UNVALID_LOTTO_NUMBER.getMessage());
    }
}
