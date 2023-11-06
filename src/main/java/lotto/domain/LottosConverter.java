package lotto.domain;

import lotto.io.OutputConverter;

import java.util.List;
import java.util.StringJoiner;

public final class LottosConverter implements OutputConverter<List<List<Integer>>> {
    @Override
    public String convert(List<List<Integer>> lottos) {
        StringBuilder output = new StringBuilder();
        lottos.forEach(lotto -> {
                    output.append(Constant.START_PREFIX.value);
                    StringJoiner temp = new StringJoiner(Constant.DELIMITER.value);
                    lotto.forEach(number -> temp.add(number.toString()));
                    output.append(temp);
                    output.append(Constant.END_PREFIX.value);
                });
        return output.toString();
    }

    enum Constant {
        NEW_LINE("\n"),
        START_PREFIX("["),
        DELIMITER(", "),
        END_PREFIX("]" + NEW_LINE.value),
        ;

        private final String value;

        Constant(String value) {
            this.value = value;
        }
    }
}
