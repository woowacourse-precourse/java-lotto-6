package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.OutputMessage;
import lotto.model.Lotto;
import lotto.validator.Validator;

import java.util.HashMap;
import java.util.List;

public class View {
    private final Validator validator = new Validator();
    public int getPrice() {
        System.out.println(OutputMessage.GET_PRICE_MSG);
        int price = Integer.parseInt(Console.readLine());
        validator.validateLotteryPrice(price);
        return price;
    }


    public void printBoughtLotteries(List<Lotto> lotteries) {

    }

    public Lotto getWinnerLottery() {

    }

    public int getBonusNumber() {

    }

    public void printLotteryResult(HashMap<String, Integer> lotteryResult) {

    }
}
