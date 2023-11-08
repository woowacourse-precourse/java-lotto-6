package lotto;

import java.util.ArrayList;
import java.util.List;

public class convertDataType {

	public static int stringToInt(String num){
		try {
			int convertedNumber = Integer.parseInt(num);
			return convertedNumber;
		}
		catch (NumberFormatException e){
			System.out.println("[ERROR] 숫자만 입력해주세요.");
			throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
		}

	}

	public static List<Integer> stringToList(String nums){
		String[] inputArray = nums.split(",");
		List<Integer> convertedList = new ArrayList<>();
		for (String num : inputArray){
			int lottoNum = stringToInt(num);
			convertedList.add(lottoNum);
		}
		return convertedList;
	}
}
