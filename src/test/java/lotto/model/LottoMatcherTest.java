package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatcherTest {

    private LottoMatcher lottoMatcher;


    @BeforeEach
    void setUp() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonusNumber = new Bonus(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        this.lottoMatcher = new LottoMatcher(winningLotto);
    }

    @DisplayName("구매한 로또 매칭 결과가 null이 아닌지 확인")
    @Test
    void matchLottosReturnsLottoResultSuccessfully() {
        List<Lotto> userLottos = List.of(
            new Lotto(List.of(1, 2, 3, 10, 20, 30)),
            new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );

        assertThatCode(() -> lottoMatcher.matchLottos(userLottos))
            .doesNotThrowAnyException();
    }


}