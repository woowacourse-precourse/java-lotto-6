package lotto.domain;

import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        //given, when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
            new Lotto(List.of(1, 2, 3, 4, 5, 6, 7));
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT.get(6));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        //given, when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
            new Lotto(List.of(1, 2, 3, 4, 5, 5));
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.DUPLICATED_LOTTO_NUMBER.get());
    }

    @DisplayName("로또 번호에 해당 숫자가 존재하는 경우")
    @Test
    void containsLottoNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = new LottoNumber(3);

        //when
        boolean result = lotto.contains(lottoNumber);

        //then
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("로또 번호에 해당 숫자가 존재하지 않은 경우")
    @Test
    void notContainsLottoNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = new LottoNumber(3);

        //when
        boolean result = lotto.contains(lottoNumber);

        //then
        assertThat(result).isEqualTo(true);
    }
}