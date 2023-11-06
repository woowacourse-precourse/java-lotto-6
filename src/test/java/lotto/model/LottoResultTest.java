package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @DisplayName("결과 출력")
    @Test
    void statistics() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWithBonus answer = new LottoWithBonus(lotto, 45);
        List<Lotto> allLotto = new ArrayList<>();
        allLotto.add(new Lotto(List.of(11, 12, 13, 14, 15, 16)));
        allLotto.add(new Lotto(List.of(1, 22, 3, 14, 15, 16)));
        allLotto.add(new Lotto(List.of(11, 2, 3, 34, 15, 16)));
        allLotto.add(new Lotto(List.of(1, 22, 3, 4, 45, 16)));
        allLotto.add(new Lotto(List.of(21, 22, 23, 24, 25, 16)));
        allLotto.add(new Lotto(List.of(21, 22, 23, 24, 25, 26)));
        allLotto.add(new Lotto(List.of(31, 32, 33, 34, 35, 36)));
        allLotto.add(new Lotto(List.of(1, 32, 33, 34, 35, 36)));
        Money money = new Money(8000);

        // when
        LottoResult result = new LottoResult(answer, allLotto, money);

        // then
        assertThat(result.toString()).isEqualTo("""
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 62.5%입니다.
                """);
    }
}