package lotto.v3.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoWinningNumbersView {
    public List<Integer> requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분)");
        return parseWinningNumbers(Console.readLine());
    }

    private List<Integer> parseWinningNumbers(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 비어있습니다.");
        }

        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분하여 입력해야 합니다.");
        }

        List<String> splitInput = Stream.of(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        if (splitInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 쉼표로 구분하여 입력해야 합니다.");
        }

        try {
            return splitInput.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");
        }
    }
}
