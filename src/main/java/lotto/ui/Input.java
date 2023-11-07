package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

	public static String string(Printable printable) {
		System.out.println(printable.print());
		return Console.readLine();
	}

	public static Integer integer(Printable printable) {
		System.out.println(printable.print());
		return Integer.parseInt(Console.readLine());
	}

	public static List<Integer> integerList(Printable printable) {
		System.out.println(printable.print());
		String response = Console.readLine();
		return Arrays.stream(
				response.split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}
