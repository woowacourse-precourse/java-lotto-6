package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

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
