package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PurchaseMoney;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumber;
import lotto.domain.enumerate.NumberType;
import lotto.domain.enumerate.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    WinningLotto winningLotto = initWinningNum();

    WinningLotto initWinningNum() {
        List<Integer> winningNum = List.of(1, 2, 3, 4, 5, 6);
        List<WinningNumber> winningNumbers = winningNum.stream()
                .map(winNum -> WinningNumber.of(winNum, NumberType.ORIGINAL)).toList();

        WinningNumber bonusNum = WinningNumber.of(7, NumberType.BONUS);

        return WinningLotto.of(winningNumbers, bonusNum);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 1-45 사이만 가능 하다. - 46이상")
    @Test
    void createLottoWithMaxNum() {
        assertThatThrownBy(() -> new Lotto(List.of(46, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 1-45 사이만 가능 하다. - 0이하")
    @Test
    void createLottoWithMinxNum() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매는 1,000원 단위로 가능 하다")
    @Test
    void createPurchaseMoney() {
        assertThatThrownBy(() -> PurchaseMoney.of(1111))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 비교 - 당첨 안됨")
    @Test
    void isSixRank() {
        Lotto lotto = new Lotto(List.of(45, 44, 43, 42, 41, 40));
        Rank rank = lotto.compare(winningLotto);

        assertThat(rank.name()).isEqualTo("NOTHING");
    }

    @DisplayName("당첨 번호와 비교 - 5등")
    @Test
    void isFifthRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 42, 41, 40));
        Rank rank = lotto.compare(winningLotto);

        assertThat(rank.name()).isEqualTo("FIFTH");
    }

    @DisplayName("당첨 번호와 비교 - 4등")
    @Test
    void isFourthRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 41, 40));
        Rank rank = lotto.compare(winningLotto);

        assertThat(rank.name()).isEqualTo("FOURTH");
    }

    @DisplayName("당첨 번호와 비교 - 3등")
    @Test
    void isThreeRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 40));
        Rank rank = lotto.compare(winningLotto);

        assertThat(rank.name()).isEqualTo("THIRD");
    }

    @DisplayName("당첨 번호와 비교 - 2등")
    @Test
    void isSecondRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Rank rank = lotto.compare(winningLotto);

        assertThat(rank.name()).isEqualTo("SECOND");
    }

    @DisplayName("당첨 번호와 비교 - 1등")
    @Test
    void isFirstRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank rank = lotto.compare(winningLotto);

        assertThat(rank.name()).isEqualTo("FIRST");
    }

    @DisplayName("수익률 100프로")
    @Test
    void is0Rate() {
        int FIVE_LOTTOS = 5;
        List<Lotto> createLottos = new ArrayList<>();
        for (int i = 0; i < FIVE_LOTTOS - 1; i++) {
            createLottos.add(new Lotto(List.of(40, 41, 42, 43, 44, 45)));
        }
        createLottos.add(new Lotto(List.of(1, 2, 3, 43, 44, 45)));

        Lottos lottos = new Lottos(createLottos);

        LottoResult result = lottos.determine(winningLotto);
        double rateResult = result.calculateRate(PurchaseMoney.of(FIVE_LOTTOS * 1000));

        assertThat(rateResult).isEqualTo(100);
    }

}