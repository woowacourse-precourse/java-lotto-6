package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Model.GameModel;
import lotto.Model.LottoHost;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoHostTest {


    @ParameterizedTest
    @ValueSource(strings= {"0,-1,-2,-99","36,99,999", "-1,0,40,999"})
    public void 로또_번호가_범위를_넘는_경우에_대한_예외처리(String numbers) {
        List<Integer> testLottoNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        LottoHost testLottoHost= new LottoHost();
        Assertions.assertThatThrownBy(() -> testLottoHost.initAnswerLotto(testLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또의 번호는 1~45 사이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings= {"1,1,3,5","20,20,20,14", "5,19,19,19,19,5,3", "6,10,6,10"})
    public void 로또_번호가_중복되는_경우에_대한_예외처리(String numbers) {
        List<Integer> testLottoNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        LottoHost testLottoHost= new LottoHost();
        Assertions.assertThatThrownBy(() -> testLottoHost.initAnswerLotto(testLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또의 번호는 서로 다른 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings= {"1,2,3,4,5,6,7,8","20,19,18,17", "5","11,12"})
    public void 로또_번호의_크기가_6이아닌_경우에_대한_예외처리(String numbers) {
        List<Integer> testLottoNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        LottoHost testLottoHost= new LottoHost();
        Assertions.assertThatThrownBy(() -> testLottoHost.initAnswerLotto(testLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints= {0,-9, 46,99})
    public void 보너스_번호가_범위를_넘는_경우에_대한_예외처리(Integer numbers) {
        LottoHost testLottoHost= new LottoHost();
        Assertions.assertThatThrownBy(() -> testLottoHost.initBonusNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또의 번호는 1~45 사이어야 합니다.");
    }
}
