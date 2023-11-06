package lotto.domain;

import static lotto.constants.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.MIN_LOTTO_NUMBER;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
import lotto.exception.LottoNumberRangeException;

public class LottoNumber implements Comparable {


    private final int number;

    private static final Map<Integer, LottoNumber> lottoNumberStore = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                 .forEach(number -> lottoNumberStore.put(number, new LottoNumber(number)));
    }

    private LottoNumber(int number) {

        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        checkRange(number);
        return lottoNumberStore.get(number);
    }

    private static void checkRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new LottoNumberRangeException();
        }
    }

    public int showNumber() {
        return number;
    }

    @Override
    public int compareTo(Object object) {
        LottoNumber other = (LottoNumber) object;
        return this.number - other.number;
    }

    @Override
    public boolean equals(Object object) {

        if (object == this) {
            return true;
        }
        if (object == null || object != this.getClass()) {
            return false;
        }

        LottoNumber other = (LottoNumber) object;

        return this.number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number);
    }
}
