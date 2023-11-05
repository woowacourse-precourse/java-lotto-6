package lotto.game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lotto.Lotto;
import lotto.lotto.WinningLotto;

public class Game {
    private List<Lotto> purchasedLottos;
    private WinningLotto winningLotto;

    public void purchaseLotto(int price) {
        purchasedLottos = IntStream.range(0, price / 1000)
                .mapToObj(i -> publishLotto())
                .collect(Collectors.toList());
    }

    public String getPurchasedLottosInfo() {
        String lottosSizeInfo = purchasedLottos.size() + "개를 구매했습니다.\n";
        return lottosSizeInfo + purchasedLottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public void setWinningLotto(List<Integer> numbers, int bonusNumber) {
        winningLotto = new WinningLotto(numbers, bonusNumber);
    }

    public String getLottoWinningResult() {
        return null;
    }

    private Lotto publishLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
