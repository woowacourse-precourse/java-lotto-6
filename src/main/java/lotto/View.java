package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.util.Validator;

public class View {
    public long inputNumericValue() {
        String input = readLine();

        Validator.INSTANCE.numberValidate(input);

        return Long.parseLong(input);
    }

    public void printUserLottos(List<String> lottoMessages, long buyAmount) {
        System.out.println();
        System.out.println(buyAmount + "개를 구매했습니다.");
        lottoMessages.forEach(this::printLotto);
        System.out.println();
    }

    private void printLotto(String lottoMessage) {
        System.out.println(lottoMessage);
    }

    public List<Integer> inputWinningNumbers() {
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
