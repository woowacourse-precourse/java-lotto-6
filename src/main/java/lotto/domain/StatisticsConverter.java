package lotto.domain;

import lotto.domain.dto.Statistics;
import lotto.io.OutputConverter;

import java.util.Arrays;

public final class StatisticsConverter implements OutputConverter<Statistics> {

    @Override
    public String convert(Statistics statistics) {
        StringBuilder output = new StringBuilder();
        Arrays.stream(Result.values())
                .forEach(it -> {
                    output.append(oneStatisticsToString(it, statistics));
                });
        return output.toString();
    }

    private String oneStatisticsToString(Result it, Statistics statistics) {
        StringBuilder temp = new StringBuilder();

        int count = statistics.count(it);

        temp.append(it.getContent());
        temp.append(String.format(Constant.WON.value, it.getReward()));
        temp.append(String.format(Constant.NUM.value, count));

        return temp.toString();
    }

    enum Constant{
        NEW_LINE("\n"),
        WON(" (%,d원)"),
        NUM(" - %d개" + NEW_LINE.value),
        ;

        String value;

        Constant(String value) {
            this.value = value;
        }
    }
}
