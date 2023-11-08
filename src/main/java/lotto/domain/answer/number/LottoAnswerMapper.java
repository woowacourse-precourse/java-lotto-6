package lotto.domain.answer.number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public final class LottoAnswerMapper {
    private final static String DELIMITER = ",";

    public static Lotto mapToLotto(String lottoAnswerInput) {
        Lotto lottoAnswer = null;
        List<Integer> answers = Arrays.stream(lottoAnswerInput.split(DELIMITER)).map(Integer::parseInt)
                .collect(Collectors.toList());
        try {
            lottoAnswer = new Lotto(answers);
        } catch (Exception ignored) {
        }
        return lottoAnswer;
    }

    public static Integer mapToBonus(String bonusInput) {
        return Integer.parseInt(bonusInput);
    }
}
