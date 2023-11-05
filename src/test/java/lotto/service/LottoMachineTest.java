package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Rank;
import lotto.domain.dto.BonusNumberDto;
import lotto.domain.dto.DrawingResultDto;
import lotto.domain.dto.LottoDto;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.PurchaseAmountDto;
import lotto.domain.dto.WinningLottoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    LottoMachine lottoMachine;

    @BeforeEach
    void beforeEach() {
        lottoMachine = new LottoMachine();

    }

    @Nested
    @DisplayName("issuedLottos 메소드 test")
    class IssuedLottos {
        @DisplayName("발행된 로또 수는 구입 금액을 " + PurchaseAmountDto.PURCHASE_AMOUNT_UNIT + "으로 나눈 값과 같다")
        @Test
        void Issued_lotto_count_is_equal_to_purchase_amount() {
            // given
            PurchaseAmountDto purchaseAmountDto = new PurchaseAmountDto(5000);

            // when
            LottosDto lottosDto = lottoMachine.issuedLottos(purchaseAmountDto);

            // then
            assertThat(lottosDto.lottos().size()).isEqualTo(
                    purchaseAmountDto.amount() / PurchaseAmountDto.PURCHASE_AMOUNT_UNIT);
        }
    }

    @Nested
    @DisplayName("draw 메소드 test")
    class Draw {
        @DisplayName("등수 개수에 따른 추첨 결과를 반환한다.")
        @Test
        void Rank_count_equals_drawing_result() {
            // given
            LottoDto lottoDto1 = new LottoDto(List.of(1, 2, 3, 4, 5, 6)); // 1등 - 6개 일치
            LottoDto lottoDto2 = new LottoDto(List.of(1, 2, 3, 4, 5, 6)); // 1등 - 6개 일치
            LottoDto lottoDto3 = new LottoDto(List.of(1, 2, 3, 4, 5, 10)); // 3등 - 5개 일치
            LottoDto lottoDto4 = new LottoDto(List.of(1, 2, 3, 4, 10, 20)); // 4등 - 4개 일치

            LottosDto lottosDto = new LottosDto(List.of(lottoDto1, lottoDto2, lottoDto3, lottoDto4));
            WinningLottoDto winningLottoDto = new WinningLottoDto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumberDto bonusNumberDto = new BonusNumberDto(45);

            // when
            DrawingResultDto drawingResultDto = lottoMachine.draw(lottosDto, winningLottoDto, bonusNumberDto);
            Integer firstCount = drawingResultDto.drawingResults().get(Rank.FIRST);
            Integer thirdCount = drawingResultDto.drawingResults().get(Rank.THIRD);
            Integer fourthCount = drawingResultDto.drawingResults().get(Rank.FOURTH);

            // then
            assertThat(firstCount).isEqualTo(2);
            assertThat(thirdCount).isEqualTo(1);
            assertThat(fourthCount).isEqualTo(1);

        }
    }

    @Nested
    @DisplayName("-")
    class CalculateProfitRate {
        @DisplayName("추첨 결과에 따른 수익률을 반환한다.")
        @Test
        void Calculate_profit() {
            LottoDto lottoDto1 = new LottoDto(List.of(1, 2, 3, 4, 5, 6)); // 1등
            LottoDto lottoDto2 = new LottoDto(List.of(1, 2, 3, 4, 5, 6)); // 1등
            LottoDto lottoDto3 = new LottoDto(List.of(1, 2, 3, 4, 5, 10)); // 3등
            LottoDto lottoDto4 = new LottoDto(List.of(1, 2, 3, 4, 10, 20)); // 4등

            LottosDto lottosDto = new LottosDto(List.of(lottoDto1, lottoDto2, lottoDto3, lottoDto4));
            WinningLottoDto winningLottoDto = new WinningLottoDto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumberDto bonusNumberDto = new BonusNumberDto(45);

            // when
            DrawingResultDto drawingResultDto = lottoMachine.draw(lottosDto, winningLottoDto, bonusNumberDto);
            double result = lottoMachine.calculateProfitRate(lottosDto, drawingResultDto);

            // then
            System.out.println(result);
        }
    }
}