package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputChecker {
    static int readLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());

        if(price % 1000 !=0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }
        return price;
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        validateLottoNumbers(input);

        String[] numberStrings = input.split(",");

        List<Integer> winningNumbers = Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }

    private static void validateLottoNumbers(String input) {

        String[] numberStrings = input.split(",");
        Set<Integer> distinctNumbers = new HashSet<>();

        for (String numberString : numberStrings) {
            if (!numberString.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능 합니다.");
            }

            int number = Integer.parseInt(numberString);

            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }

            if (!distinctNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력할 수 없습니다.");
            }
        }
    }

    static Integer readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }

}
