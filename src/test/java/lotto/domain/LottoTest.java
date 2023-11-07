package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Lotto;
import domain.Lottos;
import domain.Money;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.LottoValidator;

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
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 숫자가 아닌 문자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByCharInput() {
        String numbers = "1,2,3,4,5,+";
        assertThatThrownBy(() -> new Lotto(LottoValidator.isNumeric(numbers)))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("로또 번호의 숫자 중 범위 초과 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 숫자 중 범위 미만 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByUnderRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 로또일 시 정상적으로 로또가 생성된다.")
    @Test
    void createValidLotto() {
        assertThatCode(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @DisplayName("정상적으로 로또 목록들이 생성된다.")
    @Test
    void createValidLottos() {
        Money money = new Money("5000");

        assertThatCode(() -> new Lottos(money.getLottoCount()))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 입력 금액에 맞게 로또가 생성된다.")
    @Test
    void createLottosMatchingInputMoney() {
        Money money = new Money("5000");
        Lottos lottos = new Lottos(money.getLottoCount());
        List<Lotto> lottoCount = lottos.getLottoList();

        assertThat(lottoCount.size()).isEqualTo(money.getLottoCount());
    }
}