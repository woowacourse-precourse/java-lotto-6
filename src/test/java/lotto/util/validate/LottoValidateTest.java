package lotto.util.validate;

import static java.util.stream.Collectors.*;
import static lotto.lotto.model.LottoConstant.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lotto.model.Lotto;

class LottoValidateTest {

    private final static int LOTTO_COUNT = 3;

    private List<Lotto> lottos;

    @BeforeEach
    void setUp(){
        lottos = new ArrayList<>();
        for(int i=0;i<LOTTO_COUNT;i++){
            Lotto lotto = new Lotto(List.of(7, 6, 5, 4, 3, 2));
            lottos.add(lotto);
        }
    }

    @DisplayName("로또의 번호들의 오름차순이 아닌 경우")
    @Test
    void 로또_오름차순_확인(){
        assertThatThrownBy(() -> LottoValidate.checkLottos(lottos))
            .isInstanceOf(IllegalArgumentException.class);

    }
}
