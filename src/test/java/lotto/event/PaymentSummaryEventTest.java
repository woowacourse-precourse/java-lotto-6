package lotto.event;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.domain.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.PurchasedLottoBundle;
import lotto.repository.LottoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("[이벤트] 정산 결과 테스트")
class PaymentSummaryEventTest {

    @Test
    void _1등을_하면_1등에_맞는_수익률이_발생한다() {
        final var repository = new LottoRepository();
        final var paymentSummaryEvent = new PaymentSummaryEvent(repository);

        repository.save(new Money(1000));
        repository.save(AnswerLotto.of(List.of(1, 2, 3, 4, 5, 6))
                .registerBonusNumber(7));
        repository.save(new PurchasedLottoBundle(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))
        ));

        final var state = paymentSummaryEvent.execute();

        assertAll(
                () -> assertThat(state.getProfitResult()).isEqualTo("200,000,000.0%"),
                () -> assertThat(state.toResult()).isEqualTo("""
                        3개 일치 (5,000원) - 0개
                        4개 일치 (50,000원) - 0개
                        5개 일치 (1,500,000원) - 0개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                        6개 일치 (2,000,000,000원) - 1개
                        """.trim())
        );
    }

    @Test
    @DisplayName("8000원을 지불하고 5000원 당첨되면 62.5%의 수익률이 발생한다")
    void testCase() {
        final var repository = new LottoRepository();
        final var paymentSummaryEvent = new PaymentSummaryEvent(repository);

        repository.save(new Money(8000));
        repository.save(AnswerLotto.of(List.of(1, 2, 3, 4, 5, 6))
                .registerBonusNumber(7));
        repository.save(new PurchasedLottoBundle(
                List.of(new Lotto(List.of(1, 2, 3, 7, 8, 9)))
        ));

        final var state = paymentSummaryEvent.execute();

        assertAll(
                () -> assertThat(state.getProfitResult()).isEqualTo("62.5%"),
                () -> assertThat(state.toResult()).isEqualTo("""
                        3개 일치 (5,000원) - 1개
                        4개 일치 (50,000원) - 0개
                        5개 일치 (1,500,000원) - 0개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                        6개 일치 (2,000,000,000원) - 0개
                        """.trim())
        );
    }

}
