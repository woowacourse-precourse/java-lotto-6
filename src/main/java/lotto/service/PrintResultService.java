package lotto.service;

import java.util.*;

public class PrintResultService {
    private static final String RESULTPRINTMESSAGE = "당첨 통계\n---";
    private static final String FIFTH_PLACE = "3개 일치 (5,000원) - %d개";
    private static final String FOURTH_PLACE = "4개 일치 (50,000원) - %d개";
    private static final String THIRD_PLACE = "5개 일치 (1,500,000원) - %d개";
    private static final String SECOND_PLACE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String FIRST_PLACE = "6개 일치 (2,000,000,000원) - %d개";
    private static final String TOTAL_SCORE = "총 수익률은 %.1f%%입니다.";

    // 당첨 횟수를 담는 Map => 1등 0회, 2등 0회,,,
    // 순서를 유지하기 위하여 LinkedHashMap
    private final Map<String, Integer> winningCount = new LinkedHashMap<>(){{
        put(FIFTH_PLACE, 0);
        put(FOURTH_PLACE, 0);
        put(THIRD_PLACE, 0);
        put(SECOND_PLACE, 0);
        put(FIRST_PLACE, 0);
    }};

    //당첨금이 Integer 초과할 수도 있다
    private Long totalWinnings = 0L;

    public void printResult(
            List<HashSet<Integer>> userNumbers,
            HashSet<Integer> lottoNumbers,
            Integer lottoBonusNumber) {
        System.out.println(RESULTPRINTMESSAGE);
        setLottoWinningCount(userNumbers, lottoNumbers, lottoBonusNumber);
        printLottoWinningCountResult();
        printRateOfReturn(userNumbers);
    }



    public void setLottoWinningCount(
            List<HashSet<Integer>> userNumbers,
            HashSet<Integer> lottoNumbers,
            Integer lottoBonusNumber){
         for (HashSet<Integer> oneOfUserLottoNumbers: userNumbers) {
            lottoCheckAndAppend(lottoNumbers, lottoBonusNumber, oneOfUserLottoNumbers);
        }
    }


    public void lottoCheckAndAppend(HashSet<Integer> lottoNumbers, Integer lottoBonusNumber, HashSet<Integer> oneOfUserLottoNumbers) {
        Boolean bonusCheck = oneOfUserLottoNumbers.contains(lottoBonusNumber);
        oneOfUserLottoNumbers.retainAll(lottoNumbers);
        if (oneOfUserLottoNumbers.size() == 6)
            winningCount.put(FIRST_PLACE, winningCount.get(FIRST_PLACE) + 1);
        if (oneOfUserLottoNumbers.size() == 5 && bonusCheck)
            winningCount.put(SECOND_PLACE, winningCount.get(SECOND_PLACE) + 1);
        if (oneOfUserLottoNumbers.size() == 5 && !bonusCheck)
            winningCount.put(THIRD_PLACE, winningCount.get(THIRD_PLACE) + 1);
        if (oneOfUserLottoNumbers.size() == 4)
            winningCount.put(FOURTH_PLACE, winningCount.get(FOURTH_PLACE) + 1);
        if (oneOfUserLottoNumbers.size() == 3)
            winningCount.put(FIFTH_PLACE, winningCount.get(FIFTH_PLACE) + 1);
    }


    public void printLottoWinningCountResult() {
        for (Map.Entry<String, Integer> entry : winningCount.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(String.format(key, value));
        }
    }


    public void printRateOfReturn(List<HashSet<Integer>> userNumbers){
        setTotalWinnings();
        int precision = 100; // 소수점 두 자리를 나타내는 100으로 설정
        double roundedValue = (double) Math.round(((double)totalWinnings / (userNumbers.size() * 10)) * precision) / precision;
        System.out.println(String.format(TOTAL_SCORE, roundedValue));
    }


    public void setTotalWinnings(){
        for (Map.Entry<String, Integer> entry : winningCount.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            checkKeyAndMoneyAppend(key,value);
        }
    }


    public void checkKeyAndMoneyAppend(String key, Integer value) {
        if (key == FIRST_PLACE) totalWinnings += 2_000_000_000 * value;
        if (key == SECOND_PLACE) totalWinnings += 30_000_000 * value;
        if (key == THIRD_PLACE) totalWinnings += 1_500_000 * value;
        if (key == FOURTH_PLACE) totalWinnings += 50_000 * value;
        if (key == FIFTH_PLACE) totalWinnings += 5_000 * value;
    }


    //테스트 코드 작성용
    public Map<String, Integer> getWinningCount() {
        return winningCount;
    }

    public Long getTotalWinning(){
        return totalWinnings;
    }


}
