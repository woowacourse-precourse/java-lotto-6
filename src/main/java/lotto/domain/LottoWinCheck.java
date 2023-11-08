package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import lotto.util.InputUtil;
import lotto.util.ValidationUtil;

public class LottoWinCheck {
    // 로또 하나 몇개 당첨 되었는지
    private final ValidationUtil validationUtil = new ValidationUtil();
    private List<Integer> playerWinningNums;
    private Integer bonusNum;
    public LottoWinCheck(){}
    public LottoWinCheck(List<Integer> playerNums, int bonusNum){
        // constructor for test
        this.playerWinningNums = playerNums;
        this.bonusNum = bonusNum;
    }
    public LottoWinCheck getPlayerNumbersInfo(String playerNums, String bonusNum){
        this.playerWinningNums = getPlayerWinningNumbers(playerNums);
        //print 부분 필요함 당첨번호
        this.bonusNum = getBonusNumbers(bonusNum);
        // print 부분 필요함 버스 번호

        return this;
    }

    public List<Integer> getWinningNumbers(){
        return playerWinningNums;
    }

    public Integer getBonusNum(){
        return bonusNum;
    }
    public int winningCheck(List<Integer> playerNumbers) {
        List<Integer> matchList = playerNumbers.stream().filter(o -> playerWinningNums.stream()
                .anyMatch(Predicate.isEqual(o))).toList();
        return matchList.size();
    }

    public boolean bonusWinningCheck(){
        for(int number : playerWinningNums){
            if(number == bonusNum){
                return true;
            }
        }
        return false;
    }
    private List<Integer> getPlayerWinningNumbers(String playersNums){
        return validationUtil.validateWinningNumber(playersNums);
    }
    private int getBonusNumbers(String bonusNum){
        validationUtil.validateBonusNumberRange(Integer.parseInt(bonusNum));
        return Integer.parseInt(bonusNum);
    }
}
