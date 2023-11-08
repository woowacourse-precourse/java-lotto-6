package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String ONE_SPACE_BAR = " ";
    private static final String NO_SPACE_BAR = "";

    public static List<Positive> withOutSpaceBarAndSplitAndPositives(String text){
        if(isBlank(text)){
            throw new IllegalArgumentException("빈 값이면 안됩니다.");
        }
        return toPositives(split(withoutSpaceBar(text)));
    }

    public static List<String> split(String text){
        return Arrays.stream(text.split(",")).toList();
    }

    public static List<Positive> toPositives(List<String> values){
        List<Positive> numbers = new ArrayList<>();
        for(int i=0; i<values.size(); i++){
            numbers.add(new Positive(values.get(i)));
        }
        return numbers;
    }
    private static boolean isBlank(String text){
        return text == null || text.isEmpty();
    }
    public static String withoutSpaceBar (String text){
        return text.replaceAll(ONE_SPACE_BAR, NO_SPACE_BAR);
    }


}
