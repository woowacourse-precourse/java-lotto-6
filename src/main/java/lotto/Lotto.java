package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해 주세요.");
        }
        if (Collections.max(numbers) > 45 || Collections.min(numbers) < 1) {
            throw new IllegalArgumentException("[ERROR] 1과 45사이의 숫자만 입력해 주세요.");
        }
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복 되지 않도록 입력해 주세요.");
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto[] makeLottoNumbers(int size) {
        Lotto[] lottos = new Lotto[size];
        for (int i = 0; i < size; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            sortNumbers(lottoNumbers);
            lottos[i] = new Lotto(lottoNumbers);
        }
        return lottos;
    }

    public static List<Integer> sortNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static void printLottos(Lotto[] lottos) {
        for (int i = 0; i < lottos.length; i++) {
            System.out.println(lottos[i].numbers);
        }
    }

    public static void compareTo(Lotto[] lottos, Lotto inputLotto, int bonusNumber) {
        for (int i = 0; i < lottos.length; i++) {
            int count = countMatched(lottos[i], inputLotto);
            if (count == 5) {
                boolean test = checkBonusNumber(lottos[i], bonusNumber);
            }

        }
    }

    public static int countMatched(Lotto lotto, Lotto inputLotto) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (inputLotto.numbers.contains(lotto.numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.numbers.contains(bonusNumber);
    }

}
