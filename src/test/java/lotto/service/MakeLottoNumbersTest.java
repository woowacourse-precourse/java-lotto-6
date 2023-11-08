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


    @DisplayName("로또 갯수를 입력하면 로또 배열을 반환한다")
    @Test
    void 로또_정상_반환_테스트() {
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

    @DisplayName("로또 배열을 넣으면 정상적으로 출력한다")
    @Test
    void 로또_정상_출력_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<HashSet<Integer>> lottoNumbers = makeLottoNumbersService.makeLottoNumbers(2);
                    makeLottoNumbersService.printLottoNumberArrays(lottoNumbers);
                    assertThat(output()).contains("[8, 21, 23, 41, 42, 43]");
                    assertThat(output()).contains("[3, 5, 11, 16, 32, 38]");
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @Override
    protected void runMain() {

    }
}
