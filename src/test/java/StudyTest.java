import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

public class StudyTest {
    @Test
    void testIntegerCompare(){
        Integer big = 1000000000;
        Integer small = 4000000;
        Assertions.assertThat(big.compareTo(small)).isEqualTo(-1);
    }

    @Test
    void decimalFormatTest(){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        Long num = 100000L;
        Assertions.assertThat(decimalFormat.format(num)).isEqualTo("100,000");
    }
}
