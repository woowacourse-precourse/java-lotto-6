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
    public static Lotto createLotto(){
        List<Integer> lottoList = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM,MAX_LOTTO_NUM,LOTTO_NUM);

        //Collections.sort(lottoList);
        //lottoList.sort(Comparator.naturalOrder());

        return new Lotto(lottoList);
    }

    //형태 변환
    public static List<String> converseStringToStringList(String input){
        String[] splitInput = input.split(",");
        return Arrays.asList(splitInput);
    }

    public static List<Integer> converseStringListToIntegerList(List<String> input){
        List<String> changeInput = input;
        changeInput.replaceAll(String::trim);
        return changeInput.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    //당첨 결과 반환
    public static void printHittingResult(HashMap<Rank, Integer> map) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .filter(e -> e.getKey().getWinningMoney() != 0)
                .forEach(e -> e.getKey().printResult(map.get(e.getKey())));
    }

    //총 수익률 반환
    public static void printProfitResult(int totalHitMoney, int money) {
        System.out.print("총 수익률은 ");
        System.out.format("%.1f", (totalHitMoney / (double) money * 100.0));
        System.out.println("%입니다.");
    }
}
