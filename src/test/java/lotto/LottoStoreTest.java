package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.model.LottoStore;
import lotto.model.vo.Lotto;
import lotto.model.vo.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    
    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        this.lottoStore = LottoStore.of(new TestNumberGenerateStrategy());
    }

    @DisplayName("로또를 생성할 때 제출한 금액이 1000원 단위로 떨어지지 않으면 예외가 발생한다.")
    @Test
    void should_throwException_when_notDivisibleBy1000() {
        Money money = new Money("13400");

        Assertions.assertThatThrownBy(() -> lottoStore.sellLotto(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000 단위의 금액이 아닙니다.");
    }

    @DisplayName("로또를 생성할 때 정렬 되어있는 상태라면 True를 반환한다.")
    @Test
    void should_true_when_sorted() {
        Money money = new Money("1000");

        Lotto lotto = lottoStore.sellLotto(money).get(0);

        Assertions.assertThat(lotto.getNumbers())
                .isEqualTo(Arrays.asList(10, 12, 28, 30, 44, 45));
    }
}
