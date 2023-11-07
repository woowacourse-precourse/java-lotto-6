package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoResultCalculationTest {
    LottoResultCalculation lottoResultCalculation;
    @BeforeEach
    void initLottoResultCaculation() {
        lottoResultCalculation = new LottoResultCalculation();
    }

    @DisplayName("로또 구입 금액이 1,000원 단위로 나누어 떨어지지 않을 때 예외 발생")
    @Test
    void InputMoneyException() {
        assertThatThrownBy(() -> {
            lottoResultCalculation.caculateLottoTicket(16500);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 결과에 대한 정상 테스트")
    @Test
    void checkResultTest() {
        assertThat(lottoResultCalculation.checkResult
                (List.of(20, 30, 24, 1, 3, 4)
                , List.of(30, 24, 5, 8, 10, 20)))
                .isEqualTo(3);
    }

    @DisplayName("보너스 숫자에 대한 정상 테스트")
    @Test
    void checkBounsNumberTest() {
        assertThat(lottoResultCalculation.checkBonusNumber
                (List.of(20, 30, 24, 1, 3, 4), 3))
                .isTrue();
    }

    @DisplayName("수익률 계산에 대한 정상 테스트")
    @Test
    void calculateReturnTest() {
        lottoResultCalculation.caculateLottoTicket(15000);
        assertThat(lottoResultCalculation.calculateReturn(50000))
                .isEqualTo(333.3);
    }
}