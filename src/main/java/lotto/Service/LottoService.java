package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoService {

    private static int MONEY_UNIT = 1000;
    private static int LOTTO_MIN_NUMBER = 1;
    private static int LOTTO_MAX_NUMBER = 45;
    private static int LOTTO_ENTITY_SIZE = 6;

    public int calLottoNum(String buyMoney){
        int lottoNum = Integer.parseInt(buyMoney) / MONEY_UNIT;

        return lottoNum;
    }

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
}
