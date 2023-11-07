package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.DuplicateNumberException;
import lotto.exception.InvalidSizeException;
import lotto.exception.LottoNumberOutOfRangeException;
import lotto.fixtures.LottoFixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @DisplayName("로또 번호의 숫자가 1~45 사이의 숫자를 생성하면 예외 발생")
    @Test
    void generateNumbersOutOfRange() {
        //given
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator(45, 65);

        // when then
        assertThatThrownBy(randomNumberGenerator::generate)
                .isInstanceOf(LottoNumberOutOfRangeException.class);
    }

    @DisplayName("로또 번호 숫자가 중복 되면 예외 발생")
    @Test
    void duplicateNumbers() {

        NumberGenerator generator = LottoFixtures::createDuplicateLotto;

        assertThatThrownBy(generator::generate)
                .isInstanceOf(DuplicateNumberException.class);
    }

    @DisplayName("로또 번호 개수가 6개가 아니라면 예외 발생")
    @Test
    void createOverOrUnderSize() {

        NumberGenerator generator = LottoFixtures::createUnderSizeLotto;

        assertThatThrownBy(generator::generate)
                .isInstanceOf(InvalidSizeException.class);
    }
}
