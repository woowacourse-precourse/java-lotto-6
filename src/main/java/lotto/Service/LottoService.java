package lotto.Service;

import lotto.Domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    List<Lotto> lottos = new ArrayList<>();
    Integer bonusNumber;
    double earningReate;
    List<Integer> matchingCount;

    public LottoService(){

    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void createLottos(){

    }

    private void createLotto(){

    }

    public void createBonusNumber(){

    }

    public Integer createRandomValue(){
        return null;
    }

    public double calculateEarningRage(){
        return 0;
    }
}
