package lotto.DomainTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Domain.LottoSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoSystemTest {
    private LottoSystem lottoSystem;
    @BeforeEach
    void init(){
        lottoSystem = new LottoSystem();
    }
    @DisplayName("(예외처리) 6개의 숫자를 입력했는가?")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "1,2,3", "1,2", "1"})
    void storeLottoWinningNumberTest_숫자개수(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoSystem.storeLottoWinningNumber(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6자리여야 합니다.");
        ;
    }

    @DisplayName("(예외처리) 로또 번호가 1~45의 범위를 가지는가?")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,66", "-1,2,3,4,5,6"})
    void storeLottoWinningNumberTest_범위체크(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoSystem.storeLottoWinningNumber(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("(예외처리) 6개의 숫자가 서로 다른가?")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,2,4,5", "1,2,3,4,4,4"})
    void storeLottoWinningNumberTest_중복체크(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoSystem.storeLottoWinningNumber(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 각 자리수는 서로 달라야합니다.");
    }

    @DisplayName("(예외처리) 당첨번호와 보너스번호가 겹치는가?")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3","4","5","6"})
    void storeLottoBonusNumberTest_중복체크(String lottoBonusNumber) {
        lottoSystem.storeLottoWinningNumber("1,2,3,4,5,6");
        assertThatThrownBy(() -> lottoSystem.storeLottoBonusNumber(lottoBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 각 자리수는 서로 달라야합니다.");
    }

    @DisplayName("당첨 결과 만들기 테스트")
    @Test
    void compareLottoNumbersTest() {
        Map<String,Integer> expected = new HashMap<>();
        expected.put("2", 1);
        expected.put("3", 1); // 일반번호 3개와 보너스번호가 1개 맞으면, 4개 당첨이 아니라 3개 당첨이다.
        expected.put("7", 1);

        lottoSystem.storeLottoWinningNumber("1,2,3,4,5,6");
        lottoSystem.storeLottoBonusNumber("7");
        assertThat(lottoSystem.compareLottoNumbers(List.of("1,2,3,4,5,6","1,3,5,7,8,9","1,6,11,12,13,14"))).isEqualTo(expected);
    }


}
