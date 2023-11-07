package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.constant.Constant;
import lotto.constant.ErrorMessage;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private final List<Lotto> lottos;
    private final List<Integer> answerNumber;
    private final int bonusNumber;

    public Game(int size, List<Integer> answerNumber, int bonusNumber) {
        this.lottos = new ArrayList<>();
        if (size < 1) {
            throw new IllegalArgumentException("[ERROR] 복권을 1개 이상 구매해야 합니다.");
        }
        checkSize(answerNumber);
        checkForEachNumber(answerNumber);
        checkBonusNumber(answerNumber, bonusNumber);
        for (int index = 0; index < size; ++index) {
            this.lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(Constant.MIN_NUMBER.getValue(),
                    Constant.MAX_NUMBER.getValue(),
                    Constant.NUMBERS_SIZE.getValue())));
        }
        this.answerNumber = answerNumber;
        this.bonusNumber = bonusNumber;
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != Constant.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.PROMPT_EXCEPTION_SIZE.getMessage());
        }
    }

    private void checkBonusNumber(List<Integer> numbers, int bonusNumber) {
        for (int number : numbers) {
            if (bonusNumber == number) {
                throw new IllegalArgumentException(ErrorMessage.PROMPT_EXCEPTION_DUPLICATE.getMessage());
            }
        }
    }

    private void checkForEachNumber(List<Integer> numbers) {
        final boolean[] checkDuplicateNumber = new boolean[Constant.AVAILABLE_NUMBER.getValue()];
        for (int number : numbers) {
            if (number < Constant.MIN_NUMBER.getValue() || number > Constant.MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.PROMPT_EXCEPTION_OUT_OF_RANGE.getMessage());
            }
            if (checkDuplicateNumber[number]) {
                throw new IllegalArgumentException(ErrorMessage.PROMPT_EXCEPTION_DUPLICATE.getMessage());
            }
            checkDuplicateNumber[number] = true;
        }
    }

}
