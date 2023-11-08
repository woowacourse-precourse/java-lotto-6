package lotto.state;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PurchasedLottoStateTest {

    @Test
    void 로또_번호를_출력할_때_정렬된_상태로_출력합니다() {
        final var purchasedLottoState = new PurchasedLottoState(1, List.of(
                List.of(2, 1, 4, 5, 3, 6),
                List.of(6, 5, 4, 3, 2, 1)
        ));

        assertThat(purchasedLottoState.toResult())
                .isEqualTo("""
                        [1, 2, 3, 4, 5, 6]
                        [1, 2, 3, 4, 5, 6]
                        """.trim());
    }

}
