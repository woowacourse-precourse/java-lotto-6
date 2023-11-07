package lotto.model;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class InputValidator {
    public static List<Integer> getValidLottoNumbers() {
        while (true) {
            try {
                System.out.println("로또 번호 6개를 입력하세요 (1부터 45까지의 숫자):");
                List<Integer> lottoNumbers = parseInput(Console.readLine());
                validateLottoNumbers(lottoNumbers);
                return lottoNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseInput(String input) {
        List<Integer> lottoNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return lottoNumbers;
    }

    private static void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (!isWithinRange(lottoNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static boolean isWithinRange(List<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }
}
