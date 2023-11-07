package util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<String> splitString(String data, String delimiter){
        String inputData = data.replace(" ", "");
        return Arrays.stream(inputData.split(delimiter)).toList();
    }

}
