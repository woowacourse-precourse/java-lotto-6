package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("구매금액을 1000 이하로 입력시 예외가 발생한다.")
    @Test
    void under1000InputThrowError() {
        assertThatThrownBy(() -> new LottoGame().moneyToLottos("900"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액을 1000 단위로 입력하지 않을 시 예외가 발생한다.")
    @Test
    void not1000InputThrowError() {
        assertThatThrownBy(() -> new LottoGame().moneyToLottos("1099"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액 입력이 정수가 아닐 시 예외가 발생한다.")
    @Test
    void notIntegerInputThrowError() {
        assertThatThrownBy(() -> new LottoGame().moneyToLottos("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("실수를 반올림한 1000 단위 쉼표 문자열로 변환한다")
    @Test
    void floatBigDataToFormattedString() {
        LottoGame lottoGame = new LottoGame();
        String formattedValue = lottoGame.floatValueFormatter(9999.95);
        assertThat(formattedValue).isEqualTo("10,000.0");
    }

    @DisplayName("1 미만의 실수를 정수 0을 포함한 문자열로 변환한다")
    @Test
    void floatSmallDataToFormattedString() {
        LottoGame lottoGame = new LottoGame();
        String formattedValue = lottoGame.floatValueFormatter(0.456);
        assertThat(formattedValue).isEqualTo("0.5");
    }
}