package study.prototype;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.config.AppConfig;
import lotto.domain.Lotto;

public class TargetNUmberHandlerPrototype {

    private static final String INPUT_DELIMITER = ",";
    private static final String TARGET_INFO_MESSAGE = "정답인 6개의 로또번호를 입력해주세요.";
    private static final String TARGET_ERROR_MESSAGE = "[ERROR] 유효한 로또 정답 입력이 아닙니다.";
    private static final String BONUS_INFO_MESSAGE = "6개의 번호와 중복되지 않는 보너스번호를 입력해주세요.";
    private static final String BONUS_ERROR_MESSAGE = "[ERROR] 유효한 보너스 번호 입력이 아닙니다.";

    public Lotto inputToTargetLotto() {
        System.out.println(TARGET_INFO_MESSAGE);
        String input = Console.readLine();
        Lotto lotto = validateTargetNumber(input);
        return lotto;
    }

    private Lotto validateTargetNumber(String input) {
        try {
            String[] split = input.split(INPUT_DELIMITER, AppConfig.LOTTO_SIZE);
            List<Integer> target = getIntegerList(split);
            return new Lotto(target);

        } catch (NumberFormatException e) {
            System.out.println(TARGET_ERROR_MESSAGE);
            String newInput = Console.readLine();
            return validateTargetNumber(newInput);
        }
    }

    private List<Integer> getIntegerList(String[] split) {
        return Arrays.stream(split)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    public int inputToBonusNumber(Lotto target) {
        System.out.println(BONUS_INFO_MESSAGE);
        String input = Console.readLine();
        int bonus = validateBonusNumber(input, target);
        return bonus;
    }

    private int validateBonusNumber(String input, Lotto target) {
        try {
            int bonus = Integer.parseInt(input.trim());
            validateBonus(bonus, target);
            return bonus;

        } catch (IllegalArgumentException e) {
            System.out.println(BONUS_ERROR_MESSAGE);
            String newInput = Console.readLine();
            return validateBonusNumber(newInput, target);
        }
    }

    private void validateBonus(int bonus, Lotto target) {
        if (target.contains(bonus)) {
            throw new IllegalArgumentException();
        }

        if (bonus < AppConfig.LOTTO_NUMBER_MIN_RANGE || bonus > AppConfig.LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException();
        }
    }
}
