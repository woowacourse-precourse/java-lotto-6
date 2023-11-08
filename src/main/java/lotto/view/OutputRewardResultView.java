package lotto.view;

import lotto.domain.Rate;
import lotto.domain.Reward;
import lotto.domain.RewardResult;

import java.util.Arrays;

import static lotto.constant.message.OutputMessage.*;

public class OutputRewardResultView {
    public static void outputRewardResult(RewardResult rewardResult, Rate rate) {
        System.out.println(TOP_MESSAGE);
        Arrays.stream(Reward.values())
                .filter(reward -> !reward.equals(Reward.LOSE))
                .forEach(reward -> System.out.println(getPrintResultPrize(reward, rewardResult)));
        System.out.printf((RATE_OF_RETURN) + NEWLINE, rate.getRate());
    }

    private static String getPrintResultPrize(Reward reward, RewardResult rewardResult) {
        if (reward == Reward.SECOND) {
            return String.format(SECOND_RESULT_MESSAGE
                    , reward.getMatchLottoNumber()
                    , String.format("%,d", reward.getMoney())
                    , rewardResult.getRewardCount(reward));
        }

        return String.format(RESULT_MESSAGE
                , reward.getMatchLottoNumber()
                , String.format("%,d", reward.getMoney())
                , rewardResult.getRewardCount(reward));
    }
}
