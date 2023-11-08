package lotto.view;

import static lotto.configurations.LottoConfigurations.*;
import static lotto.configurations.Messages.*;
import static lotto.configurations.SettingValues.*;

import static lotto.util.NumberConverter.*;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static class SingletonOutputView {
        private static final OutputView OUTPUT_VIEW = new OutputView();
    }

    public static OutputView getInstance() {
        return SingletonOutputView.OUTPUT_VIEW;
    }

    private OutputView() {
    }

    public void printInputPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE.get());
    }

    public void printNumberOfPurchaseMessage(int number) {
        System.out.println(number + NUMBER_OF_PURCHASE_MESSAGE.get());
    }

    public void printInputWinningNumMessage() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE.get());
    }

    public void printInputBonusNumMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE.get());
    }

    public void printLottoNumbers(List<Integer> list) {
        String listToStr;
        listToStr = Arrays.toString(list.toArray());
        System.out.println(listToStr);
    }

    public void printReceiptTitle() {
        System.out.println(RECEIPT_TITLE.get());
    }

    public void printRankingResult(Integer ranking, Integer numberOfRanking) {
        if (ranking == SECOND.get()) {
            System.out.printf(WINNING_MESSAGE_FORMAT_SECOND.get(),
                    getPoint(ranking), intToString(getReward(ranking)) + WON.get(), numberOfRanking);
            return;
        }
        System.out.printf(WINNING_MESSAGE_FORMAT_NORMAL.get(),
                getPoint(ranking), intToString(getReward(ranking)) + WON.get(), numberOfRanking);
    }

    public void printProfitRatio(Double profitRatio) {
        String profitRatioString = doubleToString(profitRatio * getPercentage(), getCutSize());
        System.out.printf(PROFIT_RATIO_MESSAGE_FORMAT.get(), profitRatioString);
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e);
    }
}
