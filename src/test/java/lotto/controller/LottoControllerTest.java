package lotto.controller;

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
        lottoController.getLottoNumber(5);
        String result = lottoController.getLottoString();
        assertThat(result).contains("[", "]");
    }
}