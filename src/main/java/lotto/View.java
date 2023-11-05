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

    public void printUserLottos(List<Lotto> userLottos) {
        System.out.println(userLottos.size() + "개를 구매했습니다.");
        userLottos.forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbersMessage());
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
