package lotto.ui;

import java.util.List;

public class Output {

	public static void output(Printable printable) {
		System.out.println(printable.print());
	}

	public static void integerList(List<Integer> numbers) {
		System.out.println(String.join(", ", numbers.toString()));
	}
}
