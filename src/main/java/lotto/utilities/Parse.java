package lotto.utilities;

import static lotto.system.ExceptionMessage.COMMON_VALIDATION_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class Parse {
	public static int parseStringToInt(String str) {
		int n;
		try {
			n = Integer.parseInt(str);
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException(COMMON_VALIDATION_ERROR_MESSAGE.getMessage());
		}
		return n;
	}
	
	public static String[] splitString(String str, String splitter) {
		String[] splitted = str.split(splitter);	
		return splitted;
	}
	
	public static List<Integer> parseStringToIntArray(String stringArray[]) {
		List<Integer> intArray = new ArrayList<Integer>();
		for (String str : stringArray) {
			intArray.add(parseStringToInt(str));
		}
		return intArray;
	}
}