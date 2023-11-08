package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    LottoController lottoController;

    @BeforeEach
    void init() {
        lottoController = new LottoController();
    }

    @DisplayName("문자열 내 공백 삭제")
    @Test
    void removeSpace() {
        String result = lottoController.removeSpace("1, 2, 3,4, 5,6");

        assertThat(result).contains("1,2,3,4,5,6");
    }
}