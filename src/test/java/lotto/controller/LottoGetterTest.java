package lotto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGetterTest {
    LottoGetter lottoGetter;
    @BeforeEach
    void initLottoGetter() {
        lottoGetter = new LottoGetter();
    }

    @DisplayName("무작위 로또 번호의 출력 확인")
    @Test
    void getLottoString() {
        lottoGetter.getLottoNumber(5);
        String result = lottoGetter.getLottoString();
        assertThat(result).contains("[", "]");
    }
}