package lotto.domain;

import lotto.domain.dto.Statistics;
import lotto.io.OutputConverter;

import java.util.Arrays;

public final class StatisticsConverter implements OutputConverter<Statistics> {

    @Override
    public String convert(Statistics statistics) {
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
