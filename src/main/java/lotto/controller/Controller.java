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
        int bonusNum = requestPlayerBonusInput();

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
        int playerAmountInput = parser.stringToInteger(Console.readLine());
        return new Amount(playerAmountInput, TICKET_PRICE);
    }

    private Lotto requestPlayerWinningInput(){
        RequestMessage.requestWinningNum();
        List<Integer> playerWinningInput = parser.translatePlayerInputStringToInt(Console.readLine());
        return new Lotto(playerWinningInput);
    }

    private int requestPlayerBonusInput(){
        RequestMessage.requestBonusNum();
        return parser.stringToInteger(Console.readLine());
    }
}
