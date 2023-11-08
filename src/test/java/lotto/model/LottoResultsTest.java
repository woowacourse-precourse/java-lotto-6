package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoResultsTest {

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createInputNonInteger() {
        String inputInteger = "12000";
        String inputString = "string";

        // 숫자 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> new LottoResults(inputInteger));

        // 문자 입력했을 때 예외 발생
        assertThatThrownBy(()->new LottoResults(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createInputNotDivided() {
        String inputDivided = "12000";
        String inputNotDivided = "120";

        // 1000으로 나누어 떨어지는 숫자 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> new LottoResults(inputDivided));

        // 1000으로 나누어 떨어지지 않는 숫자 입력했을 때 예외 발생
        assertThatThrownBy(()->new LottoResults(inputNotDivided))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값만큼 로또 장수를 파악하는지 확인한다.")
    @Test
    void checkLottoPapersNumber() {
        String inputMoney = "12000";
        Integer answer = 12;
        LottoResults lottoResults = new LottoResults(inputMoney);

        assertThat(lottoResults.getLottoPapers()).isEqualTo(answer);

    }

    @DisplayName("입력값이 매우 큰 경우 예외가 발생한다. 10 자리수 이상")
    @Test
    void createoverflowInteger() {
        String inputOverflowInteger = "10000000000";
        assertThatThrownBy(()->new LottoResults(inputOverflowInteger))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 결과가 제대로 계산되는지 확인한다.")
    @Test
    void updateEachLottoResult() {
        String inputMoney = "12000";
        int lottoMatch1 = 6;
        int lottoMatch2 = 5;
        boolean bonusMatch1 = false;
        boolean bonusMatch2 = true;

        // 1등 당첨된 경우 lottoMatch = 6, bonusMatch = false
        LottoResults lottoResults = new LottoResults(inputMoney);
        lottoResults.updateEachLottoResult(lottoMatch1, bonusMatch1);
        assertThat(lottoResults.getLottoResults()).isEqualTo(List.of(1,0,0,0,0));

        // 2등 당첨된 경우 lottoMatch = 5, bonusMatch = true
        LottoResults lottoResults2 = new LottoResults(inputMoney);
        lottoResults2.updateEachLottoResult(lottoMatch2, bonusMatch2);
        assertThat(lottoResults2.getLottoResults()).isEqualTo(List.of(0,1,0,0,0));

    }


}
