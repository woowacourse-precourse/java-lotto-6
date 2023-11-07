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
                .hasMessage("[ERROR] 로또의 번호는 1~35 사이어야 합니다.");
    }
}
