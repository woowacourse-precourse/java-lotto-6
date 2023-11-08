package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    private LottoStore lottoStore;
    @BeforeEach
    void setUp() {
        lottoStore = new LottoStore();
    }

    @DisplayName("구매 금액을 1000으로 나눠서 그 수만큼 로또를 생성한다.")
    @Test
    void createLottoByDividedPurchaseAmount() {
        //Given
        int purchaseAmount = 2000;
        //When
        List<Lotto> lottos = lottoStore.createLottos(purchaseAmount);
        //Then
        assertThat(lottos.size()).isEqualTo(2);
    }

    @DisplayName("로또 생성 시 정렬된 숫자로 저장한다.")
    @Test
    void sortedNumbers() {
        //Given
        boolean isSorted = false;
        //When
        List<Lotto> lottos = lottoStore.createLottos(1000);
        List<Integer> numbers = lottos.get(0).getNumbers();
        List<Integer> sortedNumbers = new ArrayList<>(numbers);

        Collections.sort(sortedNumbers);

        if(numbers.equals(sortedNumbers)){
            isSorted = true;
        }
        //Then
        assertThat(isSorted).isTrue();
    }
}
