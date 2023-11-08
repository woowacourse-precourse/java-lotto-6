package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    private Lottos lottos;

    @BeforeEach
    public void setUp() {
        lottos = Lottos.from(5);
    }

    @Test
    @DisplayName("입력된 로또 갯수만큼 로또가 성공적으로 생성된다.")
    public void 로또_생성_테스트() {
        assertEquals(5, lottos.getSize());
    }

    @Test
    @DisplayName("List<Integer>을 List<Number>로 변환한다.")
    public void 정수_리스트의_입력을_래퍼_클래스의_리스트로_변환한다() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Number> result = Lottos.parse(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            assertEquals(numbers.get(i), result.get(i).getValue());
        }
    }

    @Test
    @DisplayName("Lottos의 변수인 List<Lotto>가 성공적으로 반환된다.")
    public void 로또_리스트_조회_테스트() {
        List<Lotto> result = lottos.getLottos();
        assertEquals(5, result.size());
    }
}
