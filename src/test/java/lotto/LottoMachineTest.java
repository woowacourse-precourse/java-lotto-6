package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoMachineTest {
    private LottoGenerator generator;
    private LottoMachine machine;
    @BeforeEach
    public void setUp() {
        // LottoGenerator를 목 객체로 생성
        generator = Mockito.mock(LottoGenerator.class);
        machine = new LottoMachine(generator);
    }
}
