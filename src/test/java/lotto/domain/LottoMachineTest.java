package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void setUp() {
        lottoMachine = LottoMachine.getInstance();
    }

    @DisplayName("당첨 번호를 세팅하고 가져오는 기능 테스트")
    @Test
    public void given_SetWinningNumbers_when_GetWinningNumbers_then_ReturnsSetNumbers() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        lottoMachine.setWinningNumbers(winningNumbers);

        assertEquals(winningNumbers, lottoMachine.getWinningNumbers());
    }


}