package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.userLotto.domain.Lotto;
import lotto.userLotto.domain.Lottos;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    Lottos lottos1;

    @BeforeEach
    void beforeEach(){
        int lottoCount = 8;
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i<lottoCount; i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
        lottos1 = new Lottos(lottos);
    }

    @DisplayName("로또들을 출력한다.")
    @Test
    void printLottos(){
        OutputView.printLottos(lottos1);
    }

    @DisplayName("당첨 통계를 출력한다.")
    @Test
    void result(){
//        OutputView.result();

    }


}