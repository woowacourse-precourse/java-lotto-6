package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    static private final int NUMBERS_SIZE = 6;
    static private final int MIN_NUMBER = 1;
    static private final int MAX_NUMBER = 45;
    static private final int AVAILABLE_NUMBER = 46;
    static private final String PROMPT_ERROR = "[ERROR]";
    static private final String PROMPT_EXCEPTION_SIZE = PROMPT_ERROR + " 로또 번호는 " + NUMBERS_SIZE + "개여야 합니다.";
    static private final String PROMPT_EXCEPTION_OUT_OF_RANGE =
            PROMPT_ERROR + " 로또 번호는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 사이의 수여야 합니다.";
    static private final String PROMPT_EXCEPTION_DUPLICATE = PROMPT_ERROR + " 로또 번호는 서로 다른 수여야 합니다.";

    private List<Lotto> lottos;
    private List<Integer> answerNumber;
    private int bonusNumber;

    public Game(int size, List<Integer> answerNumber, int bonusNumber) {
        this.lottos = new ArrayList<>();
        if (size < 1) {
            throw new IllegalArgumentException("[ERROR] 복권을 1개 이상 구매해야 합니다.");
        }
        checkSize(answerNumber);
        checkForEachNumber(answerNumber);
        checkBonusNumber(answerNumber, bonusNumber);
        for (int index = 0; index < size; ++index) {
            this.lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        this.answerNumber = answerNumber;
        this.bonusNumber = bonusNumber;
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(PROMPT_EXCEPTION_SIZE);
        }
    }

    private void checkBonusNumber(List<Integer> numbers, int bonusNumber) {
        for (int number : numbers) {
            if (bonusNumber == number) {
                throw new IllegalArgumentException(PROMPT_EXCEPTION_DUPLICATE);
            }
        }
    }

    private void checkForEachNumber(List<Integer> numbers) {
        final boolean[] checkDuplicateNumber = new boolean[AVAILABLE_NUMBER];
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(PROMPT_EXCEPTION_OUT_OF_RANGE);
            }
            if (checkDuplicateNumber[number]) {
                throw new IllegalArgumentException(PROMPT_EXCEPTION_DUPLICATE);
            }
            checkDuplicateNumber[number] = true;
        }
    }

}
