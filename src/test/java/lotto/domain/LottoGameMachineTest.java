package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameMachineTest {

    private LottoGameMachine lottoGameMachine;
    @BeforeEach
    void setUp() {
        lottoGameMachine = new LottoGameMachine();
    }
    @Test
    void validateLottoPayment() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoGameMachine.validateLottoPayment(1200);
        });
    }
}