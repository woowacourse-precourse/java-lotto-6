package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPLIT_CONDITION = ",";

    public int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> lottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoNumbers = Console.readLine();

        String[] numbers = splitNumbers(lottoNumbers);
        return saveLotto(numbers);
    }

    public int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        return Integer.parseInt(Console.readLine());
    }

    private List<Integer> saveLotto(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String[] splitNumbers(String input) {
        return input.split(SPLIT_CONDITION);
    }
}
