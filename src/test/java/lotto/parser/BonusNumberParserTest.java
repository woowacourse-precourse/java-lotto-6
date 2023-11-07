package lotto.parser;

import lotto.exception.DuplicatedNumberException;
import lotto.exception.InvalidLottoFormatException;
import lotto.exception.InvalidLottoNumberRangeException;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static lotto.validator.InputBonusValidator.validateBonus;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberParserTest {

    @Test
    @DisplayName("BonusNumber 객체를 생성한다.")
    void parse() {
        //given
        String bonusNumber = "7";
        //when
        Object newBonusNumber = BonusNumberParser.parse(LottoParser.parse("1,2,3,4,5,6"), bonusNumber);
        //then
        assertThat(newBonusNumber).isInstanceOf(BonusNumber.class);
    }

    @Test
    @DisplayName("LottoNumber의 중복으로 인해 Exception이 발생한다")
    void parseException() {
        //given
        String bonusNumber = "1";
        Lotto winningLotto = LottoParser.parse("1,2,3,4,5,6");
        //when & then
        assertThrows(DuplicatedNumberException.class, () -> validateBonus(winningLotto, bonusNumber));
    }

    @Test
    @DisplayName("LottoNumber의 범위가 1~45를 벗어나는 경우 Exception이 발생한다")
    void parseException2(){
        //given
        String bonusNumber = "46";
        Lotto winningLotto = LottoParser.parse("1,2,3,4,5,6");
        //when & then
        assertThrows(InvalidLottoNumberRangeException.class, () -> validateBonus(winningLotto, bonusNumber));
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 들어오는 경우 Exception이 발생한다")
    void parseException3(){
        //given
        String bonusNumber = "a";
        Lotto winningLotto = LottoParser.parse("1,2,3,4,5,6");
        //when & then
        assertThrows(InvalidLottoFormatException.class, () -> validateBonus(winningLotto, bonusNumber));
    }
}