package generator;

import camp.nextstep.edu.missionutils.Randoms;
import enums.Prize;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.Calculator.judgeRanking;


public class Generator {
    public static Lotto makeLottoNums() {
        List<Integer> randomNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNum);
    }

    public static HashMap<Prize, Integer> makeEmpty() {
        HashMap<Prize, Integer> prizeCountHashMap = new HashMap<Prize, Integer>();
        prizeCountHashMap.put(Prize.FIRST, 0);
        prizeCountHashMap.put(Prize.SECOND, 0);
        prizeCountHashMap.put(Prize.THIRD, 0);
        prizeCountHashMap.put(Prize.FOURTH, 0);
        prizeCountHashMap.put(Prize.FIFTH, 0);

        return prizeCountHashMap;
    }

    public static List<Lotto> makeLottos(int lotteryAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lotteryAmount; i++) {
            Lotto lottoNumbers = makeLottoNums();
            lottoNumbers.printLottoNumber();
            lottos.add(lottoNumbers);
        }
        return lottos;
    }

    public static HashMap<Prize, Integer> makeRankings(List<Lotto> lottos, List<Integer> winningLotto, int bonusNum) {
        HashMap<Prize, Integer> ranking = makeEmpty();
        for (Lotto lotto : lottos) {
            int matchingCount = lotto.numOfMatchNum(winningLotto);
            boolean matchingBonus = lotto.ifBonusNumEqual(bonusNum);
            judgeRanking(matchingCount,matchingBonus, ranking);
        }

        return ranking;
    }
}
