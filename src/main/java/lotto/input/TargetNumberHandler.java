package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import lotto.config.AppConfig;
import lotto.model.Lotto;

public class TargetNumberHandler {
    private static final String INPUT_DELIMITER = ",";

    public static List<Integer> validateTargetNumber(String input){
        try {
            String[] split = input.split(INPUT_DELIMITER, AppConfig.LOTTO_SIZE);

            List<Integer> target = Arrays.stream(split)
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();

            Lotto targetNumbersCanBeLotto = new Lotto(target);
            return target;

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 로또 정답 입력이 아닙니다.");
            String newInput = Console.readLine();
            return validateTargetNumber(newInput);
        }
    }

    public static int validateBonusNumber(String input, List<Integer> target){
        try {
            int bonus = Integer.parseInt(input.trim());
            validateBonus(bonus,target);
            return bonus;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효한 보너스 번호 입력이 아닙니다.");
            String newInput = Console.readLine();
            return validateBonusNumber(newInput, target);
        }
    }

    private static void validateBonus(int bonus, List<Integer> target) {
        if (target.contains(bonus)){
            throw new IllegalArgumentException();
        }

        if (bonus < AppConfig.LOTTO_NUMBER_MIN_RANGE || bonus > AppConfig.LOTTO_NUMBER_MAX_RANGE){
            throw new IllegalArgumentException();
        }
    }
}
