package lotto.controller;

import lotto.type.ResultType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultControllerTest {

    ResultController resultController;
    @BeforeEach
    void initResultController() {
        resultController = new ResultController();
    }

    @DisplayName("결과 판단에 대한 정상 테스트")
    @Test
    void getLottoResultTest() {
        assertThat(resultController.getRankResult(5, false))
                .isEqualTo(ResultType.FIFTH);
    }
}