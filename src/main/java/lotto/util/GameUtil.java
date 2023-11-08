package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class GameUtil {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_NUM = 6;

    //로또 생성
    public static Lotto createLotto() {
        List<Integer> newLotto = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_NUM);
        return new Lotto(newLotto);
    }

    //형태 변환
    public static List<String> converseStringToStringList(String input) {
        String[] splitInput = input.split(",");
        return Arrays.asList(splitInput);
    }

    public static List<Integer> converseStringListToIntegerList(List<String> input) {
        List<String> changeInput = input;
        changeInput.replaceAll(String::trim);
        return changeInput.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    //당첨 결과
    public static HashMap<Rank, Integer> setLottoHit(List<Rank> rankList) {
        HashMap<Rank, Integer> rankIntegerHashMap = new LinkedHashMap<>();

        Arrays.stream(Rank.values())
                .forEach(rank -> rankIntegerHashMap.put(rank, 0));
        rankList.forEach(rank -> rankIntegerHashMap.put(rank, rankIntegerHashMap.get(rank) + 1));

        return rankIntegerHashMap;
    }

    //당첨 수령금
    public static int setTotalHitMoney(HashMap<Rank, Integer> rankIntegerHashMap) {
        return rankIntegerHashMap.entrySet().stream()
                .mapToInt(e -> e.getKey().getWinningMoney() * e.getValue()).sum();
    }
}
