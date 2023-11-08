package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.input.error.InputIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("중복된 로또 번호 객체 생성")
    @Test
    void createDuplicateLotto() {
        Assertions.assertSimpleTest(() -> {

            List<Integer> numbers = Arrays.asList(2, 23, 33, 9, 2, 45);
            assertThrows(InputIllegalArgumentException.class, () -> new Lotto(numbers));
        });
    }

    @DisplayName("범위에 맞지 않는 로또 생성")
    @Test
    void createLottoWithNumbersOutOfRange() {
        Assertions.assertSimpleTest(() -> {

            List<Integer> numbers = Arrays.asList(0, 33, 12, 42, 28, 50);
            assertThrows(InputIllegalArgumentException.class, () -> new Lotto(numbers));
        });
    }

    @DisplayName("보너스 숫자가 로또와 중복")
    @Test
    void testWithDuplicateBonusNumber() {
        Assertions.assertSimpleTest(() -> {
            List<Integer> numbers = Arrays.asList(12, 22, 34, 24, 17, 6);
            Lotto lotto = new Lotto(numbers);

            assertThrows(InputIllegalArgumentException.class, () -> lotto.validateContainsNumber(17));
        });
    }

    @DisplayName("로또가 정렬되어 저장")
    @Test
    void testLottoNumberIsSorted() {
        Assertions.assertSimpleTest(() -> {
            List<Integer> numbers = Arrays.asList(11, 12, 8, 40, 30, 35);
            Lotto lotto = new Lotto(numbers);

            List<Integer> expectedNumbers = Arrays.asList(8, 11, 12, 30, 35, 40);

            assertEquals(lotto.getLottoNumbers(), expectedNumbers);
        });
    }
}