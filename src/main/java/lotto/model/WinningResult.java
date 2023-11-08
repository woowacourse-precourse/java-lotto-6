package lotto.model;

import java.util.List;
import java.util.ArrayList;

public class WinningResult {

    List<Integer> results = new ArrayList<>();

    public int calculateResult(MyLottoNumber myLottoNumber, LottoDraw lottoDraw) {
        int result = 0;
        int bonusMatch = 0;
        // 로또 번호와 당첨 번호를 비교하고 결과를 계산
        for (int myNumber : myLottoNumber.getMyLottoNumber()) {
            if (lottoDraw.isMatching(myNumber)) {
                result++;
            }
        }

        if (lottoDraw.isBonusMatching(lottoDraw.getBonusNumber())) {
            bonusMatch++;
        }
        if(result != 5) bonusMatch = 0;
        return result + bonusMatch * 10;
    }
    public List<Integer> calculateResults(MyLottoNumbers myLottoNumbers, LottoDraw lottoDraw) {

        // 여기서 로또 번호와 당첨 번호를 비교하고 결과를 계산합니다.
        for (MyLottoNumber myLottoNumber : myLottoNumbers.getMyLottoNumbers()) {
            // 결과를 계산하고 results 리스트에 추가
            int result = calculateResult(myLottoNumber, lottoDraw);
            results.add(result);
        }

        return results;
    }

    public long calculateRevenue(List<Integer> results){
        long totalRevenue = 0;
        for (int result : results) {
            if(result == 3) totalRevenue += 5000;
            if(result == 4) totalRevenue += 50000;
            if(result == 5) totalRevenue += 1500000;
            if(result == 15) totalRevenue += 30000000;
            if(result == 6) totalRevenue += 2000000000;
        }
        return totalRevenue;
    }

}
