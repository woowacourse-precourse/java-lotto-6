package lotto.domain;

import java.util.List;

public class LottoWallet {
    private final List<Lotto> lottos;

    public LottoWallet(int lottoCount) {
        this.lottos = LottoMachine.publish(lottoCount);
    }

    public int getLottoCount() {
        return lottos.size();
    }
    

    public List<Integer> getSingleLottoNumbers(int index) {
        return lottos.get(index).getNumbers();
    }

    @Override
    public String toString() {
        return "LottoWallet{" +
                "lottos=" + lottos +
                '}';
    }
}
