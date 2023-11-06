package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {
    private Lottos lottos;
    private Lotto lotto1;
    private Lotto lotto2;
    private Lotto lotto3;

    @BeforeEach
    void beforeEach() {
        lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        lottos = Lottos.create(List.of(lotto1, lotto2, lotto3));
    }

    @DisplayName("Lottos 생성 테스트")
    @Test
    void create() {
        assertThat(lottos).isNotNull();
        assertThat(lottos.getLottos()).hasSize(3);
    }

    @DisplayName("providePrizeConditions() 테스트")
    @Test
    void providePrizeConditions() {
        //given
        WinningNumbers winningNumbers = WinningNumbers.create("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.create("8");
        WinningLotto winningLotto = WinningLotto.create(winningNumbers, bonusNumber);

        // when
        List<PrizeCondition> prizeConditions = lottos.providePrizeConditions(winningLotto);

        // then
        assertThat(prizeConditions).isNotNull();
    }

    @DisplayName("getLottos() 의 결과인 Lottos (불변객체) 를 수정하려 하면 예외가 발생한다.")
    @Test
    void getLottos() {
        // when, then
        assertThatThrownBy(() -> lottos.getLottos().add(new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}