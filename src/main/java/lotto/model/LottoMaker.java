package lotto.model;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMaker {

    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer COUNT_NUMBER = 6;

    private List<Lotto> lottos = new ArrayList<>();
    private final int money;
    private final int MONEYUNIT = 1000;

    LottoMaker(int money){
        this.money = money;
    }

    private List<Integer> makeLottoNumber(){
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT_NUMBER);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private int makeCount(){
        return money / MONEYUNIT;
    }
    void addLotto(int money){
        for(int i= 0 ; i< makeCount() ; i++) {
            lottos.add(new Lotto(makeLottoNumber()));
        }
    }


}
