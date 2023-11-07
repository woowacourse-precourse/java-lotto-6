package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.constant.Constant;
import lotto.validator.Validator;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private final List<Lotto> lottos;
    private final List<Integer> answerNumbers;
    private final int bonusNumber;

    public Game(int size, List<Integer> answerNumbers, int bonusNumber) {
        this.lottos = new ArrayList<>();

        Validator.validateLottoSize(size);
        Validator.validateLotto(answerNumbers);
        Validator.validateBonusNumber(answerNumbers, bonusNumber);
        for (int index = 0; index < size; ++index) {
            this.lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                    Constant.MIN_NUMBER.getValue(),
                    Constant.MAX_NUMBER.getValue(),
                    Constant.NUMBERS_SIZE.getValue())));
        }
        this.answerNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
    }
}
