package lotto.parser;

import lotto.exception.EmptyException;
import lotto.exception.InvalidLottoFormatException;
import lotto.exception.InvalidLottoLengthException;
import lotto.exception.InvalidLottoNumberRangeException;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.validator.InputLottoValidator.validateLotto;
import static lotto.validator.InputLottoValidator.validateLottoNumberRange;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoParserTest {

    @Test
    @DisplayName("Lotto 객체를 생성한다.")
    void parse() {
        //given
        String winningLotto = "1,2,3,4,5,6";
        //when
        Object newLotto = LottoParser.parse(winningLotto);
        //then
        assertThat(newLotto).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("길이 초과로 인한 Exception이 발생한다.")
    void parseException() {
        //given
        String winningLotto = "1,2,3,4,5,6,7";
        //when & then
        assertThrows(InvalidLottoLengthException.class, () -> validateLotto(winningLotto));
    }

    @Test
    @DisplayName("길이 부족으로 인한 Exception이 발생한다.")
    void parseException2() {
        //given
        String winningLotto = "1,2,3,4,5";
        //when & then
        assertThrows(InvalidLottoLengthException.class, () -> validateLotto(winningLotto));
    }

    @Test
    @DisplayName("End with comma로 인한 Exception이 발생한다.")
    void parseException3() {
        //given
        String winningLotto = "1,2,3,4,5,6,";
        //when & then
        assertThrows(InvalidLottoFormatException.class, () -> validateLotto(winningLotto));
    }

    @Test
    @DisplayName("Start with comma로 인한 Exception이 발생한다.")
    void parseException4() {
        //given
        String winningLotto = ",1,2,3,4,5,6";
        //when & then
        assertThrows(InvalidLottoFormatException.class, () -> validateLotto(winningLotto));
    }

    @Test
    @DisplayName("음수가 들어올 경우 Exception이 발생한다.")
    void parseException5() {
        //given
        String winningLotto = "1,-2,3,4,5,6,";
        //when & then
        assertThrows(InvalidLottoNumberRangeException.class, () -> validateLottoNumberRange(winningLotto));
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 들어올 경우 Exception이 발생한다.")
    void parseException6() {
        //given
        String winningLotto = "1,2,3,4,5,a";
        //when & then
        assertThrows(IllegalArgumentException.class, () -> validateLotto(winningLotto));
    }

    @Test
    @DisplayName("비어 있는 경우 Exception이 발생한다.")
    void parseException7() {
        //given
        String winningLotto = "";
        //when & then
        assertThrows(EmptyException.class, () -> validateLotto(winningLotto));
    }
}