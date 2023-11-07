package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private int lottoCount;
    private List<Lotto> playerLottos;
    private List<Lotto> winningLottos;

    public void initGame(int money) {
        lottoCount = money / Lotto.LOTTO_PRICE;
        winningLottos = generateWinningLottos();
    }

    private List<Lotto> generateWinningLottos(){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++){
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_MIN_NUMBER, Lotto.LOTTO_MAX_NUMBER, Lotto.LOTTO_SIZE)));
        }
        return lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getWinningLottos() {
        return winningLottos;
    }
}
