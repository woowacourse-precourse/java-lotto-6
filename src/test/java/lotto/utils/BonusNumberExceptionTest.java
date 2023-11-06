package lotto.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BonusNumberExceptionTest {

    BonusNumberException bonusNumberException = new BonusNumberException();

    @Test
    void 보너스_번호_범위_벗어난_입력 () {
        assertThrows(IllegalArgumentException.class, () ->
                bonusNumberException.outsideRange("46"), "[ERROR]입력을 초과했습니다.");
    }

    @Test
    void 보너스_번호_당첨_번호_중복 () {
        assertThrows(IllegalArgumentException.class, () ->
                bonusNumberException.duplicateNumber(List.of("1","2","3","4","5","6"),"5"), "[ERROR]입력이 중복되었습니다.");
    }

    @Test
    void 보너스_번호_숫자가_아닌_경우 () {
        assertThrows(IllegalArgumentException.class, () ->
                bonusNumberException.notNumeric("a"), "[ERROR]숫자를 입력하세요.");
    }
}
/*
*  보너스 번호를 1개 초과해서 입력한 경우
   보너스 번호가 당첨번호와 중복된 경우
   보너스 번호가 숫자가 아닌 값을 입력한 경우
* */