import lotto.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.*;

public class StudyTest {
    @Test
    void testIntegerCompare(){
        Integer big = 1000000000;
        Integer small = 4000000;
        Assertions.assertThat(small.compareTo(big)).isEqualTo(-1);
    }

    @Test
    void decimalFormatTest(){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        Long num = 100000L;
        Assertions.assertThat(decimalFormat.format(num)).isEqualTo("100,000");
    }

    @Test
    void 배열이_가변인자의_인수가_되는지_확인(){
        int arg = 1;
        Integer[] array = new Integer[10];
        for(int i=0;i<10;i++){
            array[i] = i;
        }
        int newList = variableArgumentFunc(arg,array);
        Assertions.assertThat(newList).isEqualTo(46);
    }
    int variableArgumentFunc(int argument, Integer... variableArgument){
        List<Integer> list = new ArrayList<>(Arrays.asList(variableArgument));

        list.add(argument);

        return list.stream().mapToInt(num->num).sum();
    }

    @Test
    void map_test(){
        Map<String,Integer> map = new HashMap<>();
        map.put("nuri",0);
        map.put("kyoJune",1);
        Set<String> set = map.keySet();
        Assertions.assertThat(set).contains("kyoJune","nuri");
    }

    @Test
    void 실수형_String_format(){
        double num = 515959.5554523;
        String formatting = String.format("%1$,.2f",515959.5554523);
        Assertions.assertThat(formatting).isEqualTo("515,959.56");
    }

}
