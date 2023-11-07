package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.issueChooseNumbersLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> Lotto.issueChooseNumbersLotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    @DisplayName("겹치지 않는 숫자 6개를 입력해 로또를 수동으로 발급받을 수 있다.")
    void issueChooseNumbersLottoTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> Lotto.issueChooseNumbersLotto(numbers))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("랜덤 6개의 서로 다른 숫자를 가진 로또를 자동 발행할 수 있다")
    void issueLottoTest() {
        Lotto lotto = Lotto.issueAutoPickNumbersLotto();
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers()
            .stream()
            .distinct()
            .toList();

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
