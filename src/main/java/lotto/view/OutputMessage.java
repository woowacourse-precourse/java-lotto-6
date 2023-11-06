package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

public final class OutputMessage {
    public static void totalLottoMessage(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public static void viewLottoNumbers(List<Integer> numbers) {
        String result = numbers.stream()
                .map(Object::toString) // Convert integers to strings
                .collect(Collectors.joining(", ", "[", "]")); // Join strings with comma and wrap with []
        System.out.println(result);
    }

}
