package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoTest {
    @DisplayName("당첨 혹은 보너스 번호 혹은 아무것도 아닌 경우를 구별 할 수 있다.")
    @ParameterizedTest(name = "추첨번호 : 1, 5, 7, 9, 11, 15 , 보너스 넘버 : 19 ---- 검증 대상: {0} ==> 결과 : {1}")
    @CsvSource(value = {"1,CORRECT", "19,BONUS", "23,NOTHING"})
    void judgeNumber(int testNumber, String expected) {
        //given
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 5, 7, 9, 11, 15));
        Integer bounusNumber = 19;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bounusNumber);

        //when
        NumberStatus result = winningLotto.judgeNumber(testNumber);

        assertThat(result.name()).isEqualTo(expected);
    }
}
