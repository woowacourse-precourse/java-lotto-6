package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWallet {
    private final List<Lotto> lottos;

    public LottoWallet(int lottoCount) {
        this.lottos = LottoMachine.publish(lottoCount);
    }

    public float getLottoCount() {
        return lottos.size();
    }

    public List<Integer> getSingleLottoNumbers(int index) {
        return lottos.get(index).getNumbers();
    }

    public List<WinningLotto> getLottoResult(WinningNumbers winningNumbers) {
        List<WinningLotto> winningLottos = new ArrayList<>();

        for (Lotto lotto : lottos) {
            lotto.getWinningLotto(winningNumbers);
        }

        return winningLottos;
    }

    @Override
    public String toString() {
        return "LottoWallet{" +
                "lottos=" + lottos +
                '}';
    }
}
