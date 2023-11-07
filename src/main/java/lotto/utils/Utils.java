package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {
	
	private static final int SAME = 1;
	private static final int NOT_SAME = 0;
	
	public static void sortListAscendingOrder(List<Integer> numbers) {
		Collections.sort(numbers);
	}

	public static List<Integer> generateUniqueNumberListInRange(int startInclusive, int endInclusive, int count) {
		return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
	}
	
	public static List<String> splitString(String input) {
		return Stream.of(input.split(","))
				.map(String::trim)
				.collect(Collectors.toList());
	}
	
	public static List<Integer> stringToIntegerList(String input) {
		return splitString(input).stream()
				.map(Integer::valueOf)
				.collect(Collectors.toList());
	}
	
	public static int countIfSame(int num1, List<Integer> list2) {
		if ( list2.contains(num1) ) {
			return SAME;
		}
		return NOT_SAME;
	}
	
	public static int countSameNumbers(List<Integer> list1, List<Integer> list2) {
		int count = 0;
		for (int number : list1) {
			count += countIfSame(number, list2);
		}
		return count;
	}

}
