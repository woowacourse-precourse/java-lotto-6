package lotto;

import java.lang.reflect.Field;
import java.util.ArrayList;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 비어있거나 null값이 들어오면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void createLottoByNullOrEmpty(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 부족하면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위(1 ~ 45) 밖의 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0,2,3,4,5,6", "1,2,3,4,5,46"})
    void createLottoByOutOfRange(String numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] parserNumber = numbers.split(",");

        for (String currentNumber : parserNumber) {
            lottoNumbers.add(Integer.parseInt(currentNumber));
        }

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호가 정상적으로 들어온 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,43,44,45"})
    void createLottoByNormal(String numbers) throws NoSuchFieldException, IllegalAccessException {
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] parserNumber = numbers.split(",");

        for (String currentNumber : parserNumber) {
            lottoNumbers.add(Integer.parseInt(currentNumber));
        }
        Lotto lotto = new Lotto(lottoNumbers);
        Field privateField = Lotto.class.getDeclaredField("numbers");
        privateField.setAccessible(true);
        List<Integer> lottoPrivateNumbers = (List<Integer>) privateField.get(lotto);

        assertEquals(lottoPrivateNumbers, lottoNumbers);
    }
}