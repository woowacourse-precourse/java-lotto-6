package lotto.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoUtilTest {
    @DisplayName("StringListToInt 타입 변환 테스트")
    @Test
    public void stringListToInt() {
        // given
        String inputLottoNumbers = "3,5,1,4,2,6";
        // when
        List<Integer> lottoNumbers = LottoUtil.lottoNumbersParser(inputLottoNumbers);
        // then
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        Assertions.assertEquals(expectedNumbers, lottoNumbers);
    }

    @DisplayName("보너스 번호 StringToInt 타입 변환 테스트")
    @Test
    public void bonusNumberTypeCasting() {
        // given
        String bonusNumber = "7";
        // when
        int result = LottoUtil.bonusNumberParser(bonusNumber);
        // then
        Assertions.assertEquals(7, result);
    }
}
