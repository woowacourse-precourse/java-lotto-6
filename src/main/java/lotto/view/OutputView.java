package lotto.view;

import java.util.List;

import lotto.constant.OutputMessage;
import lotto.constant.LottoPrize;
import lotto.domain.LottoResult;

public class OutputView {
    
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printPriceMessage() {
        System.out.println(OutputMessage.START_MESSAGE.getMessage());
    }

    public void printPurchaseMessage(int purchaseNumber) {
        System.out.println(Integer.toString(purchaseNumber) + OutputMessage.PURCHASE_MESSAGE.getMessage());
    }
    
    public void printUserLotto(List<Integer> userLotto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < userLotto.size(); i++) {
            if (i == userLotto.size() - 1) {
                sb.append(userLotto.get(i));
                sb.append("]\n");
            }
            sb.append(userLotto.get(i));
            sb.append(", ");
        }
        System.out.print(sb.toString());
    }

    public void winnerNumberMessage() {
        System.out.println(OutputMessage.WINNING_NUMBER_MESSAGE.getMessage());
    }

    public void bonusNumberMessage() {
        System.out.println(OutputMessage.BONUS_NUMBER_MESSAGE.getMessage());
    }

    public void resultIntroductionMessage() {
        System.out.println(OutputMessage.RESULT_MESSAGE.getMessage());
    }

    public void resultMessage(LottoResult lottoResult) {
        System.out.print(LottoPrize.FIFTH_PRIZE.getNumberOfMatch() + OutputMessage.RESULT_MESSAGE2.getMessage() + OutputMessage.BRACKET_START + LottoPrize.FIFTH_PRIZE.getPrice() + OutputMessage.RESULT_MESSAGE3.getMessage() + lottoResult.getThreeCount() + OutputMessage.RESULT_MESSAGE4.getMessage());
        System.out.print(LottoPrize.FOURTH_PRIZE.getNumberOfMatch() + OutputMessage.RESULT_MESSAGE2.getMessage() + OutputMessage.BRACKET_START + LottoPrize.FOURTH_PRIZE.getPrice() + OutputMessage.RESULT_MESSAGE3.getMessage() + lottoResult.getFourCount() + OutputMessage.RESULT_MESSAGE4.getMessage());
        System.out.print(LottoPrize.THIRD_PRIZE.getNumberOfMatch() + OutputMessage.RESULT_MESSAGE2.getMessage() + OutputMessage.BRACKET_START + LottoPrize.THIRD_PRIZE.getPrice() + OutputMessage.RESULT_MESSAGE3.getMessage() + lottoResult.getFiveCount() + OutputMessage.RESULT_MESSAGE4.getMessage());
        System.out.print(LottoPrize.SECOND_PRIZE.getNumberOfMatch() + OutputMessage.RESULT_MESSAGE2.getMessage() + OutputMessage.BONUS_NUMBER_MESSAGE + OutputMessage.BRACKET_START + LottoPrize.SECOND_PRIZE.getPrice() + OutputMessage.RESULT_MESSAGE3.getMessage() + lottoResult.getFiveBonusCount() + OutputMessage.RESULT_MESSAGE4.getMessage());
        System.out.print(LottoPrize.FIRST_PRIZE.getNumberOfMatch() + OutputMessage.RESULT_MESSAGE2.getMessage() + OutputMessage.BRACKET_START + LottoPrize.FIRST_PRIZE.getPrice() + OutputMessage.RESULT_MESSAGE3.getMessage() + lottoResult.getSixCount() + OutputMessage.RESULT_MESSAGE4.getMessage());
    }

    public void resultRateMessage(double rate) {
        System.out.println(OutputMessage.RATE_MESSAGE.getMessage() + rate + OutputMessage.END_MESSAGE.getMessage());
    }
}
