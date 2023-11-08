package lotto.util;

import java.text.DecimalFormat;

public class StringUtil {

    public String ConvertToThousandWonUnit(int number) {
        return DecimalFormat.getInstance().format(number);
    }

    public String[] ConvertStringToArray(String inputValue) {
        return inputValue.split("\\s*,\\s*");
    }

    public int[] ConvertStringArrayToIntArray(String[] array) {
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }
}

