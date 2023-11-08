package lotto.domain;

import lotto.domain.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("로또 번호 생성 시")
    @Nested
    class GenerateLottoNumbersTest {

        private static final int PURCHASE_COUNT = 1;

        @DisplayName("[1, 45]범위의 중복이 없는 6개의 정수가 생성되어야 한다.")
        @Test
        void should_generateValidNumbers_when_generateLottoNumbers() {
            ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
            Lotto inputLotto = new Lotto(numbers);

            AllOfRandomLottoList lottoList = lottoService.getLottoList(PURCHASE_COUNT);

            assertThat(lottoList.getAllOfRandomLottoList().get(0).getRandomLottoList()).isSortedAccordingTo(Comparator.naturalOrder());
            assertThat(inputLotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        }

        @DisplayName("중복있는 숫자가 들어가면 실패한다.")
        @Test
        void should_fail_when_isDuplicateNumbers() {
            ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 3, 4, 5, 6));

            assertThatThrownBy(
                    () -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("1미만의 숫자가 들어가면 실패한다.")
        @Test
        void should_fail_when_hasLessThan1() {
            ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(-1, 1, 3, 4, 5, 6));

            assertThatThrownBy(
                    () -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("45초과의 숫자가 들어가면 실패한다.")
        @Test
        void should_fail_when_hasGreaterThan45() {
            ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(47, 1, 3, 4, 5, 6));

            assertThatThrownBy(
                    () -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("6자리가 아니면 실패한다.")
        @Test
        void should_fail_when_lengthIsNot6() {
            ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

            assertThatThrownBy(
                    () -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}