package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.utils.LottoNumRandomGenerator;
import lotto.utils.Parser;
import lotto.view.RequestMessage;
import lotto.view.ResultMessage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    private static final int TICKET_PRICE=1000;

    LottoNumRandomGenerator lottoNumRandomGenerator = new LottoNumRandomGenerator();
    Parser parser = new Parser();

    public void run(){
        startLotto();
    }

    private void startLotto(){
        Amount amount = requestPlayerAmountInput();
        List<Lotto> randomLottery = lottoNumRandomGenerator.purchaseLottery(amount);
        ResultMessage.setPurchaseMessage(amount,randomLottery);

        Lotto winningNum = requestPlayerWinningInput();
        int bonusNum = requestPlayerBonusInput(winningNum);

        Map<Rank, Integer> result = calculateResult(randomLottery, winningNum, bonusNum);
        ResultMessage.printResult(result, amount);
    }

    private Map<Rank,Integer> calculateResult(List<Lotto> randomLottery, Lotto winningNum,int bonusNum){
        Map<Rank, Integer> result = setRankCount();
        Rank rank;

        for (Lotto lotto : randomLottery) {
            rank=Rank.decideRank(lotto.compareLottoWithWinning(winningNum),lotto.containNum(bonusNum));
            result.put(rank,result.get(rank)+1);
        }

        return result;
    }

    private Map<Rank,Integer> setRankCount(){
        Map<Rank, Integer> result = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        return result;
    }

    private Amount requestPlayerAmountInput(){
        RequestMessage.requestTotalPrice();
        return validateRequestPlayerAmountInput();
    }

    private Lotto requestPlayerWinningInput(){
        RequestMessage.requestWinningNum();
        return validaterequestPlayerWinningInput();
    }

    private int requestPlayerBonusInput(Lotto winningNum){
        RequestMessage.requestBonusNum();
        return validaterequestPlayerBonusInput(winningNum);
    }

    private Amount validateRequestPlayerAmountInput(){
        try{
            int playerAmountInput = parser.stringToInteger(Console.readLine());
            return new Amount(playerAmountInput,TICKET_PRICE);
        } catch(IllegalArgumentException e){
            ResultMessage.printExceptionMessage(e.getMessage());
            return requestPlayerAmountInput();
        }
    }

    private Lotto validaterequestPlayerWinningInput(){
        try{
            List<Integer> playerWinningInput = parser.translatePlayerInputStringToInt(Console.readLine());
            return new Lotto(playerWinningInput);
        } catch(IllegalArgumentException e){
            ResultMessage.printExceptionMessage(e.getMessage());
            return requestPlayerWinningInput();
        }
    }

    private int validaterequestPlayerBonusInput(Lotto winningNum){
        try{
            int result=parser.stringToInteger(Console.readLine());
            winningNum.validateWinningAndBonus(winningNum,result);
            return result;
        } catch(IllegalArgumentException e){
            ResultMessage.printExceptionMessage(e.getMessage());
            return requestPlayerBonusInput(winningNum);
        }
    }
}
