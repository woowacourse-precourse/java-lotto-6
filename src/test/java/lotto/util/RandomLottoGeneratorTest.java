package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class RandomLottoGeneratorTest {

    @Test
    public void 랜덤_숫자_중복_확인() {
        // given
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 6, 6);
        // when
        numbers.sort(Comparator.naturalOrder());
        // then
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    @Test
    public void 로또_번호_뽑기() {
        // given
        // when
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        // then
        System.out.println(numbers.toString());
    }
}
