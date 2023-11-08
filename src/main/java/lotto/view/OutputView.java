package lotto.view;

import java.text.DecimalFormat;
import java.util.List;

import lotto.constant.OutputMessage;
import lotto.constant.LottoPrize;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class OutputView {
    
    DecimalFormat df = new DecimalFormat("###,###.##");
    
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printPriceMessage() {
        System.out.println(OutputMessage.START_MESSAGE.getMessage());
    }

    public void printPurchaseMessage(int purchaseNumber) {
        System.out.println("\n" + Integer.toString(purchaseNumber) + OutputMessage.PURCHASE_MESSAGE.getMessage());
    }
    
    public void printUserLotto(List<Lotto> userLotto) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : userLotto) {
            createUserLotto(sb, lotto.getNumbers());
        }
        System.out.print(sb.toString());
    }

    public void createUserLotto(StringBuilder sb, List<Integer> numbers) {
        sb.append("[");
        for (int i = 0; i < numbers.size()-1; i++) {
            sb.append(numbers.get(i));
            sb.append(", ");
        }
        sb.append(numbers.get(numbers.size()-1) + "]\n");
    }

    public void winnerNumberMessage() {
        System.out.println("\n" + OutputMessage.WINNING_NUMBER_MESSAGE.getMessage());
    }

    public void bonusNumberMessage() {
        System.out.println("\n" + OutputMessage.BONUS_NUMBER_MESSAGE.getMessage());
    }

    public void resultIntroductionMessage() {
        System.out.println("\n" + OutputMessage.RESULT_MESSAGE.getMessage());
    }

    public void resultMessage(LottoResult lottoResult) {
        System.out.println(LottoPrize.FIFTH_PRIZE.getNumberOfMatch() + OutputMessage.RESULT_MESSAGE2.getMessage() + OutputMessage.BRACKET_START.getMessage() + df.format(LottoPrize.FIFTH_PRIZE.getPrice()) + OutputMessage.RESULT_MESSAGE3.getMessage() + lottoResult.getThreeCount() + OutputMessage.RESULT_MESSAGE4.getMessage());
        System.out.println(LottoPrize.FOURTH_PRIZE.getNumberOfMatch() + OutputMessage.RESULT_MESSAGE2.getMessage() + OutputMessage.BRACKET_START.getMessage() + df.format(LottoPrize.FOURTH_PRIZE.getPrice()) + OutputMessage.RESULT_MESSAGE3.getMessage() + lottoResult.getFourCount() + OutputMessage.RESULT_MESSAGE4.getMessage());
        System.out.println(LottoPrize.THIRD_PRIZE.getNumberOfMatch() + OutputMessage.RESULT_MESSAGE2.getMessage() + OutputMessage.BRACKET_START.getMessage() + df.format(LottoPrize.THIRD_PRIZE.getPrice()) + OutputMessage.RESULT_MESSAGE3.getMessage() + lottoResult.getFiveCount() + OutputMessage.RESULT_MESSAGE4.getMessage());
        System.out.println(LottoPrize.SECOND_PRIZE.getNumberOfMatch() + OutputMessage.RESULT_MESSAGE2.getMessage() + OutputMessage.RESULT_MESSAGE5.getMessage() + OutputMessage.BRACKET_START.getMessage() + df.format(LottoPrize.SECOND_PRIZE.getPrice()) + OutputMessage.RESULT_MESSAGE3.getMessage() + lottoResult.getFiveBonusCount() + OutputMessage.RESULT_MESSAGE4.getMessage());
        System.out.println(LottoPrize.FIRST_PRIZE.getNumberOfMatch() + OutputMessage.RESULT_MESSAGE2.getMessage() + OutputMessage.BRACKET_START.getMessage() + df.format(LottoPrize.FIRST_PRIZE.getPrice()) + OutputMessage.RESULT_MESSAGE3.getMessage() + lottoResult.getSixCount() + OutputMessage.RESULT_MESSAGE4.getMessage());
    }

    public void resultRateMessage(String rate) {
        System.out.print(OutputMessage.RATE_MESSAGE.getMessage() + rate.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + OutputMessage.END_MESSAGE.getMessage());
    }
}
