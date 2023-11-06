package lotto;

import lotto.code.PrizeType;
import lotto.dto.WinningLottoNumberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(numbers));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(numbers));
    }

    @DisplayName("로또 번호가 지정된 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 53);
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(numbers));
    }

    @DisplayName("로또 번호와 당첨 번호가 동일한 경우 1등(prizeType) 리턴된다.")
    @Test
    void checkWinning() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto = new Lotto(numbers);

        WinningLottoNumberDto winningLottoNumber = new WinningLottoNumberDto(numbers, 7);
        PrizeType returnPrizeType = lotto.checkWinning(winningLottoNumber);

        assertEquals(PrizeType.FIRST, returnPrizeType);
    }
}
