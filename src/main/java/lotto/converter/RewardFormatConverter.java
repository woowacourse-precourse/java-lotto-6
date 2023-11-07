package lotto.converter;

import java.text.DecimalFormat;

public class RewardFormatConverter implements Converter<String, Integer> {

    private static final String REWARD_PATTERN = "#,###원";

    @Override
    public String convert(final Integer source) {
        DecimalFormat rewardFormat = new DecimalFormat(REWARD_PATTERN);
        return rewardFormat.format(source);
    }

}
