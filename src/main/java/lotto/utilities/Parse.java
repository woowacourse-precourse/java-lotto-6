package lotto.utilities;

import java.util.ArrayList;
import java.util.List;

public class Parse {
	public static int parseStringToInt(String str) {
		return Integer.parseInt(str);
	}
	
	public static String[] splitString(String str, String splitter) {
		String[] splitted = str.split(splitter);	
		return splitted;
	}
	
	public static List<Integer> parseStringToList(String stringArray[]) {
		List<Integer> list = new ArrayList<Integer>();
		for (String str : stringArray) {
			list.add(parseStringToInt(str));
		}
		return list;
	}
}