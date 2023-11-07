package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int requestPurchaseOfLotto() {
        printPurchaseMessage();
        String input = readMessage();

        try {
            int price = Integer.valueOf(input);
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력 가능합니다.");
        }
    }

    private void printPurchaseMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private String readMessage() {
        String message = Console.readLine();
        System.out.println();
        return message;
    }

    public List<Integer> requestWinningLottoNumbers() {
        printWinningLottoNumbersInputMessage();
        String input = readMessage();

        List<String> strNumbers = Arrays.asList(input.split(","));
        List<Integer> lottoNumbers = new ArrayList<>();
        try {
            lottoNumbers = strNumbers.stream()
                    .map((strNumber) -> Integer.valueOf(strNumber))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 쉼표(,) 값으로 입력되어야 합니다.");
        }
        return lottoNumbers;
    }

    private void printWinningLottoNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public int requestBonusNumber() {
        printBonusNumberMessage();
        String input = readMessage();

        try {
            int bonusNumber = Integer.valueOf(input);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }
    }

    private void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
