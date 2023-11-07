package lotto.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static lotto.enums.LottoNumbers.*;

class LottoNumbersTest {
    private static final int MIN_LOTTO_NUMBER = 1, MAX_LOTTO_NUMBER = 45;
    private static final List<Integer> LOTTO_NUMBERS_INTEGERS = List.of(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45);

    private static final LottoNumbers[] LOTTO_NUMBERS = {
            ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
            ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN, EIGHTEEN, NINETEEN, TWENTY,
            TWENTY_ONE, TWENTY_TWO, TWENTY_THREE, TWENTY_FOUR, TWENTY_FIVE, TWENTY_SIX, TWENTY_SEVEN, TWENTY_EIGHT, TWENTY_NINE, THIRTY,
            THIRTY_ONE, THIRTY_TWO, THIRTY_THREE, THIRTY_FOUR, THIRTY_FIVE, THIRTY_SIX, THIRTY_SEVEN, THIRTY_EIGHT, THIRTY_NINE, FORTY,
            FORTY_ONE, FORTY_TWO, FORTY_THREE, FORTY_FOUR, FORTY_FIVE};
    private static final List<String> LOTTO_NUMBERS_STRINGS = List.of(
            "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN",
            "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN", "TWENTY",
            "TWENTY_ONE", "TWENTY_TWO", "TWENTY_THREE", "TWENTY_FOUR", "TWENTY_FIVE", "TWENTY_SIX", "TWENTY_SEVEN", "TWENTY_EIGHT", "TWENTY_NINE", "THIRTY",
            "THIRTY_ONE", "THIRTY_TWO", "THIRTY_THREE", "THIRTY_FOUR", "THIRTY_FIVE", "THIRTY_SIX", "THIRTY_SEVEN", "THIRTY_EIGHT", "THIRTY_NINE", "FORTY",
            "FORTY_ONE", "FORTY_TWO", "FORTY_THREE", "FORTY_FOUR", "FORTY_FIVE"
    );

    @Test
    void getStart() {
        assertThat(LottoNumbers.getStart()).isEqualTo(MIN_LOTTO_NUMBER);
    }

    @Test
    void getEnd() {
        assertThat(LottoNumbers.getEnd()).isEqualTo(MAX_LOTTO_NUMBER);
    }

    @Test
    void contains_포함() {
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            assertThat(LottoNumbers.contains(number)).isTrue();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47, 48, 49, 50})
    void contains_비포함(int number) {
        assertThat(LottoNumbers.contains(number)).isFalse();
    }

    @Test
    void getNumber() {
        LottoNumbers[] lottoNumbers = LottoNumbers.values();

        for (int i = 0; i < lottoNumbers.length; i++) {
            assertThat(lottoNumbers[i].getNumber()).isEqualTo(LOTTO_NUMBERS_INTEGERS.get(i));
        }
    }

    @Test
    void values() {
        assertThat(LottoNumbers.values()).isEqualTo(LOTTO_NUMBERS);
    }

    @Test
    void valueOf() {
        for (int i = 0; i < LOTTO_NUMBERS_STRINGS.size(); i++) {
            assertThat(LottoNumbers.valueOf(LOTTO_NUMBERS_STRINGS.get(i)))
                    .isEqualTo(LOTTO_NUMBERS[i]);
        }
    }
}