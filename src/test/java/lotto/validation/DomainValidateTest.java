package lotto.validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.config.ConstantNum.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DomainValidateTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void testNumberRange() {
        // given
        int wrongNum = 49;
        int num = 7;

        // when & then
        assertThatThrownBy(() -> DomainValidate.validateNumberInRange(wrongNum))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThatCode(() -> DomainValidate.validateNumberInRange(num)).doesNotThrowAnyException();
    }

    @Test
    void testLottoNumberCnt() {
        // given
        List<Integer> lotto = new ArrayList<>();
        List<Integer> bonus = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN.getNum(); i < LOTTO_NUMBER_MIN.getNum() + WINNING_NUMBER_CNT.getNum(); i++) {
            lotto.add(i);
        }
        for (int i = LOTTO_NUMBER_MIN.getNum(); i < LOTTO_NUMBER_MIN.getNum() + LOTTO_BONUS_NUMBER_CNT.getNum(); i++) {
            bonus.add(i);
        }
        List<Integer> wrongLotto = new ArrayList<>(lotto);
        List<Integer> wrongBonus = new ArrayList<>(bonus);
        wrongLotto.add(lotto.get(0));
        wrongBonus.add(bonus.get(0));

        // when & then
        assertThatThrownBy(() -> DomainValidate.validateNumberOfWinningNumbers(wrongBonus))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThatCode(() -> DomainValidate.validateNumberOfWinningNumbers(lotto)).doesNotThrowAnyException();
    }

    @Test
    void testBonusNumberCnt() {
        // given
        List<Integer> bonus = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN.getNum(); i < LOTTO_NUMBER_MIN.getNum() + LOTTO_BONUS_NUMBER_CNT.getNum(); i++) {
            bonus.add(i);
        }
        List<Integer> wrongBonus = new ArrayList<>(bonus);
        wrongBonus.add(bonus.get(0));

        // when & then
        assertThatThrownBy(() -> DomainValidate.validateNumberOfBonus(wrongBonus))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThatCode(() -> DomainValidate.validateNumberOfBonus(bonus)).doesNotThrowAnyException();
    }

    @Test
    void testValidateNegativeMoney() {
        // given
        int wrongMoney = -1400;
        int money = 1400;

        // when & then
        assertThatThrownBy(() -> DomainValidate.validateNegativeMoney(wrongMoney))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThatCode(() -> DomainValidate.validateNegativeMoney(money)).doesNotThrowAnyException();
    }

    @Test
    void testValidateDuplicated() {
        // given
        List<Integer> numbers = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN.getNum(); i < LOTTO_NUMBER_MIN.getNum() + WINNING_NUMBER_CNT.getNum(); i++) {
            numbers.add(i);
        }
        List<Integer> wrongNumbers = new ArrayList<>(numbers);
        wrongNumbers.set(WINNING_NUMBER_CNT.getNum() - 1, LOTTO_NUMBER_MIN.getNum());

        // when & then
        assertThatThrownBy(() -> DomainValidate.validateDuplicated(wrongNumbers))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThatCode(() -> DomainValidate.validateDuplicated(numbers)).doesNotThrowAnyException();
    }
}