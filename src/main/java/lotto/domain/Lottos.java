package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.dto.LottosDto;
import lotto.service.RandomNumbers;
import lotto.view.InputView;

public class Lottos {
    public static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;

    public Lottos(RandomNumbers randomNumbers, InputView inputView) {
        int money = inputView.insertMoney();
        lottos = createLottos(money, randomNumbers);
    }

    private List<Lotto> createLottos(int money, RandomNumbers randomNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = money / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(randomNumbers.generate()));
        }
        return lottos;
    }

    public List<Integer> matchAllLottoWithWinningOne(WinningLotto winningLotto) {
        List<Integer> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(winningLotto.matchLottoWithWinningOne(lotto));
        }
        return result;
    }

    public LottosDto toLottosDto() {
        List<String> lottosToString = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottosToString.add(lotto.toString());
        }
        return new LottosDto(lottosToString);
    }
}
