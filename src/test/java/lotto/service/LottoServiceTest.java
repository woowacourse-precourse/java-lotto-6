package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.utils.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class LottoServiceTest {

    @Mock
    private RandomNumberGenerator randomNumberGenerator;

    private LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.initMocks(this);
        lottoService = new LottoService(randomNumberGenerator);
    }

    @Nested
    @DisplayName("LottoService.purchase 테스트")
    class PurchaseTests {
        @DisplayName("구매수량과 만들어진 로또 리스트의 사이즈가 같은지 검증한다.")
        @Test
        void 로또_구매_수량_테스트() {
            when(randomNumberGenerator.uniqueNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 6));
            List<Lotto> purchaseLottos = lottoService.purchase(5);
            assertThat(purchaseLottos.size()).isEqualTo(5);
        }

        @DisplayName("로또를 구매할 때 로또 번호가 오름차순으로 정렬되어 저장되는지 검증한다.")
        @Test
        void 로또_번호_정렬_테스트() {
            when(randomNumberGenerator.uniqueNumbers()).thenReturn(List.of(13, 7, 22, 25, 3, 10));
            List<Lotto> purchaseLottos = lottoService.purchase(1);
            Lotto lotto = purchaseLottos.get(0);
            assertThat(lotto.toString()).isEqualTo("[3, 7, 10, 13, 22, 25]");
        }
    }

    @Nested
    @DisplayName("LottoService.initWinningNumbers 테스트")
    class InitWinningNumbersTest {
        @DisplayName("당첨번호를 초기화한 후에 저장된 크기가 6인지 검증한다.")
        @Test
        void 당첨번호_초기화_후_크기_테스트() {
            String[] inputWinningNumbers = {"1", "2", "3", "4", "5", "6"};
            lottoService.initWinningNumbers(inputWinningNumbers);

            List<Integer> winningNumbers = lottoService.getWinningNumbers();
            assertThat(winningNumbers.size()).isEqualTo(6);
        }

        @DisplayName("당첨번호를 입력받아 정수가 담긴 List로 변환하여 초기화했을 때 요소가 같은지 검증한다.")
        @Test
        void 당첨번호_숫자_테스트() {
            String[] inputWinningNumbers = {"7", "2", "23", "33", "42", "4"};
            lottoService.initWinningNumbers(inputWinningNumbers);

            List<Integer> winningNumbers = lottoService.getWinningNumbers();
            assertThat(winningNumbers).containsExactly(7, 2, 23, 33, 42, 4);
        }
    }

    @Nested
    @DisplayName("LottoService.initBonusNumber 테스트")
    class initBonusNumberTest {
        @DisplayName("보너스 번호를 초기화하고 검증한다.")
        @Test
        void 보너스번호_초기화_테스트() {
            lottoService.initBonusNumber(7);
            int bonusNumber = lottoService.getBonusNumber();
            assertThat(bonusNumber).isEqualTo(7);
        }
    }

    @Nested
    @DisplayName("LottoService.checkLottoResult 테스트")
    class checkLottoResultTest {
        @DisplayName("보너스 번호 유무와 맞힌 번호 개수로 당첨내역에 저장되었는지 검증한다.")
        @ParameterizedTest
        @CsvSource(value = {
                "1,2,3,4,5,6:7:FIRST",
                "1,2,3,4,5,8:6:SECOND",
                "1,2,3,4,5,8:9:THIRD",
                "1,2,3,4,7,8:9:FOURTH",
                "1,2,3,7,8,9:10:FIFTH"
        }, delimiter = ':')
        void 로또_순위_확인_테스트(String inputWinningNumbers, int inputBonusNumber, String expectedRank) {
            // @CsvSource로 받은 값으로 당첨번호 초기화
            String[] winningNumbers = inputWinningNumbers.split(",");
            lottoService.initWinningNumbers(winningNumbers);

            // @CsvSource로 받은 값으로 보너스번호 초기화
            lottoService.initBonusNumber(inputBonusNumber);

            // 1,2,3,4,5,6 으로 구성된 로또 1장 구매
            when(randomNumberGenerator.uniqueNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 6));
            lottoService.purchase(1);

            // 각 테스트 케이스 별로 등수가 맞는지 검증
            HashMap<LottoRank, Integer> winningRankCount = lottoService.checkLottoResult();
            Set<LottoRank> lottoRanks = winningRankCount.keySet();
            lottoRanks.forEach(rank -> assertThat(rank.name()).isEqualTo(expectedRank));
        }

        @DisplayName("당첨이 여러 번 됐을 때 당첨내역의 횟수가 증가하는지 검증한다.")
        @ParameterizedTest
        @CsvSource(value = {
                "1,2,3,4,5,6:45",
        }, delimiter = ':')
        void 여러번_당첨될경우_당첨횟수_검증(String inputWinningNumbers, int inputBonusNumber) {
            String[] winningNumbers = inputWinningNumbers.split(",");
            lottoService.initWinningNumbers(winningNumbers);

            lottoService.initBonusNumber(inputBonusNumber);

            // 1등 당첨 번호로 로또를 5장 구매
            when(randomNumberGenerator.uniqueNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 6));
            lottoService.purchase(5);

            // 1등 당첨 횟수 검증
            HashMap<LottoRank, Integer> winningRankCount = lottoService.checkLottoResult();
            assertThat(winningRankCount.get(LottoRank.FIRST)).isEqualTo(5);
        }
    }

    @Nested
    @DisplayName("LottoService.calculateProfitRate 테스트")
    class calculateProfitRateTests {
        @DisplayName("당첨 내역을 확인하여 총 수익금을 검증한다.")
        @ParameterizedTest
        @CsvSource(value = {
                "1,2,3,4,5,6 : 45",
        }, delimiter = ':')
        void 총_수익금_검증(String inputWinningNumbers, int inputBonusNumber) {
            when(randomNumberGenerator.uniqueNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 45));

            String[] winningNumbers = inputWinningNumbers.split(",");
            lottoService.initWinningNumbers(winningNumbers);
            lottoService.initBonusNumber(inputBonusNumber);

            // 2등 당첨 번호로 3장 구매 후 결과 확인
            lottoService.purchase(3);
            lottoService.checkLottoResult();
            lottoService.calculateProfitRate();

            assertThat(lottoService.getTotalPrizeAmount()).isEqualTo(90_000_000L);
        }

        @DisplayName("총 수익률을 계산하여 검증한다.")
        @ParameterizedTest
        @CsvSource(value = {
                "1,2,3,4,5,6: 7 : 200_000_000",
                "1,2,3,4,5,7: 6 : 3_000_000",
                "1,2,3,4,5,7: 8 : 150_000",
                "1,2,3,4,7,8: 9 : 5_000",
                "1,2,3,7,8,9: 10 : 500",
        }, delimiter = ':')
        void 총_수익률_검증(String inputWinningNumbers,int bonusNumber, double expectedProfitRate) {
            // 로또 생성
            when(randomNumberGenerator.uniqueNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 6));
            String[] winningNumbers = inputWinningNumbers.split(",");
            lottoService.initWinningNumbers(winningNumbers);
            lottoService.initBonusNumber(bonusNumber);

            // 각 당첨 번호로 2장을 구매했을 때 총 수익률을 계산
            lottoService.purchase(2);
            lottoService.checkLottoResult();
            double profitRate = lottoService.calculateProfitRate();

            // 총 수익률 검증
            assertThat(profitRate).isEqualTo(expectedProfitRate);
        }

        @DisplayName("수익률이 소수점 둘째 자리에서 반올림되는지 검증한다.")
        @ParameterizedTest
        @CsvSource(value = {
                "23.55 : 23.6",
                "23.54 : 23.5",
                "42.547 : 42.5",
                "42.577 : 42.6",
        }, delimiter = ':')
        void 수익률_둘째자리_반올림_검증 (double inputProfitRate, double expectedProfitRate) {
            double roundedProfitRate = lottoService.calculateRoundedProfitRate(inputProfitRate);
            assertThat(roundedProfitRate).isEqualTo(expectedProfitRate);
        }
    }
}