package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Prize;
import lotto.domain.Rank;
import lotto.util.Utils;
import lotto.view.inputMessage;
import lotto.view.outputMessage;

import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Utils.ChangeStringToInt;

public class Controller {

    private Buyer buyer;

    public void playGame(){
        buyLotto();
        pickPrize();

    }
    public void buyLotto(){
        inputMessage.priceMessage();
        int price = ChangeStringToInt(readLine());
        buyer = new Buyer(price);
    }

    public void pickPrize(){
        Prize prize = new Prize(getPrizeNumber(),getBonusNumber());
//        List<Rank> MatchNumberCounts = prize.getMatchNumberCounts(buyer);
        HashMap<Rank, Integer> ranks = prize.makePrizeRanks(buyer);
        outputMessage.rankMessage(ranks);

    }
    public String getPrizeNumber(){
        inputMessage.prizeMessage();
        return readLine();
    }

    public int getBonusNumber(){
        inputMessage.bonusMessage();
        return Utils.ChangeStringToInt(readLine());
    }

}
