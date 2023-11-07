package lotto.controller;

import lotto.type.ResultType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}