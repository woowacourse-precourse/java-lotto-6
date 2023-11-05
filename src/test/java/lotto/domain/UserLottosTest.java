package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLottosTest {
    UserLottos userLottos;

    @BeforeEach
    void setUp() {
        // 유저의 5개의 로또 번호를 준비
        List<Integer> first = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> second = List.of(1, 3, 4, 5, 6, 7);
        List<Integer> third = List.of(1, 3, 4, 5, 6, 45);
        List<Integer> fourth = List.of(2, 4, 5, 6, 24, 41);
        List<Integer> fifth = List.of(3, 4, 5, 33, 39, 43);

        userLottos = new UserLottos(List.of(
                new Lotto(first),
                new Lotto(second),
                new Lotto(third),
                new Lotto(fourth),
                new Lotto(fifth)
        ));
    }

    @DisplayName("유저의 5개의 로또 번호와 당첨 번호를 비교하고, 정확한 결과를 반환하는지 확인합니다.")
    @Test
    void compareAllLotto() {
        // 위의 setUp에서 설정한 유저의 로또와 비교했을 때, 모든 당첨 결과를 1개씩 가지도록 당첨 번호를 설정
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        // 예상 결과 : 모든 당첨 케이스가 1번씩 있어야 함
        Map<LottoPrizes, Integer> expectedPrizes = Map.of(
                LottoPrizes.THREE_NUMBERS_MATCHED, 1,
                LottoPrizes.FOUR_NUMBERS_MATCHED, 1,
                LottoPrizes.FIVE_NUMBER_MATCHED, 1,
                LottoPrizes.FIVE_NUMBER_AND_BONUS_MATCHED, 1,
                LottoPrizes.SIX_NUMBER_MATCHED, 1
        );

        LottoResult expectedResult = new LottoResult(expectedPrizes);

        LottoResult actual = userLottos.compareAllLotto(winningLotto);
        assertThat(actual).isEqualTo(expectedResult);
    }

    @DisplayName("유저의 로또 번호를, 주어진 형식대로 정확하게 출력하는지 확인합니다.")
    @Test
    void displayAllLotto() {
        String expected = """
                [1, 2, 3, 4, 5, 6]
                [1, 3, 4, 5, 6, 7]
                [1, 3, 4, 5, 6, 45]
                [2, 4, 5, 6, 24, 41]
                [3, 4, 5, 33, 39, 43]""";

        assertThat(userLottos.displayAllLotto()).isEqualTo(expected);
    }
}