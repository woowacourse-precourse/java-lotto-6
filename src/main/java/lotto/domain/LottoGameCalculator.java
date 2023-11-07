package lotto.domain;

import java.util.List;

public class LottoGameCalculator {

    /**
     * 보너스 번호 제외, 몇개가 당첨 번호와 맞는지 확인
     * */
    public int countMatchedNumbers(List<Integer> winningNumbers,
                                   List<Integer> lottoTicket){
        int matchedCount = 0;
        for (Integer number : lottoTicket) {
            if (winningNumbers.contains(number)){
                matchedCount++;
            }
        }

        return matchedCount;
    }

    public int purchaseAmountCalculator(String purchasePrice){
        int result = Integer.parseInt(purchasePrice)/1000;
        return result;
    }
    public boolean isMatchedBonusNumber(List<Integer> winningNumbers,
                                        int bonus){
        //보너스 번호가 있으면 true, 없으면 false
        return winningNumbers.contains(bonus);
    }

}
