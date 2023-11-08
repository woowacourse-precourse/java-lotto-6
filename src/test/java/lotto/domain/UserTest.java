package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;

public class UserTest {
    @Test
    @DisplayName("로또 구매 테스트")
    public void testPurchaseLottos() {
        User user = new User(5000, new LottoGenerator123456());

        Assertions.assertEquals(5,user.getLottos().size());
        Assertions.assertEquals(5000, user.getPurchaseLottoPrice());
    }

    @Test
    @DisplayName("로또 당첨 결과 테스트")
    public void calculateRateOfReturnWhenWinning5First() {
        User user = new User(5000, new LottoGenerator123456());
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7);
        double expect = calculateRateOfReturn(LottoResult.FIRST.getPrice() * 5, user.getPurchaseLottoPrice());

        EnumMap<LottoResult, Integer> result = user.getLottoResultsAndSetRateOfReturn(winningLotto);

        Assertions.assertEquals(expect, user.getRateOfReturn());
        Assertions.assertEquals(5, result.get(LottoResult.FIRST));

    }


    public static class LottoGenerator123456 implements LottoNumberGenerator {
        @Override
        public Lotto generateLotto() {
            return new Lotto(List.of(1,2,3,4,5,6));
        }
    }

    private double calculateRateOfReturn(int benefit, int purchasePrice) {
        BigDecimal result = BigDecimal.valueOf(benefit).divide(BigDecimal.valueOf(purchasePrice)).multiply(BigDecimal.valueOf(100));
        return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
