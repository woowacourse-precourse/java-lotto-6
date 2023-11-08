package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {
	
	private static final int SAME = 1;
	private static final int NOT_SAME = 0;
	private static final double ROUNT_ONE = 10.0;
	
	public static void sortListAscendingOrder(List<Integer> numbers) {
		numbers.sort(null);
	}

	public static ArrayList<Integer> generateUniqueNumberListInRange(int startInclusive, int endInclusive, int count) {
		List<Integer> RandomNumbers = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.addAll(RandomNumbers);
		return numbers;
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
	
	public static double rounding(double number) {
		double roundedNumber = Math.round(number*ROUNT_ONE) / ROUNT_ONE ;
		return roundedNumber;
	}

}
