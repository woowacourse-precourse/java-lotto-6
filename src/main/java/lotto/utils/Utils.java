package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {
	
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
}
