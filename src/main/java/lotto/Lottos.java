package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static final int LOTTO_MINIMAL_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final int NUMBER_OF_UNIQUE_NUMBERS = 6;
    private static final int COST_OF_LOTTO = 1000;

    private static List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    public static Lottos issueLottos(int money){
        int issueCount = countNumberOfLottoIssue(money);
        List<Lotto> numberOfLotto = new ArrayList<Lotto>(issueCount);
        for (int count = 0; count < issueCount; count++) {
            numberOfLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                    LOTTO_MINIMAL_NUMBER, LOTTO_MAXIMUM_NUMBER,NUMBER_OF_UNIQUE_NUMBERS)));
        }
        return new Lottos(numberOfLotto);
    }

    public static int countNumberOfLottoIssue(int money){
        return money / COST_OF_LOTTO;
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public int getSize(){
        return lottos.size();
    }

}
