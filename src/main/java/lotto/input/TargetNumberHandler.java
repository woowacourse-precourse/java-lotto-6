package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import lotto.config.AppConfig;

public class TargetNumberHandler {
    private static final String INPUT_DELIMITER = ",";
    private static final int TARGET_NUMBER_SIZE = 6;
    private static final int BONUS_NUMBER_SIZE = 1;

    public List<Integer> validateTargetNumber(String input){
        try {
            String[] split = input.split(INPUT_DELIMITER, TARGET_NUMBER_SIZE);
            IntStream intStream = convertIntStream(split);

            if (intStream.count() != TARGET_NUMBER_SIZE) {
                throw new NumberFormatException();
            }
            return intStream.boxed().toList();

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 로또 정답 입력이 아닙니다.");
            String newInput = Console.readLine();
            return validateTargetNumber(newInput);
        }
    }
    private static IntStream convertIntStream(String[] split) {
        return  Arrays.stream(split)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .filter(num -> AppConfig.LOTTO_NUMBER_MIN_RANGE <= num)
                .filter(num -> num <= AppConfig.LOTTO_NUMBER_MAX_RANGE)
                .distinct();
    }

    public int validateBonusNumber(String input, List<Integer> target){
        try {
            String[] strings = {input};
            IntStream intStream = convertIntStream(strings);
            return intStream.filter(num -> !target.contains(num)).findAny().getAsInt();

        } catch (NoSuchElementException e) {
            System.out.println("[ERROR] 유효한 보너스 번호 입력이 아닙니다.");
            String newInput = Console.readLine();
            return validateBonusNumber(newInput, target);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효한 보너스 번호 입력이 아닙니다.");
            String newInput = Console.readLine();
            return validateBonusNumber(newInput, target);
        }
    }

}
