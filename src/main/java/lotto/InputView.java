package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.util.Validator;

public class InputView {
    public long inputBuyCashFromUser() {
        System.out.println("구입금액을 입력하세요");
        return inputNumericValue();
    }

    public long inputBonusNumberFromUser() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return inputNumericValue();
    }

    private long inputNumericValue() {
        String input = readLine();

        Validator.INSTANCE.numberValidate(input);

        return Long.parseLong(input);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        List<String> inputNumbers = split(readLine());
        inputNumbers.forEach(Validator.INSTANCE::numberValidate);

        return toIntegerList(inputNumbers);
    }

    private List<String> split(String input) {
        return List.of(input.split(","));
    }

    private List<Integer> toIntegerList(List<String> inputNumbers) {
        return inputNumbers.stream().map(Integer::parseInt).toList();
    }
}
