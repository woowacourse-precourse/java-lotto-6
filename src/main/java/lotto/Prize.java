package lotto;

import java.util.List;

public class Prize {

    private final List<Integer> getBuyLottos;
    //    private final List<Integer> getWinLottos;
    private final int matchingCount;
    private final int bonusNumber;

    public Prize(List<Integer> getBuyLottos, List<Integer> getWinLottos, int bonusNumber){
        long matchingCount = getBuyLottos.stream()
                .filter(getWinLottos::contains) // getWinLottos에 포함된 요소만 필터링
                .count(); // 필터링된 요소의 수를 세어 일치하는 요소 수를 얻음

        //이 두개를 검증과증

        this.getBuyLottos = getBuyLottos;
        this.matchingCount = (int) matchingCount;
        this.bonusNumber = bonusNumber;
    }

    public Result getResult() {
        Result result = null;
        if(matchingCount < 3){
            result = Result.zero;
            return result;
        }
        if(matchingCount == 3){
            result = Result.five;
            return result;
        }
        if(matchingCount == 4){
            result = Result.four;
            return result;
        }
        if(matchingCount == 5 && !getBuyLottos.contains(bonusNumber)){
            result = Result.three;
            return result;
        }
        if(matchingCount == 5 && getBuyLottos.contains(bonusNumber)){
            result = Result.two;
            return result;
        }
        if(matchingCount == 6){
            result = Result.one;
            return result;
        }

        return result;
    }

}