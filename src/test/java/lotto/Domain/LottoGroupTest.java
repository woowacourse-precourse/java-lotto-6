package lotto.Domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGroupTest {

    @DisplayName("구매가능한 로또의 수와 실제로 구매한 로또의 수를 비교하는 로직 - 정상시나리오")
    @Test
    void findLottoCountTest1() {
        // given
        Money money1 = Money.from("14000");
        Money money2 = Money.from("1000");

        // when
        LottoGroup lottoGroup1 = LottoGroup.from(money1);
        LottoGroup lottoGroup2 = LottoGroup.from(money2);

        // then
        assertEquals(14, lottoGroup1.findLottoNumbersSize());
        assertEquals(1, lottoGroup2.findLottoNumbersSize());
    }


    @DisplayName("구매가능한 로또의 수와 실제로 구매한 로또의 수를 비교하는 로직 - 예외시나리오")
    @Test
    void findLottoCountTest2() {
        // given
        Money money1 = Money.from("14000");
        Money money2 = Money.from("1000");

        // when
        LottoGroup lottoGroup1 = LottoGroup.from(money1);
        LottoGroup lottoGroup2 = LottoGroup.from(money2);

        // then
        assertNotEquals(15, lottoGroup1.findLottoNumbersSize());
        assertNotEquals(2, lottoGroup2.findLottoNumbersSize());
    }


    @DisplayName("인덱스로 로또 조회")
    @Test
    void findLottoTest() {
        // given
        Money money = Money.from("5000");
        LottoGroup lottoGroup = LottoGroup.from(money);

        // when
        for (int i = 0; i < lottoGroup.findLottoNumbersSize(); i++) {
            lottoGroup.findLottoByIndex(i);
        }

        // then
        Assertions.assertThat(true).isTrue();
    }
}