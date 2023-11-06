package lotto.view;

import static lotto.domain.Judgement.CORRECT_FIVE_WITH_BONUS;
import static lotto.domain.Judgement.amountReward;
import static lotto.domain.Judgement.reward;

import java.util.List;
import lotto.Lotto;
import lotto.constants.OutputMessage;
import lotto.domain.Numbers;

public class OutputView {
    public void outputLottosNumbers(List<Lotto> MY_LOTTOS) {
        System.out.printf(String.valueOf(OutputMessage.OUTPUT_MESSAGE_HOW_MANY_BUY_LOTTOS), MY_LOTTOS.size());
        for (Lotto lotto : MY_LOTTOS) {
            System.out.println(lotto);
        }
        System.out.println("");
    }

    public void outputTotalResult(double ratioOfReturn) {
        final String changedStr = Double.toString(ratioOfReturn);
        Numbers numbers = new Numbers();
        System.out.printf(String.valueOf(OutputMessage.OUTPUT_MESSAGE_TOTAL_REWARD), numbers.putCommaInNumber(changedStr));
    }

    public void outputResult(int MIN_CORRECT_AMOUNT, int MAX_CORRECT_AMOUNT) {
        System.out.println(OutputMessage.OUTPUT_MESSAGE);
        System.out.println("---");
        for (int i = MIN_CORRECT_AMOUNT; i <= MAX_CORRECT_AMOUNT; i++) {
            boolean isBonus = false;
            if (i == MAX_CORRECT_AMOUNT) {
                isBonus = true;
                outputCheckWithBonusResult(i-1, isBonus);
                isBonus = false;
            }
            outputCheckWithBonusResult(i, isBonus);
        }
    }

    private void outputCheckWithBonusResult(int correct, boolean bonus) {
        Numbers numbers = new Numbers();
        int correctNumber = correct;

        System.out.printf(String.valueOf(OutputMessage.OUTPUT_MESSAGE_RESULT), correctNumber);
        if (bonus) {
            System.out.print(OutputMessage.OUTPUT_MESSAGE_BONUS);
            correctNumber = CORRECT_FIVE_WITH_BONUS;
        }
        System.out.printf(String.valueOf(OutputMessage.OUTPUT_MESSAGE_MONEY),
                numbers.putCommaInNumber(Long.toString(reward.get(correctNumber))),
                amountReward.get(reward.get(correctNumber)));
        System.out.println("");
    }
}
