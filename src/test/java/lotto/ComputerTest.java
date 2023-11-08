package lotto;

import lotto.domain.Computer;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTest {
    @DisplayName("로또 리스트가 성공적으로 생성 되었는가?")
    @Test
    public void testMakeLottoList() {
        Computer computer = new Computer();
        int lottoCount = 5; // 예를 들어, 5개의 Lotto 객체를 생성하도록 테스트

        List<Lotto> lottoList = computer.makeLottoList(lottoCount);

        // 생성된 Lotto 객체 개수가 예상한 개수와 일치하는지 확인
        assertEquals(lottoCount, lottoList.size());
    }
}
