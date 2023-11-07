package lotto;

import static lotto.constant.ErrorMessage.DUPLICATED_LOTTO_NUMBERS;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_NUMBERS_AMOUNT;
import static lotto.constant.ErrorMessage.NOT_IN_RANGE_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.generator.CustomIntegerListGenerator;
import lotto.generator.IntegerListGenerator;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {

    @Nested
    @DisplayName("로또가 로또번호 목록을 받아 생성된다.")
    class createLotto {
        @DisplayName("[성공] 로또 번호 목록은 정렬되어 생성된다.")
        @Test
        void createLottoUnsorted() {
            // given
            List<Integer> lottoNumbers = List.of(7, 6, 4, 1, 2, 3);
            List<Integer> expected = lottoNumbers.stream().sorted().toList();

            // when
            Lotto result = Lotto.from(lottoNumbers);

            // then
            assertThat(result).hasFieldOrPropertyWithValue("numbers", expected);
        }

        @DisplayName("[실패] 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            //given
            List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

            //when //then
            assertThatThrownBy(() -> Lotto.from(lottoNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_LOTTO_NUMBERS_AMOUNT.toString());
        }

        @DisplayName("[실패] 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void createLottoByDuplicatedNumber() {
            //given
            List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5);

            //when //then
            assertThatThrownBy(() -> Lotto.from(duplicatedNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(DUPLICATED_LOTTO_NUMBERS.toString());
        }

        @DisplayName("[실패] 로또 번호가 지정된 범위 내에 없으면 예외가 발생한다.")
        @Test
        void createLottoByNotInRangeOfLotto() {
            //given
            List<Integer> notInRangeNumbers = List.of(1, 2, 3, 4, 47, 56);

            //when //then
            assertThatThrownBy(() -> Lotto.from(notInRangeNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NOT_IN_RANGE_LOTTO_NUMBER.toString());
        }
    }

    @DisplayName("구입가격에 비례하여 로또 번호목록들을 생성한다.")
    @Test
    void createRandomLottos() {
        // given
        PurchasePrice purchasePrice = PurchasePrice.from(2000L);
        IntegerListGenerator generator = new CustomIntegerListGenerator();
        int expectedSize = (int) purchasePrice.getLottoCount();
        List<Integer> expectedNumbers = generator.generateIntegerList();

        // when
        List<Lotto> results = Lotto.createRandomLottos(purchasePrice, generator);

        // then
        assertThat(results).hasSize(expectedSize);
        assertThat(results).extracting("numbers")
                .containsExactlyInAnyOrder(
                        expectedNumbers,
                        expectedNumbers
                );
    }

    @DisplayName("로또 번호 목록 내 해당 번호가 포함되는지 체크한다.")
    @CsvSource({"1,true", "45,false", "6,true"})
    @ParameterizedTest
    void isLottoContainsNumberTrue(int number, boolean expected) {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean result = lotto.isLottoContainsNumber(number);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("로또 간 같은 숫자의 개수를 계산한다.")
    @Test
    void calculateSameNumbers() {
        // given
        Lotto givenLotto = Lotto.from(List.of(1, 4, 6, 8, 9, 10));
        Lotto otherLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        int expected = 3;

        // when
        int result = givenLotto.calculateSameNumbers(otherLotto);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
