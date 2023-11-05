package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    private static int MONEY_UNIT = 1000;
    private static int LOTTO_MIN_NUMBER = 1;
    private static int LOTTO_MAX_NUMBER = 45;
    private static int LOTTO_ENTITY_SIZE = 6;

    public static List<Integer> generateLotto(){
        List<Integer> lotto = new ArrayList<>();
        lotto = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_ENTITY_SIZE);
        return sortLotto(lotto);
    }

    public static List<Integer> sortLotto(List<Integer> lotto){
        return lotto.stream().sorted().collect(Collectors.toList());
    }

    public static List<Lotto> generateLottoSet(int lottoNum) {
        List<Lotto> lottoSet = new ArrayList<>();
        for(int i = 0; i < lottoNum; i++){
            lottoSet.add(new Lotto(generateLotto()));
        }

        return lottoSet;
    }

    public static List<Integer> generateNumber(String winningString){
        List<String> winningNumber = List.of(winningString.split(","));
        return winningNumber.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public static Map<LottoRank, Integer> generateMap(LottoSet lottoSet, LottoWinning lottoWinning, LottoBonus lottoBonus){
        Map<LottoRank, Integer> map = new HashMap<>();
        for(Lotto lotto : lottoSet.getLottoSet()){

        }
    }

    public static LottoRank hitType(List<Integer> player, List<Integer> lotto, Integer bonus){
        int count = player.stream().filter(lotto::contains).distinct().collect(Collectors.toList()).size();

        if(count < 3) {
            return LottoRank.MISS;
        }if(count == 3){
            return LottoRank.FIFTH;
        }
        if(count == 4){
            return  LottoRank.FOURTH;
        }
        if(count == 5){
            return  LottoRank.FOURTH;
        }
        if(count == 6){
            return  LottoRank.FOURTH;
        }
    }
}
