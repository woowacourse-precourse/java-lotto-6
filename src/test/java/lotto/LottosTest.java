package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;


public class LottosTest {

    private final static Integer START = 0;
    private final static Integer TEST_SIZE = 5;
    @DisplayName("정해진 개수만큼 로또를 살 때 그 개수만큼 있는지 확인한다.")
    @Test
    void 로또_크기_테스트() {
        //given
        List<Lotto> numbers = new ArrayList<>();
        Lottos lottos;
        Integer lottosSize;

        //when
        for(int i = START; i < TEST_SIZE; i++) {
            numbers.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        lottos = new Lottos(numbers);
        lottosSize = lottos.getLottos().size();

        //then
        assertThat(lottosSize).isEqualTo(TEST_SIZE);

    }
}
