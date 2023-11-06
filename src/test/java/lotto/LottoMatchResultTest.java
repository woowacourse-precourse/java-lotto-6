package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoMatchResultTest {
    @Test
    void fromMatchedCount() {
        assertThat(LottoMatchResult.fromMatchedCount(0, false)).isEqualTo(LottoMatchResult.UNMATCHED);
        assertThat(LottoMatchResult.fromMatchedCount(3, false)).isEqualTo(LottoMatchResult.MATCHED_3);
        assertThat(LottoMatchResult.fromMatchedCount(4, false)).isEqualTo(LottoMatchResult.MATCHED_4);
        assertThat(LottoMatchResult.fromMatchedCount(5, false)).isEqualTo(LottoMatchResult.MATCHED_5);
        assertThat(LottoMatchResult.fromMatchedCount(5, true)).isEqualTo(LottoMatchResult.MATCHED_5_WITH_BONUS);
        assertThat(LottoMatchResult.fromMatchedCount(6, false)).isEqualTo(LottoMatchResult.MATCHED_6);

        assertThatThrownBy(()->LottoMatchResult.fromMatchedCount(-1, false)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->LottoMatchResult.fromMatchedCount(7, false)).isInstanceOf(IllegalArgumentException.class);
    }
}