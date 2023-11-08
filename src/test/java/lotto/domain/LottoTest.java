package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;
import lotto.exception.LottoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    @DisplayName("여섯 개의 숫자들을 통해 Lotto 를 만든다.")
    void createLotto() {
        var randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(randomNumbers);
        Assertions.assertEquals(lotto.getNumbers().size(), 6);
        Assertions.assertEquals(lotto.getClass(), Lotto.class);
    }

    @Test
    @DisplayName("여섯 개가 아닌 숫자를 넣으면 예외를 발생한다.")
    void throwExceptionWhenNumbersSizeIsNotPickCount() {
        var manyNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 10);
        var smallNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 1);

        var manyNumbersException = Assertions.assertThrows(LottoException.class, () -> {
            new Lotto(manyNumbers);
        });
        var smallNumbersException = Assertions.assertThrows(LottoException.class, () -> {
            new Lotto(smallNumbers);
        });
        Assertions.assertEquals(manyNumbersException.getClass(), smallNumbersException.getClass());
    }

    @Test
    @DisplayName("범위 밖의 숫자를 넣으면 예외를 발생한다.")
    void throwExceptionWhenNumbersIsOutRange() {
        var outRangeNumbers = Randoms.pickUniqueNumbersInRange(45, 60, 6);
        Assertions.assertThrows(LottoException.class,() ->{
            new Lotto(outRangeNumbers);
        });
    }

    @Test
    @DisplayName("중복된 숫자가 있으면 예외를 발생한다.")
    void throwExceptionWhenNumbersIsDuplicated() {
        var duplicatedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 5);
        duplicatedNumbers.add(duplicatedNumbers.get(0));
        Assertions.assertThrows(LottoException.class, () -> {
            new Lotto(duplicatedNumbers);
        });
    }
}
