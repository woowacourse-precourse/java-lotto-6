package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.io.InputManager;
import lotto.io.PaymentInputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoShop {
    private final Integer lottoCount;
    private final List<Lotto> lottos=new ArrayList<>();

    public LottoShop(Integer lottoCount) {
        this.lottoCount = lottoCount;
        generateLotto();
    }

    public void generateLotto(){
        for (int i = 0; i < lottoCount; i++)
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,7)));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
