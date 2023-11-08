package lotto.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyLottoRepositoryTest {

    static BuyLottoRepository buyLottos = new BuyLottoRepository();

    @BeforeAll
    static void start(){
        Lotto lotto1 = new Lotto(Arrays.asList(2, 5, 6, 34, 12, 14));
        Lotto lotto2 = new Lotto(Arrays.asList(34, 2, 23, 5, 15, 4));
        Lotto lotto3 = new Lotto(Arrays.asList(7, 45, 6, 35, 23, 33));
        buyLottos.add(lotto1);
        buyLottos.add(lotto2);
        buyLottos.add(lotto3);
    }

    @DisplayName("복권을 얼마나 구매했는지 알려줍니다.")
    @Test
    void sizeBuyLotts() {
        assertThat(buyLottos.size()).isEqualTo(3);
    }

    @DisplayName("구매한 복권은 오름차순으로 출력됩니다.")
    @Test
    void extractAscendingNumbers() {
        // when
        List<String> buyLotto = buyLottos.extractAscendingNumbers();
        for (String numbers : buyLotto) {
            Integer[] array = Arrays.stream(numbers.split(", "))
                                    .map(Integer::parseInt)
                                    .toArray(Integer[]::new);
            testAscending(array);
        }
    }

    private void testAscending(Integer[] array) {
        for(int i=0;i<=4;i++){
            assertThat(array[i])
                    .isLessThanOrEqualTo(array[i+1]);
        }
    }


}