package lotto.configurations;

public class LottoConfigurations {
    private static final int[] rewards = {
            SettingValues.REWARD_OF_FAIL.get(), SettingValues.REWARD_OF_FIRST.get(),
            SettingValues.REWARD_OF_SECOND.get(), SettingValues.REWARD_OF_THIRD.get(),
            SettingValues.REWARD_OF_FOURTH.get(), SettingValues.REWARD_OF_FIFTH.get()};
    private static final int[] points = {
            SettingValues.POINT_OF_FAIL.get(), SettingValues.POINT_OF_FIRST.get(),
            SettingValues.POINT_OF_SECOND.get(), SettingValues.POINT_OF_THIRD.get(),
            SettingValues.POINT_OF_FOURTH.get(), SettingValues.POINT_OF_FIFTH.get()};
    private static final int CUT_SIZE = 1;
    private static final double PERCENTAGE = 100.0;
    private static final String SEPARATOR = ",";

    public static int getReward(int i) {
        return rewards[i];
    }

    public static int getPoint(int i) {
        return points[i];
    }

    public static double getPercentage() {
        return PERCENTAGE;
    }

    public static String getSeparator() {
        return SEPARATOR;
    }

    public static int getCutSize() {
        return CUT_SIZE;
    }
}
