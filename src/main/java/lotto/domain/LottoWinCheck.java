package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import lotto.util.InputUtil;
import lotto.util.MessageUtil;
import lotto.util.ValidationUtil;

public class LottoWinCheck {
    // 로또 하나 몇개 당첨 되었는지
    private final ValidationUtil validationUtil = new ValidationUtil();
    private final MessageUtil messageUtil = new MessageUtil();
    private List<Integer> playerWinningNums;
    private Integer bonusNum;
    public LottoWinCheck(){}
    public LottoWinCheck(List<Integer> playerNums, int bonusNum){
        // constructor for test
        this.playerWinningNums = playerNums;
        this.bonusNum = bonusNum;
    }
    public LottoWinCheck(List<Integer> playerNums){
        this.playerWinningNums = playerNums;
    }
    public LottoWinCheck getPlayerNumbersInfo(String playerNums){
        this.playerWinningNums = getPlayerWinningNumbers(playerNums);
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
        List<Integer> lottoNums = validationUtil.validateWinningNumber(playersNums);
//        messageUtil.printLottoNums(lottoNums);
        String playerBonusNums = messageUtil.printBonusInput();
        this.bonusNum = getBonusNumbers(playerBonusNums);
        messageUtil.printBonusOutput(bonusNum);
        return lottoNums;
    }
    private int getBonusNumbers(String bonusNum){
        validationUtil.validateBonusNumberRange(Integer.parseInt(bonusNum));
        return Integer.parseInt(bonusNum);
    }
}
