package lotto;

import lotto.model.IssuedLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class IssuedLottoTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("랜덤으로 발행한 로또 넘버 6개를 정렬하는 기능")
    @Test
    void SortedIssuedLottoNumberCheck() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    IssuedLotto issuedLotto = new IssuedLotto();
                    List<Integer> sortedNumbers = Arrays.asList(8, 21, 23, 41, 42, 43);
                    Assertions.assertEquals(issuedLotto.getSortedNumbers(), sortedNumbers);
                },
                List.of(23, 43, 8, 41, 42, 21)
        );
    }

}
