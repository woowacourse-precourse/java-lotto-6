package lotto.domain;

import lotto.domain.Lotto;
import lotto.enums.ErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessages.OVER_MAX_SIZE_MESSAGE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.DUPLICATE_NUMBER_MESSAGE.getMessage());
    }

    // 아래에 추가 테스트 작성 가능
    private Lotto lotto;
    @DisplayName("로또 생성")
    @BeforeEach
    @Test
    void createLotto() {
        lotto = new Lotto(List.of(1,2,3,4,5,6));
    }

    @DisplayName("로또 번호의 숫자 범위에 1~45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByInvalidRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
    }

    @DisplayName("로또객체 문자열로 가져오기")
    @Test
    void getLottoToString() {
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        assertThat(lotto.toHash()).contains("lotto.domain.Lotto@");
    }

    @DisplayName("로또 객체 가져오기")
    @Test
    void getLotto() {
        assertThat(lotto.getLottoNumbers().stream()
                .mapToInt(LottoNumber::getNumber)
        ).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("다른 로또번호와 비교 로직 테스트")
    @Test
    public void countMatchedNumbersLogicTest() {
        Lotto otherLotto = new Lotto("1,2,3,4,5,6");
        int count = lotto.getLottoNumbers().stream()
                .filter(otherLotto::contains)
                .map(lottoNumber -> 1)
                .reduce(0, Integer::sum);

        assertThat(count).isEqualTo(6);
    }

    @DisplayName("다른 로또번호와 구현 테스트")
    @Test
    public void countMatchedNumbers() {
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int count = lotto.countMatchedNumbers(winningLotto);
        assertThat(count).isEqualTo(6);
    }
}