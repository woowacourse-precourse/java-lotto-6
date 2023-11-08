package lotto.domain.answer.number;

import static lotto.domain.policy.LottoNumberRangePolicy.END_RANGE;
import static lotto.domain.policy.LottoNumberRangePolicy.START_RANGE;
import static lotto.domain.utils.CustomValidator.validate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class LottoAnswerValidator {
    private final static String LOTTO_ANSWER_REGEX = "^[1-9]+(,[1-9]+){5}$";
    private final static String BONUS_REGEX = "^[1-9]\\d*$";

    // 당첨번호 입력 검즘 :: 길이, 각 숫자 별 범위
    public static Consumer<String> validateLottoAnswerInput = lottoAnswerInput -> {
        // 당첨번호 길이
        LottoAnswerValidator.validSize.accept(lottoAnswerInput);

        // 각 숫자 별 범위
        List<Integer> answers = Arrays.stream(lottoAnswerInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        LottoAnswerValidator.validNumberRange.accept(answers);
    };

    // 당첨 번호 길이 검증 메서드
    static Consumer<String> validSize = lottoAnswerInput -> validate(
            !Pattern.matches(LOTTO_ANSWER_REGEX, lottoAnswerInput), "당첨번호는 6개만 입력 가능합니다.");

    // 각 숫자 별 범위 검증 메서드
    static Consumer<List<Integer>> validNumberRange = answers -> {
        for (Integer answer : answers) {
            validate(START_RANGE.getRange() > answer || answer > END_RANGE.getRange(),
                    "당첨번호는 1이상 45이하의 정수만 입력할 수 있습니다.");
        }
    };

    // 보너스 번호 입력 검증
    public static Consumer<String> validateBonusInput = bonusInput -> {
        validate(!Pattern.matches(BONUS_REGEX, bonusInput), "보너스 번호는 정수만 입력가능합니다.");
        int bonus = Integer.parseInt(bonusInput);
        validate(bonus < START_RANGE.getRange() || bonus > END_RANGE.getRange(), "보너스 번호의 범위는 1이상, 45이하입니다.");
    };
}
