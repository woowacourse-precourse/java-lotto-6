package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoCheckerTest {

    @Test
    void checkNumber() {
        List<Integer> numbers = Arrays.asList(1,2,3,8,9,10);
        Lotto lotto = new Lotto(numbers);
        List<Lotto> lottos = Arrays.asList(lotto);
        LottoChecker checker = new LottoChecker(lottos,"1,2,3,4,5,6","7");

        assertThat(checker.checkNumber(lotto)).isEqualTo(3);
    }

    @Test
    void checkResult() {
        List<Integer> numbers = Arrays.asList(1,2,3,8,9,10);
        Lotto lotto = new Lotto(numbers);
        List<Lotto> lottos = Arrays.asList(lotto);
        LottoChecker checker = new LottoChecker(lottos,"1,2,3,4,5,6","7");
        List<Integer> result = checker.checkResult();
        assertThat(result).isEqualTo(Arrays.asList(1,0,0,0,0));
    }


}