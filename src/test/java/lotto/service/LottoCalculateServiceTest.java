package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.LottoDrawingMachine;
import lotto.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoCalculateServiceTest {

    private LottoCalculateService lottoCalculateService = new LottoCalculateService();

    @DisplayName("getYieldOfLotto() : 수익률 계산 테스트")
    @Test
    void getYieldOfLotto_success() {
        // given
        Player user = new Player("8000");
        int totalPrice = 2_000_000_000;

        // when
        String result = lottoCalculateService.getYieldOfLotto(user, totalPrice);

        // then
        assertThat(result).isEqualTo("25,000,000.0");
    }

    @DisplayName("countPlayerNumbersContainLotto() : 티켓과 당첨번호 비교")
    @Test
    void countPlayerNumbersContainLotto_success() {
        // given
        List<Integer> playerNumbers = List.of(1, 2, 3, 7, 8, 9);
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        int count = lottoCalculateService.countPlayerNumbersContainLotto(playerNumbers, lottoNumbers);

        // then
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("isNumberMatchedNormal() : 보너스 볼 검증이 필요없는 매칭 테스트")
    @ParameterizedTest
    @CsvSource({"3,true", "4,true", "6,true", "2,false"})
    void isNumberMatchedNormal_test(int countContainsOfLotto, boolean result) {
        //given // when
        boolean expectedResult = lottoCalculateService.isNumberMatchedNormal(countContainsOfLotto);

        // then
        assertThat(expectedResult).isEqualTo(result);
    }

    @DisplayName("isNumberMatchedFiveWithBonus() : 보너스 볼 검증이 필요한 2등 테스트")
    @ParameterizedTest
    @CsvSource({"6,true", "10,false"})
    void isNumberMatchedFiveWithBonus_test(String bonusBall, boolean result) {
        // given
        int countContainsOfLotto = 5;
        List<Integer> playerNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningBalls = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        LottoBall lottoBall = new LottoBall(bonusBall);
        LottoDrawingMachine lottoDrawingMachine = new LottoDrawingMachine(winningBalls, lottoBall);

        // when
        boolean expectedResult = lottoCalculateService.isNumberMatchedFiveWithBonus(countContainsOfLotto, playerNumbers,
                lottoDrawingMachine);

        // then
        assertThat(expectedResult).isEqualTo(result);
    }

    @DisplayName("isNumberMatchedFive() : 5개 번호 매칭 테스트")
    @Test
    void isNumberMatchedFive_test() {
        // given
        int countContainsOfLotto = 5;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningBalls = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        LottoBall lottoBall = new LottoBall("10");
        LottoDrawingMachine lottoDrawingMachine = new LottoDrawingMachine(winningBalls, lottoBall);

        // when
        boolean result = lottoCalculateService.isNumberMatchedFive(countContainsOfLotto, numbers, lottoDrawingMachine);

        // then
        assertThat(result).isEqualTo(true);
    }
}