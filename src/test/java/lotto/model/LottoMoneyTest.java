package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMoneyTest {

    @ParameterizedTest
    @CsvSource(value = {
            "500:java.lang.IllegalArgumentException",
            "444:java.lang.IllegalArgumentException",
            "900:java.lang.IllegalArgumentException",
            "999:java.lang.IllegalArgumentException"} , delimiter = ':')
    void inputMinimumMoneyTest(int input, Class<Exception> expected) {
        Assertions.assertThatThrownBy( () -> new LottoMoney(input)).isInstanceOf(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1500:java.lang.IllegalArgumentException",
            "4444:java.lang.IllegalArgumentException",
            "1001:java.lang.IllegalArgumentException",
            "100001:java.lang.IllegalArgumentException"} , delimiter = ':')
    void inputUnitMoneyTest(int input, Class<Exception> expected) {
        Assertions.assertThatThrownBy( () -> new LottoMoney(input)).isInstanceOf(expected);
    }
}