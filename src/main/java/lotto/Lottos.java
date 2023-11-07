package lotto;

import static Constant.LottoSettingValue.COST_OF_LOTTO;
import static Constant.LottoSettingValue.LOTTO_MAXIMUM_NUMBER;
import static Constant.LottoSettingValue.LOTTO_MINIMAL_NUMBER;
import static Constant.LottoSettingValue.NUMBER_OF_UNIQUE_NUMBERS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private static List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    public static Lottos issueLottos(Integer money){
        Integer issueCount = countNumberOfLottoIssue(money);
        List<Lotto> numberOfLotto = new ArrayList<Lotto>(issueCount);
        for (Integer count = 0; count < issueCount; count++) {
            List<Integer> randomNumbers = new ArrayList<Integer>(Randoms.pickUniqueNumbersInRange(
                    LOTTO_MINIMAL_NUMBER, LOTTO_MAXIMUM_NUMBER,NUMBER_OF_UNIQUE_NUMBERS));
            Collections.sort(randomNumbers);
            numberOfLotto.add(new Lotto(Collections.unmodifiableList(randomNumbers)));
        }
        return new Lottos(numberOfLotto);
    }

    public static Integer countNumberOfLottoIssue(Integer money){
        return money / COST_OF_LOTTO;
    }

    public Lotto getLotto(Integer index) {
        return lottos.get(index);
    }

    public Integer getSize(){
        return lottos.size();
    }

}
