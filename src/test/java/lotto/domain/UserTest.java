package lotto.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

//    private static MockedStatic<LottoStore> lottoStoreMocked;

    @AfterAll
    public static void afterAll() {
    }

    @Test
    void 로또_구매자_수익률_계산_테스트() {
        List<Integer> lotto1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto2 = List.of(7, 8, 9, 10, 11, 12);
        List<Integer> lotto3 = List.of(41, 22, 11, 36, 25, 7);

        List<Lotto> lottos = List.of(new Lotto(lotto1), new Lotto(lotto2), new Lotto(lotto3));

        User user = new User(3000, lottos);
        List<Integer> winningNumbers = List.of(1, 2, 3, 41, 32, 26);
        int bonusNumber = 31;

        assertThat(user.calculateRateOfReturn(winningNumbers, bonusNumber))
                .isEqualTo("166.7");
    }

    @Test
    void 구입한_로또에_대한_결과_테스트() {
        List<Integer> lotto1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto2 = List.of(7, 8, 9, 10, 11, 12);
        List<Integer> lotto3 = List.of(41, 22, 11, 36, 25, 7);

        List<Lotto> lottos = List.of(new Lotto(lotto1), new Lotto(lotto2), new Lotto(lotto3));

        User user = new User(3000, lottos);

        List<Integer> winningNumbers = List.of(1, 2, 3, 41, 32, 26);
        int bonusNumber = 31;
        int[] result = {2, 0, 0, 0, 0, 1};

        assertThat(user.getLottoResults(winningNumbers, bonusNumber))
                .isEqualTo(result);
    }


}