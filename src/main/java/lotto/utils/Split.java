package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Split implements StringUtils {

    private static final String COMMAS_SIGNAL = ",";
    private final String value;

    public Split(String value) {
        this.value = value;
    }

    @Override
    public List<String> getListValue() {
        return split(this.value);
    }

    private List<String> split(String value) {
        return Arrays.asList(value.split(COMMAS_SIGNAL));}
}
