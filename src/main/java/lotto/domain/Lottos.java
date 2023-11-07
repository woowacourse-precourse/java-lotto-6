package lotto.domain;

import lotto.utils.ErrorCode;
import lotto.controller.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final long money;

    public Lottos(long money) {
        validateMoneyUnit(money);
        this.money = money;
        lottos = new ArrayList<>();
        generateLottos(money);
    }

    private void generateLottos(long money){
        int times = (int)money/1000;
        for(int i=0; i<times; i++){
            Lotto lotto = new Lotto(LottoGenerator.generateLotto());
            lottos.add(lotto);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lottos.stream()
                .forEach(lotto->sb.append(lotto+"\n"));
        return sb.toString();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void validateMoneyUnit(long money){
        if(money%1000!=0) throw new IllegalArgumentException(ErrorCode.INVALID_MONEY.getMessage());
    }
}
