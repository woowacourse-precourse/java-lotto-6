import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RegexTest {
    @Test
    void numericRegexTest1(){
        Pattern pattern = Pattern.compile("^[\\d]*$");
        Matcher matcher = pattern.matcher("1234");

        Assertions.assertThat(matcher.matches())
                .isTrue();
    }

    @Test
    void numericRegexTest2(){
        Pattern pattern = Pattern.compile("^[\\d]+000$");
        Matcher matcher = pattern.matcher("1234000");

        Assertions.assertThat(matcher.matches())
                .isTrue();
    }

    @Test
    void numericRegexTest3(){
        Pattern pattern = Pattern.compile("^[\\d]+000$");
        Matcher matcher = pattern.matcher("1234200");

        Assertions.assertThat(matcher.matches())
                .isFalse();
    }
}
