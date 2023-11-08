package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    private final Lottos lottos = new Lottos();
    @DisplayName("로또 구입 갯수만큼 생성되었는지 테스트")
    @Test
    void createLottosTest(){
        List<Integer> expectedNumbers1 = List.of(8, 21, 23, 41, 42, 43);
        List<Integer> expectedNumbers2 = List.of(3, 5, 11, 16, 32, 38);
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    Lottos lottos = new Lottos(2);
                    Lotto lotto1 = lottos.getLottos().get(0);
                    Lotto lotto2 = lottos.getLottos().get(1);
                    assertThat(lotto1.getNumbers()).isEqualTo(expectedNumbers1);
                    assertThat(lotto2.getNumbers()).isEqualTo(expectedNumbers2);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @DisplayName("createLotto 테스트")
    @Test
    public void createLottoTest(){
        List<Integer> expectedNumbers = List.of(8, 21, 23, 41, 42, 43);
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    List<Integer> lotto = lottos.createLotto();
                    assertThat(lotto).isEqualTo(expectedNumbers);
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }


}
