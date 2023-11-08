package lotto.util;

import lotto.domain.RateOfReturn;
import lotto.domain.WinningRate;

import java.util.*;

public class WiningResultUtil {
    private List<List<Integer>> lottoNumber;
    private List<Integer> winningNumber;
    Map<String, Integer> matchCounts;

    public WiningResultUtil() {
        lottoNumber = new ArrayList<>();
        winningNumber = new ArrayList<>();
        matchCounts = new LinkedHashMap<>();
    }

    /**
     * 당첨번호 개수 확인을 위해, 로또번호 담긴 리스트와 당첨번호 리스트를 받아 설정
     */
    public void setWinning(List<List<Integer>> lottoNumber, List<Integer> winningNumber){
        this.lottoNumber = lottoNumber;
        this.winningNumber = winningNumber;
    }

    /**
     * 1. 보너스 번호를 추가로 인수로 받아 일치하는 리스트와 그 개수 확인
     * 2. 그 개수만큼 Map에 저장해서 저장 후, 리턴
     * 3. 추가로 수익률 객체를 인수로 받아 일치하는 리스트가 존재할 경우, 해당하는 수익금만큼 더함
     */
    public Map<String, Integer> calculateMatchCount(int bonus, RateOfReturn rateOfReturn){
        initMatchCounts();
        for (List<Integer> lottoNumbers : lottoNumber) {
            int matchCount = (int) lottoNumbers.stream()
                    .filter(winningNumber::contains)
                    .count();
            if (matchCount == 5 && lottoNumbers.contains(bonus)) {
                matchCount = 7;
            }
            String message = getMatchingMessage(matchCount);
            rateOfReturn.setReward(getMatchingRevenue(matchCount));
            matchCounts.put(message, matchCounts.getOrDefault(message, 0) + 1);
        }
        return matchCounts;
    }


    /**
     * Map 초기화를 위한 메소드
     */
    private void initMatchCounts() {
        matchCounts.put(WinningRate.FIFTH.getMessage(), 0);
        matchCounts.put(WinningRate.FOURTH.getMessage(), 0);
        matchCounts.put(WinningRate.THIRD.getMessage(), 0);
        matchCounts.put(WinningRate.SECOND.getMessage(), 0);
        matchCounts.put(WinningRate.FIRST.getMessage(), 0);
        matchCounts.put(WinningRate.LOSE.getMessage(),0);
    }

    /**
     * 일치 개수에 따른 메세지 반환
     */
    private String getMatchingMessage(int matchCount) {
        if (matchCount == 3)
            return WinningRate.FIFTH.getMessage();
        if (matchCount == 4)
            return WinningRate.FOURTH.getMessage();
        if (matchCount == 5)
            return WinningRate.THIRD.getMessage();
        if (matchCount == 7)
            return WinningRate.SECOND.getMessage();
        if (matchCount == 6)
            return WinningRate.FIRST.getMessage();
        if(matchCount < 3)
            return WinningRate.LOSE.getMessage();
        return null;
    }

    /**
     * 일치 개수에 따른 금액 반환
     */
    private long getMatchingRevenue(int matchCount) {
        if (matchCount == 3)
            return WinningRate.FIFTH.getRateOfReturn();
        if (matchCount == 4)
            return WinningRate.FOURTH.getRateOfReturn();
        if (matchCount == 5)
            return WinningRate.THIRD.getRateOfReturn();
        if (matchCount == 7)
            return WinningRate.SECOND.getRateOfReturn();
        if (matchCount == 6)
            return WinningRate.FIRST.getRateOfReturn();
        if(matchCount < 3)
            return WinningRate.LOSE.getRateOfReturn();
        return 0;
    }
}
