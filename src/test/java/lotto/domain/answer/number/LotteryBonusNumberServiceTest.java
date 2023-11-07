package lotto.domain.answer.number;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryBonusNumberServiceTest {

    private LotteryBonusNumberService bonusNumberService;
    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;

    @BeforeEach
    void setUp() {
        bonusNumberService = new LotteryBonusNumberService();
    }

    @AfterEach
    void tearDown() {
        bonusNumberService = null;
        System.setIn(systemIn);
    }

    private void setInput(String input) {
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
    }

    @Test
    @DisplayName("로또 보너스 번호를 입력받습니다.")
    public void 로또보너스번호_입력() throws Exception {
        // GIVEN
        String bonusInput = "3";
        setInput(bonusInput);
        // WHEN
        Integer bonusAnswer = bonusNumberService.getBonusAnswer();
        // THEN
        assertNotNull(bonusAnswer);
    }
}