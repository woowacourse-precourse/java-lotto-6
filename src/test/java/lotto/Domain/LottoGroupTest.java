package lotto.Domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGroupTest {

    private final String moneyValue1 = "14000";
    private final String moneyValue2 = "1000";
    private final int moneyCount1 = 14;
    private final int moneyCount2 = 1;
    private final int invalidMoneyCount = 10000;

    @DisplayName("구매가능한 로또의 수와 실제로 구매한 로또의 수를 비교하는 로직 - 정상시나리오")
    @Test
    void findLottoCountTest1() {
        // given
        Money money1 = Money.from(moneyValue1);
        Money money2 = Money.from(moneyValue2);

        // when
        LottoGroup lottoGroup1 = LottoGroup.from(money1);
        LottoGroup lottoGroup2 = LottoGroup.from(money2);

        // then
        assertEquals(moneyCount1, lottoGroup1.findLottoNumbersSize());
        assertEquals(moneyCount2, lottoGroup2.findLottoNumbersSize());
    }


    @DisplayName("구매가능한 로또의 수와 실제로 구매한 로또의 수를 비교하는 로직 - 예외시나리오")
    @Test
    void findLottoCountTest2() {
        // given
        Money money1 = Money.from(moneyValue1);
        Money money2 = Money.from(moneyValue2);

        // when
        LottoGroup lottoGroup1 = LottoGroup.from(money1);
        LottoGroup lottoGroup2 = LottoGroup.from(money2);

        // then
        assertNotEquals(invalidMoneyCount, lottoGroup1.findLottoNumbersSize());
        assertNotEquals(invalidMoneyCount, lottoGroup2.findLottoNumbersSize());
    }


    @DisplayName("인덱스로 로또 조회")
    @Test
    void findLottoTest() {
        // given
        Money money = Money.from(moneyValue1);
        LottoGroup lottoGroup = LottoGroup.from(money);

        // when
        for (int i = 0; i < lottoGroup.findLottoNumbersSize(); i++) {
            lottoGroup.findLottoByIndex(i);
        }

        // then
        Assertions.assertThat(true).isTrue();
    }
}