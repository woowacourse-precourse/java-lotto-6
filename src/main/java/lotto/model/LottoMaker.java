package lotto.model;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMaker {

    private final Integer MIN_RANGE = 1;
    private final Integer MAX_RANGE = 45;
    private final Integer COUNT_NUMBER = 6;

    private final List<Lotto> lottos = new ArrayList<>();
    private final int money;
    private final int MONEYUNIT = 1000;

    public LottoMaker(int money){
        this.money = money;
        addLotto();
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
    private void addLotto(){
        for(int i= 0 ; i< makeCount() ; i++) {
            lottos.add(new Lotto(makeLottoNumber()));
        }
    }


}
