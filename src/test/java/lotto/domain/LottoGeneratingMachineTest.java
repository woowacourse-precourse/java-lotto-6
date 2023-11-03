package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGeneratingMachineTest {
    @ParameterizedTest
    @DisplayName("로또 생성 실패 테스트 - 생성할 수 없는 개수")
    @ValueSource(ints = {-1, 0})
    void createLottoTicketsImpossibleInitSizeFailTest(int initSize) {
        LottoGeneratingMachine lottoGeneratingMachine = new LottoGeneratingMachine();
        assertThrows(IllegalArgumentException.class, () -> lottoGeneratingMachine.generateRandomLottoTickets(initSize));
    }
}
