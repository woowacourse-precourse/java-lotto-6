package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ExceedsMaxLottoNumberException;
import lotto.exception.LessThanMinLottoNumberException;
import lotto.vo.BonusNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    LottoNumberGenerator numberGenerator;

    @BeforeEach
    void init() {
        numberGenerator = new LottoNumberGenerator() {
            @Override
            public List<Integer> pickNumbers() {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        };
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45 이상인 경우 예외가 발생한다.")
    @Test
    void create_Exceeds_Max_LottoNumber_test() {
        // when
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 50, 60);

        // then
        assertThrows(ExceedsMaxLottoNumberException.class,
                () -> new Lotto(invalidNumbers));
    }

    @DisplayName("로또 번호가 0 이하인 경우 예외가 발생한다.")
    @Test
    void create_Less_Min_LottoNumber_test() {
        // when
        List<Integer> invalidNumbers = Arrays.asList(0, 1, 2, 3, 4, 5);

        // then
        assertThrows(LessThanMinLottoNumberException.class,
                () -> new Lotto(invalidNumbers));
    }

    @DisplayName("로또 번호 자동 6개 생성 테스트")
    @Test
    void create_lotto_with_NumberGenerator_test() {
        // when
        Lotto lotto = Lotto.createLotto(numberGenerator);

        // then
        assertNotNull(lotto);
        assertEquals(lotto.getNumbers().size(), 6);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), lotto.getNumbers());
    }

    @DisplayName("일치하는 번호 개수 테스트")
    @Test
    void countMatchedNumber_test() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.createWinningLotto(numbers);
        Lotto otherLotto = Lotto.createWinningLotto(numbers);

        // when
        int count = lotto.countMatchedNumbers(otherLotto);

        // then
        assertEquals(6, count);
    }

    @DisplayName("보너스 번호를 포함하는 지 검사하는 기능 테스트")
    @Test
    void isContainBonusNumber_test() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.createWinningLotto(numbers);

        // when
        BonusNumber bonusNumber = new BonusNumber(6);
        boolean isContained = lotto.checkBonusNumberContain(bonusNumber);

        assertTrue(isContained);
    }

    @DisplayName("번호를 포함하고 지 검사하는 기능 테스트")
    @Test
    void contain_test() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.createWinningLotto(numbers);

        // when
        boolean contains = lotto.contain(1);

        // then
        assertTrue(contains);
    }
}
