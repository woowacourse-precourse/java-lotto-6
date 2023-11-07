package lotto.domain.answer.number;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryAnswerNumberServiceTest {
    private LotteryAnswerNumberService answerNumberService;
    private final InputStream systemIn = System.in;

    @BeforeEach
    void setUp() {
        answerNumberService = new LotteryAnswerNumberService();
        System.setIn(systemIn);
    }

    @AfterEach
    void tearDown() {
        answerNumberService = null;
        System.setIn(systemIn);
        Console.close();
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("로또 당첨 번호를 입력받습니다.")
    public void 로또당첨번호_입력() {
        // GIVEN
        String lottoAnswerInput = "1,2,3,4,5,6";
        setInput(lottoAnswerInput);
        // WHEN
        Lotto lottoAnswer = answerNumberService.getLottoAnswer();
        // THEN
        assertNotNull(lottoAnswer);
    }
}