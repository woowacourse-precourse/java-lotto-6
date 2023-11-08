package lotto.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.constance.GameConst;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RegexLearningTest {
    private static final Pattern answerPattern = Pattern.compile(
            String.format("^([\\d]+%s){5}+[\\d]$", GameConst.DELIMITER));

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5,", ",1,2,3,4,5", "1,2,3,4,5", "1.1, 2, 3, 4, 5, 6"})
    public void temp(String input) {
        //given
        //when
        Matcher matcher = answerPattern.matcher(input.replaceAll(" ", ""));

        //then
        Assertions.assertThat(matcher.matches())
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1,24,13,4,5,6"})
    public void normal(String input) {
        //given
        //when
        Matcher matcher = answerPattern.matcher(input.replaceAll(" ", ""));

        //then
        Assertions.assertThat(matcher.matches())
                .isTrue();
    }

}