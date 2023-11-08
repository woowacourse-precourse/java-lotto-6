package lotto.domain.answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryAnswerControllerTest {
    private LotteryAnswerController lotteryAnswerController;
    private final InputStream systemIn = System.in;

    @BeforeEach
    void setUp() {
        lotteryAnswerController = new LotteryAnswerController();
        System.setIn(systemIn);
    }

    @AfterEach
    void tearDown() {
        lotteryAnswerController = null;
        System.setIn(systemIn);
        Console.close();
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("로또 보너스 번호를 입력받습니다.")
    public void 로또보너스번호_입력() {
        // GIVEN
        String bonusInput = "1,2,3,4,5,6" + System.getProperty("line.separator")
                + "1" + System.getProperty("line.separator");
        setInput(bonusInput);
        // WHEN
        LottoAnswer answer = lotteryAnswerController.getAnswer();
        // THEN
        assertNotNull(answer);
        assertEquals(answer.getAnswerSize(), 6);
    }

    @Test
    void printResult() {
        // GIVEN
        Map<Integer, Integer> rankToCount = new HashMap<>();
        rankToCount.put(2, 2);
        rankToCount.put(4, 1);
        rankToCount.put(5, 1);
        // WHEN
        lotteryAnswerController.printResult(rankToCount);

        // THEN
    }
}