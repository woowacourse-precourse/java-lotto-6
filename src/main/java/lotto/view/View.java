package lotto.view;

import lotto.model.Lotto;
import lotto.validator.Validator;

import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.OutputMessage.*;
import static lotto.constant.Prize.*;

public class View {
    private final Validator validator = new Validator();
    public int getPrice() {
        System.out.println(GET_PRICE_MSG);
        return validator.validateAndGetLotteryPrice(readLine());
    }


    public void printBoughtLotteries(List<Lotto> lotteries) {
        int lotterySize = lotteries.size();
        System.out.println(Integer.toString(lotterySize) + BOUGHT_MSG);
        for (Lotto lotto : lotteries) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public Lotto getWinnerLottery() {
        System.out.println(GET_WINNER_LOTTERY_MSG);
        return validator.validateAndGetWinnerLottery(readLine());
    }

    public int getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER_MSG);
        return validator.validateAndGetBonusNumber(readLine());

    }

    public void printLotteryResult(int boughtPrice, HashMap<String, Integer> lotteryResult) {
        System.out.println(PRINT_RESULT_MSG);
        System.out.println(SPLITTER);
        System.out.println(FIFTH_PRIZE.getOutputMessage() + " " + FIFTH_PRIZE + " - " + lotteryResult.getOrDefault(FIFTH_PRIZE.getOutputMessage().getMsg(), 0) + "개");
        System.out.println(FOURTH_PRIZE.getOutputMessage() + " " + FOURTH_PRIZE + " - " + lotteryResult.getOrDefault(FOURTH_PRIZE.getOutputMessage().getMsg(), 0) + "개");
        System.out.println(THIRD_PRIZE.getOutputMessage() + " " + THIRD_PRIZE + " - " + lotteryResult.getOrDefault(THIRD_PRIZE.getOutputMessage().getMsg(), 0) + "개");
        System.out.println(SECOND_PRIZE.getOutputMessage() + " " + SECOND_PRIZE + " - " + lotteryResult.getOrDefault(SECOND_PRIZE.getOutputMessage().getMsg(), 0) + "개");
        System.out.println(FIRST_PRIZE.getOutputMessage() + " " + FIRST_PRIZE + " - " + lotteryResult.getOrDefault(FIRST_PRIZE.getOutputMessage().getMsg(), 0) + "개");
        double profit = getProfit(boughtPrice, lotteryResult);
        System.out.println("총 수익률은 " + String.format("%.1f", Math.round(profit * 10) / 10.0) + "%입니다.");
    }

    private double getProfit(int boughtPrice, HashMap<String, Integer> lotteryResult) {
        long profitSum = 0;
        profitSum += lotteryResult.getOrDefault(FIFTH_PRIZE.getOutputMessage().getMsg(), 0) * FIFTH_PRIZE.getValue();
        profitSum += lotteryResult.getOrDefault(FOURTH_PRIZE.getOutputMessage().getMsg(), 0) * FOURTH_PRIZE.getValue();
        profitSum += lotteryResult.getOrDefault(THIRD_PRIZE.getOutputMessage().getMsg(), 0) * THIRD_PRIZE.getValue();
        profitSum += lotteryResult.getOrDefault(SECOND_PRIZE.getOutputMessage().getMsg(), 0) * SECOND_PRIZE.getValue();
        profitSum += lotteryResult.getOrDefault(FIRST_PRIZE.getOutputMessage().getMsg(), 0) * FIRST_PRIZE.getValue();
        return (double) profitSum / boughtPrice * 100;
    }
}
