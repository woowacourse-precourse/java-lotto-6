package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

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
            String[] inputWinningNumbers = {"1","2","3","4","5","6"};
            lottoService.initWinningNumbers(inputWinningNumbers);

            List<Integer> winningNumbers = lottoService.getWinningNumbers();
            assertThat(winningNumbers.size()).isEqualTo(6);
        }

        @DisplayName("당첨번호를 입력받아 정수가 담긴 List로 변환하여 초기화했을 때 요소가 같은지 검증한다.")
        @Test
        void 당첨번호_숫자_테스트() {
            String[] inputWinningNumbers = {"7","2","23","33","42","4"};
            lottoService.initWinningNumbers(inputWinningNumbers);

            List<Integer> winningNumbers = lottoService.getWinningNumbers();
            assertThat(winningNumbers).containsExactly(7,2,23,33,42,4);
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
}