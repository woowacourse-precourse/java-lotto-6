package lotto.model;

import lotto.dto.request.BonusNumberDto;
import lotto.dto.request.PurchaseAmountDto;
import lotto.dto.request.WinningNumbersDto;
import lotto.dto.response.LottoResultsDto;
import lotto.dto.response.LottoTicketsDto;
import lotto.util.NumberGenerator;
import org.junit.jupiter.api.*;
import org.assertj.core.api.Assertions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LottoServiceTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Nested
    @DisplayName("로또 구매 테스트")
    class PurchaseLottosTest {

        @Test
        @DisplayName("정상적인 구매 금액으로 로또를 구매할 경우")
        void purchaseLottosWithValidAmount() {
            // 준비
            NumberGenerator numberGenerator = new SimpleNumberGenerator();
            PurchaseAmountDto purchaseAmountDto = PurchaseAmountDto.from("5000");
            LottoService lottoService = LottoService.getInstance();

            // 실행
            LottoTicketsDto result = lottoService.purchaseLottos(numberGenerator, purchaseAmountDto);

            // 검증
            Assertions.assertThat(result).isNotNull();
            Assertions.assertThat(result.getLottoTicketCount()).isEqualTo(5);
        }

        @Test
        @DisplayName("구매 금액이 로또 가격으로 나누어떨어지지 않는 경우 예외 발생")
        void purchaseLottosWithInvalidAmount() {
            // 준비
            NumberGenerator numberGenerator = new SimpleNumberGenerator();
            PurchaseAmountDto purchaseAmountDto = PurchaseAmountDto.from("5500");
            LottoService lottoService = LottoService.getInstance();

            // 실행 & 검증
            Assertions.assertThatThrownBy(() -> lottoService.purchaseLottos(numberGenerator, purchaseAmountDto))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("로또 결과 계산 테스트")
    class CalculateResultsTest {

        @Test
        @DisplayName("로또 결과를 정상적으로 계산하는 경우")
        void calculateResultsWithValidInputs() {
            // 준비
            LottoService lottoService = LottoService.getInstance();
            LottoTicketsDto lottoTicketsDto = createSampleLottoTicketsDto(5, "1000");
            WinningNumbersDto winningNumbersDto = WinningNumbersDto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
            BonusNumberDto bonusNumberDto = BonusNumberDto.from(45);

            // 실행
            LottoResultsDto resultsDto
                    = lottoService.calculateResults(lottoTicketsDto, winningNumbersDto, bonusNumberDto);

            // 검증
            Assertions.assertThat(resultsDto).isNotNull();
            Assertions.assertThat(resultsDto.getProfitRate()).isGreaterThan(0);
        }

        private LottoTicketsDto createSampleLottoTicketsDto(int count, String cost) {
            List<Lotto> tickets = IntStream.range(0, count)
                    .mapToObj(i -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6 + i)))
                    .collect(Collectors.toList());
            return LottoTicketsDto.of(Lottos.from(tickets), Money.from(cost));
        }
    }

    private static class SimpleNumberGenerator implements NumberGenerator {
        // 사용자 지정 번호 생성
        public List<Integer> generate(int startInclusive, int endInclusive, int count) {
            return Arrays.asList(1, 2, 3, 4, 5, 6);
        }
    }
}