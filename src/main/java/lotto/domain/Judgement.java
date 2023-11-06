package lotto.domain;


import java.util.HashMap;
import java.util.Map;

public class Judgement {
    private final int CORRECT_THREE = 3;
    private final int CORRECT_FOUR = 4;
    private final int CORRECT_FIVE = 5;
    private final int CORRECT_SIX = 6;
    public static final int CORRECT_FIVE_WITH_BONUS = 999;
    private final int REWARD_CORRECT_THREE = 5000;
    private final int REWARD_CORRECT_FOUR = 50000;
    private final int REWARD_CORRECT_FIVE = 1500000;
    private final int REWARD_CORRECT_FIVE_WITH_BONUS = 30000000;
    private final int REWARD_CORRECT_SIX = 2000000000;
    private int amountOfCorrect;

    public static Map<Integer, Integer> reward;
    public static Map<Integer, Integer> amountReward;

    public Judgement() {
        this.reward = resetReward();
        this.amountReward = resetAmountReward();
    }

    public void setCorrectNumber(int amountOfCorrect) {
        this.amountOfCorrect = amountOfCorrect;
    }

    private Map<Integer, Integer> resetReward() {
        Map<Integer, Integer> reward = new HashMap<>();

        reward.put(CORRECT_THREE, REWARD_CORRECT_THREE);
        reward.put(CORRECT_FOUR, REWARD_CORRECT_FOUR);
        reward.put(CORRECT_FIVE, REWARD_CORRECT_FIVE);
        reward.put(CORRECT_FIVE_WITH_BONUS, REWARD_CORRECT_FIVE_WITH_BONUS);
        reward.put(CORRECT_SIX, REWARD_CORRECT_SIX);

        return reward;
    }

    private Map<Integer, Integer> resetAmountReward() {
        Map<Integer, Integer> amountReward = new HashMap<>();

        amountReward.put(REWARD_CORRECT_THREE, 0);
        amountReward.put(REWARD_CORRECT_FOUR, 0);
        amountReward.put(REWARD_CORRECT_FIVE, 0);
        amountReward.put(REWARD_CORRECT_FIVE_WITH_BONUS, 0);
        amountReward.put(REWARD_CORRECT_SIX, 0);

        return amountReward;
    }

    private void plusAmount(int reward) {
        amountReward.replace(reward, amountReward.get(reward)+1);
    }

    public int getReward(int correctNumbers) {
        int payBack = reward.get(correctNumbers);
        plusAmount(payBack);
        return payBack;
    }
}
