package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private int numOfLotto;
    private final List<Lotto> lottos = new ArrayList<>();

    public int getNumOfLotto() {
        return this.numOfLotto;
    }

    public void setNumOfLotto(int lottoNum) {
        this.numOfLotto = lottoNum;
    }

    public void setLottos() {
        System.out.println(this.numOfLotto + "개를 구매했습니다.");
        for (int i = 0; i < this.numOfLotto; i++) {
            this.lottos.add(makeLottoNum());
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private static Lotto makeLottoNum() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<LottoValue> judgeWinningLotto(Client client) {
        List<LottoValue> lottoValues = new ArrayList<>();
        for (Lotto lotto: this.lottos){
            if(lotto.match(client.getLotto(), client.getBonusNum()) != null){
                lottoValues.add(lotto.match(client.getLotto(), client.getBonusNum()));
            }
        }
        return lottoValues;
    }


}
