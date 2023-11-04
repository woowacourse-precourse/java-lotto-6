package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    static Stream generateData() {
        Stream argumentsStream = Stream.of(
                Arrays.asList(1, 2, 3, 4, 5, 45),
                Arrays.asList(10, 21, 35, 42, 7, 3)
        );
        return argumentsStream;
    }

    @DisplayName("1-45 6개의 랜덤 숫자가 든 복권 하나를 발행한다.")
    @ParameterizedTest
    @MethodSource("generateData")
    public void issueLotto(List<Integer> randomNumbers) {
        List<Integer> issuedLotto = lottoMachine.issueLotto(() -> randomNumbers);

        assertEquals(issuedLotto, randomNumbers);
    }

    @DisplayName("발행한 복권을 저장한다.")
    @Test
    public void issuedLottos() {
        List<Integer> issuedLotto1 = lottoMachine.issueLotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Lotto> issuedLottos = lottoMachine.getIssuedLottos();
        issuedLottos.stream().forEach(lotto ->
                assertEquals(lotto.getNumbers(), issuedLotto1));
    }

}
