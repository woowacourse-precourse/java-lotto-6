package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.DrawingResults;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.ProfitRate;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
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
        @DisplayName("발행된 로또 수는 구입 금액을 " + PurchaseAmount.PURCHASE_AMOUNT_UNIT + "으로 나눈 값과 같다")
        @Test
        void Issued_lotto_count_is_equal_to_purchase_amount() {
            // given
            PurchaseAmount purchaseAmount = new PurchaseAmount(5000);

            // when
            Lottos lottos = lottoMachine.issuedLottos(purchaseAmount);

            // then
            assertThat(lottos.getLottos().size()).isEqualTo(5000 / PurchaseAmount.PURCHASE_AMOUNT_UNIT);
        }
    }

    @Nested
    @DisplayName("draw 메소드 test")
    class Draw {
        @DisplayName("등수 개수에 따른 추첨 결과를 반환한다.")
        @Test
        void Rank_count_equals_drawing_result() {
            // given
            Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 1등 - 6개 일치
            Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 1등 - 6개 일치
            Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 10)); // 3등 - 5개 일치
            Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 10, 20)); // 4등 - 4개 일치

            Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
            WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(45);

            // when
            DrawingResults drawingResult = lottoMachine.draw(lottos, winningLotto,
                    bonusNumber);
            Integer firstCount = drawingResult.getResults().get(Rank.FIRST);
            Integer thirdCount = drawingResult.getResults().get(Rank.THIRD);
            Integer fourthCount = drawingResult.getResults().get(Rank.FOURTH);

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
            Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 1등
            Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 1등
            Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 10)); // 3등
            Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 10, 20)); // 4등

            Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
            WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(45);

            // when
            DrawingResults drawingResult = lottoMachine.draw(lottos, winningLotto, bonusNumber);
            ProfitRate result = lottoMachine.calculateProfitRate(lottos, drawingResult);

            // then
            System.out.println(result);
        }
    }
}