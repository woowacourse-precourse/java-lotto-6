package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    private static final int LOTTO_FIXED_CIPHERS = 6;
    private static final int START_INCLUSIVE_LOTTO_NUMBER = 1;
    private static final int END_INCLUSIVE_LOTTO_NUMBER = 45;
    private static final String ERROR_CODE = "[ERROR]";

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

    @Test
    @DisplayName("Lotto 도메인은 생성과 동시에 로또 번호를 생성한다")
    void createLottoGeneratingNumbers() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers().size()).isEqualTo(LOTTO_FIXED_CIPHERS);
    }

    @Test
    @DisplayName("Lotto 도메인이 갖고있는 번호는 중복되지 않는다")
    void lottoNumbersHaveNeverDuplicatedNumbers() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("Lotto 도메인은 생성과 동시에 번호를 오름차순으로 정렬한다")
    void lottoNumberGeneratesSorted() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers()).isSorted();
    }

    @Test
    @DisplayName("중복되지 않은 범위 내의 숫자를 로또번호 자릿수만큼 생성자 매개변수에 전달하면 정상 동작")
    void gooLottoNumbers() {
        assertThatNoException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("6자리 미만의 숫자를 입력하면 [ERROR] 메시지와 IllegalArgumentException 발생")
    void tooSmallNumbers() {
        List<Integer> tooLittleNumbers = Arrays.asList(1, 2);
        assertThatThrownBy(() -> new Lotto(tooLittleNumbers))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(tooLittleNumbers))
                .hasMessageContaining(ERROR_CODE);
    }

    @Test
    @DisplayName("6자리 초과의 숫자를 입력하면 [ERROR] 메시지와 IllegalArgumentException 발생")
    void tooManuNumbers() {
        List<Integer> tooManyNumber = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> new Lotto(tooManyNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(tooManyNumber))
                .hasMessageContaining(ERROR_CODE);
    }

    @Test
    @DisplayName("중복된 숫자를 입력했을 겨웅에는 [ERROR] 메시지 발생")
    void 중복된_숫자를_생성자_매개변수에_입력하면_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 1, 1, 1, 1, 1)))
                .hasMessageContaining(ERROR_CODE);
    }

    @Test
    @DisplayName("45보다 큰 숫자가 입력되면 [ERROR] 메시지와 IllegalArgumentException 발생")
    void tooBigNumberContain() {
        List<Integer> tooBigNumberContain = Arrays.asList(1, 2, 3, 4, 5, END_INCLUSIVE_LOTTO_NUMBER + 1);
        assertThatThrownBy(() -> new Lotto(tooBigNumberContain))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(tooBigNumberContain))
                .hasMessageContaining(ERROR_CODE);
    }

    @Test
    @DisplayName("1보다 작은 숫자가 입력되면 [ERROR] 메시지와 IllegalArgumentException 발생")
    void tooSmallNumberContain() {
        List<Integer> tooSmallNumberContain = Arrays.asList(START_INCLUSIVE_LOTTO_NUMBER - 1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new Lotto(tooSmallNumberContain))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(tooSmallNumberContain))
                .hasMessageContaining(ERROR_CODE);
    }

    @Test
    @DisplayName("전달된 로또 번호가 비어있으면 [ERROR] 메시지와 IllegalArgumentException 발생")
    void emptyLottoNumbers() {
        List<Integer> emptyNumbers = new ArrayList<>();
        assertThatThrownBy(() -> new Lotto(emptyNumbers))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(emptyNumbers))
                .hasMessageContaining(ERROR_CODE);
    }

    @Test
    @DisplayName("전달된 로또 번호가 null이면 [ERROR] 메시지와 IllegalArgumentException 발생")
    void nullLottoNumbers() {
        assertThatThrownBy(() -> new Lotto(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(null))
                .hasMessageContaining(ERROR_CODE);
    }
}