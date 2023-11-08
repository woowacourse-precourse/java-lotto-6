package lotto.utils;

import lotto.Constants;
import lotto.domain.UserLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateLottoNumbersTest {
    private static final GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers();

    @DisplayName("로또 구매 수량 반환 기능 테스트")
    @Test
    public void getBuyingQuantityTest() {
        // given
        int buyingPrice = 10000;
        // when
        int result = generateLottoNumbers.getBuyingQuantity(buyingPrice);
        // then
        assertThat(result).isEqualTo(buyingPrice / Constants.LOTTO_PRICE);
    }

    @DisplayName("로또 리스트 정렬 테스트")
    @Test
    public void sortedListTest() {
        // given
        List<Integer> unsortedList = List.of(10, 1, 6, 25, 3, 15);
        List<Integer> sortedList = new ArrayList<>();
        List<Integer> answer = List.of(1, 3, 6, 10, 15, 25);

        // when
        sortedList = generateLottoNumbers.sortedList(unsortedList);
        // then
        assertThat(sortedList).isEqualTo(answer);
    }

    @DisplayName("로또 구매 테스트")
    @Test
    public void buyingLottosTest() {
        // given
        int quantity = 10;
        List<UserLotto> lottos = new ArrayList<>();
        // when
        lottos = generateLottoNumbers.buyingLottos(quantity);
        // then
        assertThat(lottos.size()).isEqualTo(quantity);
    }
}
