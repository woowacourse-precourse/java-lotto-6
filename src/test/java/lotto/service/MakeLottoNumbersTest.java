package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MakeLottoNumbersTest extends NsTest {
    private final MakeLottoNumbersService makeLottoNumbersService = new MakeLottoNumbersService();


    @DisplayName("빈 문자열을 넣으면 False를 반환한다")
    @Test
    void 빈_문자열_입력_오류_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<HashSet<Integer>> lottoNumbers = makeLottoNumbersService.makeLottoNumbers(5);
                    assertThat(lottoNumbers.get(0).size()).isEqualTo(6);
                    assertThat(lottoNumbers.get(1).size()).isEqualTo(6);
                    lottoNumbers.get(0).contains(23);
                    lottoNumbers.get(1).contains(5);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @Override
    protected void runMain() {

    }
}
