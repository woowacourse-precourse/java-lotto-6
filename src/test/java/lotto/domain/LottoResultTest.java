package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class LottoResultTest {

    private final int FIRST_PRICE = 2_000_000_000;
    private final int SECOND_PRICE = 30_000_000;
    private final int THIRD_PRICE = 1_500_000;
    private final int FOURTH_PRICE = 50_000;
    private final int FIFTH_PRICE = 5_000;

    @Test
    @DisplayName("낙첨 테스트")
    public void testEmpty() {
        WinningLotto winningLotto = makeWinningLotto();
        Lotto userLotto1 = new Lotto(List.of(3,4,7,8,9,10));
        Lotto userLotto2 = new Lotto(List.of(11,12,13,14,15,16));

        Assertions.assertEquals(Optional.empty(), LottoResult.getLottoResult(winningLotto, userLotto1));
        Assertions.assertEquals(Optional.empty(), LottoResult.getLottoResult(winningLotto, userLotto2));
    }

    @Test
    @DisplayName("5등 테스트")
    public void testFifth() {
        WinningLotto winningLotto = makeWinningLotto();
        Lotto userLotto1 = new Lotto(List.of(3,4,5,7,9,10));
        Lotto userLotto2 = new Lotto(List.of(4,5,6,14,15,16));

        Assertions.assertEquals(LottoResult.FIFTH, LottoResult.getLottoResult(winningLotto, userLotto1).get());
        Assertions.assertEquals(LottoResult.FIFTH, LottoResult.getLottoResult(winningLotto, userLotto2).get());
        Assertions.assertEquals(LottoResult.FIFTH.getPrice(), FIFTH_PRICE);
    }

    @Test
    @DisplayName("4등 테스트")
    public void testFourth() {
        WinningLotto winningLotto = makeWinningLotto();
        Lotto userLotto1 = new Lotto(List.of(3,4,5,6,7,10));
        Lotto userLotto2 = new Lotto(List.of(4,5,6,3,15,16));

        Assertions.assertEquals(LottoResult.FOURTH, LottoResult.getLottoResult(winningLotto, userLotto1).get());
        Assertions.assertEquals(LottoResult.FOURTH, LottoResult.getLottoResult(winningLotto, userLotto2).get());
        Assertions.assertEquals(LottoResult.FOURTH.getPrice(), FOURTH_PRICE);
    }

    @Test
    @DisplayName("3등 테스트")
    public void testThird() {
        WinningLotto winningLotto = makeWinningLotto();
        Lotto userLotto1 = new Lotto(List.of(3,4,5,6,2,10));
        Lotto userLotto2 = new Lotto(List.of(4,5,6,3,1,16));

        Assertions.assertEquals(LottoResult.THIRD, LottoResult.getLottoResult(winningLotto, userLotto1).get());
        Assertions.assertEquals(LottoResult.THIRD, LottoResult.getLottoResult(winningLotto, userLotto2).get());
        Assertions.assertEquals(LottoResult.THIRD.getPrice(), THIRD_PRICE);
    }

    @Test
    @DisplayName("2등 테스트")
    public void testSecond() {
        WinningLotto winningLotto = makeWinningLotto();
        Lotto userLotto1 = new Lotto(List.of(3,4,5,6,2,7));
        Lotto userLotto2 = new Lotto(List.of(4,5,6,3,1,7));

        Assertions.assertEquals(LottoResult.SECOND, LottoResult.getLottoResult(winningLotto, userLotto1).get());
        Assertions.assertEquals(LottoResult.SECOND, LottoResult.getLottoResult(winningLotto, userLotto2).get());
        Assertions.assertEquals(LottoResult.SECOND.getPrice(), SECOND_PRICE);
    }

    @Test
    @DisplayName("1등 테스트")
    public void testFirst() {
        WinningLotto winningLotto = makeWinningLotto();
        Lotto userLotto1 = new Lotto(List.of(3,4,5,6,2,1));
        Lotto userLotto2 = new Lotto(List.of(4,5,6,3,1,2));

        Assertions.assertEquals(LottoResult.FIRST, LottoResult.getLottoResult(winningLotto, userLotto1).get());
        Assertions.assertEquals(LottoResult.FIRST, LottoResult.getLottoResult(winningLotto, userLotto2).get());
        Assertions.assertEquals(LottoResult.FIRST.getPrice(), FIRST_PRICE);
    }

    private WinningLotto makeWinningLotto() {
        return new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)),7);
    }

}
