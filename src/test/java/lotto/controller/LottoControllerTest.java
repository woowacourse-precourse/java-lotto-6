package lotto.controller;

import lotto.type.ErrorMessageType;
import lotto.type.ResultType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoControllerTest {
    LottoController lottoController;
    @BeforeEach
    void initLottoGetter() {
        lottoController = new LottoController();
    }

    @DisplayName("무작위 로또 번호의 출력 확인")
    @Test
    void getLottoString() {
        lottoController.setRandomLottoNumber(5);
        String result = lottoController.getLottoString();
        assertThat(result).contains("[", "]");
    }

    @DisplayName("결과 판단에 대한 정상 테스트")
    @Test
    void getLottoResultTest() {
        assertThat(lottoController.getRankResult(5, false))
                .isEqualTo(ResultType.FIFTH);
    }

    @DisplayName("당첨 번호를 입력할 때 숫자가 아닌 문자가 있으면 예외 처리")
    @Test
    void notNumberException() {
        assertThatThrownBy(()-> {
            lottoController.setInputLottoNumber("a, 2, 14, 10, 23, 32");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessageType.NOT_NUMBER.message());
    }

    @DisplayName("당첨 번호를 입력할 때 범위에 벗어난 문자가 있으면 예외 처리")
    @Test
    void outOfNumberException() {
        assertThatThrownBy(()-> {
            lottoController.setInputLottoNumber("1, 2, 14, 10, 23, 47");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessageType.OUT_OF_LOTTO_NUMERICAL_RANGE.message());
    }
}