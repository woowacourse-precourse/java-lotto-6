package lotto.controller;

import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.money.Wallet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    @DisplayName("사용자의 입력을 금액으로 정상적으로 변경해주어야 한다.")
    void 구매금액_정상_변경() {
        Wallet wallet = Converter.stringToWallet("5000");

        assertEquals(5, wallet.calculateCurrencyUnits());
    }

    @Test
    @DisplayName("사용자의 입력을 금액이 1000으로 나누어지지 않으면 오류가 발생 해야 한다.")
    void 구매금액_단위_익셉션_발생() {
        assertThrows(IllegalArgumentException.class, () -> Converter.stringToWallet("6666"));
    }

    @Test
    @DisplayName("사용자의 입력을 금액이 숫자가 아니면 오류가 발생 해야 한다.")
    void 구매금액_숫자가_아니면_익셉션_발생() {
        assertThrows(IllegalArgumentException.class, () -> Converter.stringToWallet("abc"));
    }

    @Test
    @DisplayName("사용자의 입력을 금액이 0보다 작으면 오류가 발생 해야 한다.")
    void 구매금액_0보다_작으면_익셉션_발생() {
        assertThrows(IllegalArgumentException.class, () -> Converter.stringToWallet("0"));
    }

    @Test
    @DisplayName("사용자의 입력을 로또 번호로 변경해주어야 한다.")
    void 로또번호_정상_변경() {
        Lotto lotto = Converter.stringToLotto("1,2,3,4,5,6");

        assertEquals("[1, 2, 3, 4, 5, 6]", lotto.printNumber());
    }

    @Test
    @DisplayName("사용자의 입력을 로또 번호는 중복되면 안된다.")
    void 로또번호는_중복되면_안된다() {
        assertThrows(IllegalArgumentException.class, () -> Converter.stringToLotto("1,1,3,4,5,6"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    @DisplayName("사용자의 입력을 로또 번호는 6자리가 아니면 안된다.")
    void 로또번호는_6자리_초과_6자리_미만_익셉션_발생(String numbers) {
        assertThrows(IllegalArgumentException.class, () -> Converter.stringToLotto(numbers));
    }

    @Test
    @DisplayName("사용자의 입력을 로또 번호는 숫자가 아니면 안된다.")
    void 로또번호는_숫자가_아니면_익셉션_발생() {
        assertThrows(IllegalArgumentException.class, () -> Converter.stringToLotto("abc"));
    }

    @Test
    @DisplayName("보너스 번호는 정상적으로 변경되어야 한다.")
    void 보너스_번호_정상_변경() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Bonus bonus = Converter.stringToBonus("7", lotto);

        assertEquals(7, bonus.number());
    }

    @Test
    @DisplayName("보너스 번호는 중복되면 오류가 발생한다.")
    void 보너스_번호_중복되면_익셉션_발생() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThrows(IllegalArgumentException.class, () -> Converter.stringToBonus("6", lotto));
    }

    @Test
    @DisplayName("보너스 번호는 숫자가 아니면 안된다.")
    void 보너스_숫자가_아니면_익셉션_발생() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThrows(IllegalArgumentException.class, () -> Converter.stringToBonus("abc", lotto));
    }
}