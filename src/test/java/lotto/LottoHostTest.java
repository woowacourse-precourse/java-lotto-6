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
    @ValueSource(ints= {0,-9, 46,99})
    public void 보너스_번호가_범위를_넘는_경우에_대한_예외처리(Integer numbers) {
        LottoHost testLottoHost= new LottoHost();
        Assertions.assertThatThrownBy(() -> testLottoHost.initBonusNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또의 번호는 1~45 사이어야 합니다.");
    }
}
