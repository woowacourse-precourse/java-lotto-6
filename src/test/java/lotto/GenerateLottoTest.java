package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Application.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GenerateLottoTest {

    @DisplayName("로또 번호가 중복없이 생성되는 지 보기 위한 테스트")
    @Test
    void TestGeneratedLottoNumber() {
        List<Integer> num = getLottoNumber();
        System.out.println(num);
    }

    @DisplayName("입력받은 purchaseLottoCount에 대해, 정확한 개수의 로또를 발행하는 지 확인")
    @Test
    void TestgeneratedLottos() {
        int expectedLottosSize = 13;
        List<Lotto> purchasedLottos = generateLottos(expectedLottosSize);
        int resultLottosSize = purchasedLottos.size();

        assertEquals(expectedLottosSize, resultLottosSize);

    }
}
