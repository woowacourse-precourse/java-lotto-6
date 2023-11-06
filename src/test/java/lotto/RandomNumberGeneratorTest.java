package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.exception.DuplicateNumberException;
import lotto.exception.InvalidSizeException;
import lotto.exception.LottoNumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @DisplayName("로또 번호의 숫자가 1~45 사이의 숫자를 생성하면 예외 발생")
    @Test
    void generateNumbersOutOfRange() {
        //given
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator(45,65);

        // when then
        assertThatThrownBy(randomNumberGenerator::generate)
                .isInstanceOf(LottoNumberOutOfRangeException.class);
    }

    @DisplayName("로또 번호 숫자가 중복 되면 예외 발생")
    @Test
    void duplicateNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.add(new LottoNumber(10));
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(40));
        lottoNumbers.add(new LottoNumber(35));
        lottoNumbers.add(new LottoNumber(17));
        lottoNumbers.add(new LottoNumber(10));

        NumberGenerator generator = () -> lottoNumbers;

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(DuplicateNumberException.class);
    }

    @DisplayName("로또 번호 개수가 6개가 아니라면 예외 발생")
    @Test
    void createOverOrUnderSize() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.add(new LottoNumber(10));
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(40));
        lottoNumbers.add(new LottoNumber(35));
        lottoNumbers.add(new LottoNumber(10));

        NumberGenerator generator = () -> lottoNumbers;

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(InvalidSizeException.class);
    }
}
