package lotto.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BonusNumberExceptionTest {

    BonusNumberException bonusNumberException = new BonusNumberException();

    @Test
    void 보너스_번호_범위_벗어난_입력 () {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                bonusNumberException.outsideRange("46"));

        assertEquals("[ERROR]입력 범위를 벗어났습니다.", exception.getMessage());
    }

    @Test
    void 보너스_번호_당첨_번호_중복 () {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                bonusNumberException.duplicateNumber(List.of("1","2","3","4","5","6"),"5"));

        assertEquals("[ERROR]입력이 중복되었습니다.", exception.getMessage());
    }

    @Test
    void 보너스_번호_숫자가_아닌_경우 () {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                bonusNumberException.notNumeric("a"));

        assertEquals("[ERROR]숫자를 입력하세요.", exception.getMessage());
    }
}
/*
*  보너스 번호를 1개 초과해서 입력한 경우
   보너스 번호가 당첨번호와 중복된 경우
   보너스 번호가 숫자가 아닌 값을 입력한 경우
* */