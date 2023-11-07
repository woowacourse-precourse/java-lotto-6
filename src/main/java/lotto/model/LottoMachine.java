package lotto.model;

import static lotto.constant.LottoConstant.FIFTH_PLACE_MATCH_COUNT;
import static lotto.constant.LottoConstant.FIRST_PLACE_MATCH_COUNT;
import static lotto.constant.LottoConstant.FOURTH_PLACE_MATCH_COUNT;
import static lotto.constant.LottoConstant.SECOND_THIRD_PLACE_MATCH_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.constant.NumberConstant;

public class LottoMachine {
    private List<Lotto> lottos;
    private final User user;

    public LottoMachine(int money, User user){
        int count = getLottoCount(money);
        this.lottos = createLottos(count);
        this.user = user;
    }

    //로또 생성
    private List<Lotto> createLottos(int count){
        List<Lotto> newLottos = new ArrayList<>();
        for(int i = NumberConstant.DEFAULT_VALUE; i < count; i++){
            Lotto lotto = new Lotto(makeRandomLotto());
            newLottos.add(lotto);
        }
        return newLottos;
    }

    private int getLottoCount(int money){
        return money / NumberConstant.LOTTO_PRICE;
    }

    private List<Integer> makeRandomLotto(){
        return Randoms.pickUniqueNumbersInRange(NumberConstant.MIN_NUMBER, NumberConstant.MAX_NUMBER, NumberConstant.LOTTO_RANGE);
    }

    //로또 당첨금
    private List<Integer> getRanks(List<Integer> userNumbers){
        List<Integer> rank = Arrays.asList(0, 0, 0, 0, 0);

        for (Lotto lotto : lottos){
            List<Integer> numbers = lotto.getNumbers();
            boolean bonus = user.isRightBonus(numbers);
            int count = user.getRightCount(numbers);
            int index = getRankIndex(count, bonus);
            if (index != LottoConstant.NO_PRIZE_INDEX.getValue())
                rank.set(index, rank.get(index) + 1);
        }

        return rank;
    }

    private int getRankIndex(int count, boolean flag){
        if (count == FIRST_PLACE_MATCH_COUNT.getValue())
            return 4;
        if (count == SECOND_THIRD_PLACE_MATCH_COUNT.getValue()){
            if (flag) return 3;
            return 2;
        }
        if (count == FOURTH_PLACE_MATCH_COUNT.getValue())
            return 1;
        if (count == FIFTH_PLACE_MATCH_COUNT.getValue())
            return 0;
        return -1;
    }
}
