package lotto.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Splitter 클래스 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class SplitterTest {
    @Test
    public void testSplitString() {
        String string = "1,2,3,4,5";
        String delimiter = ",";

        List<String> expected = Arrays.asList("1", "2", "3", "4", "5");

        List<String> actual = Splitter.splitString(string, delimiter);

        assertEquals(expected, actual);
    }

}
