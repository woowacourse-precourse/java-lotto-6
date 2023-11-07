package lotto.domain;

import static lotto.constants.LottoConfig.*;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {
    // TODO: 랜덤 숫자를 생성하고 중복 여부 확인하는 클래스
    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                RANDOM_RANGE_MIN_NUMBER.getValue(),
                RANDOM_RANGE_MAX_NUMBER.getValue(),
                NUMBER_LENGTH.getValue()
        );
    }

    public boolean isUniqueNumber(List<Integer> numbers) {
        return numbers
                .stream()
                .distinct()
                .toList().size() == NUMBER_LENGTH.getValue();
    }
}
