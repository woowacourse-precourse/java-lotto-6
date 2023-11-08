package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Prize;
import lotto.domain.Rank;
import lotto.util.Utils;
import lotto.view.inputMessage;
import lotto.view.outputMessage;

import java.util.HashMap;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Utils.changeStringToInt;

public class Controller {

    private Buyer buyer;

    public void playGame() {
        buyLotto();
        HashMap<Rank,Integer> ranks = pickPrize();
        getEarningRate(ranks);
    }

    public void buyLotto() {
        inputMessage.priceMessage();
        int price = changeStringToInt(readLine());
        buyer = new Buyer(price);
    }

    public HashMap<Rank, Integer> pickPrize() {
        Prize prize = new Prize(getPrizeNumber(), getBonusNumber());
        HashMap<Rank, Integer> ranks = prize.makePrizeRanks(buyer);
        outputMessage.rankMessage(ranks);
        return ranks;
    }

    public void getEarningRate(HashMap<Rank,Integer> ranks){
        double earningRate =  buyer.calculationEarningRate(ranks);
        outputMessage.earningRateMessage(earningRate);
    }

    private String getPrizeNumber() {
        inputMessage.prizeMessage();
        return readLine();
    }

    private int getBonusNumber() {
        inputMessage.bonusMessage();
        return Utils.changeStringToInt(readLine());
    }

}
