package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.constant.Constant;
import lotto.validator.Validator;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private static final String PROMPT_PRINT_LOTTOS = "개를 구매했습니다.";

    private final List<Lotto> lottos;
    private final Lotto answerNumbers;
    private final int bonusNumber;


    public Game(final int size, List<Integer> answerNumbers, final int bonusNumber) {
        Validator.validateLottoSize(size);
        Validator.validateLotto(answerNumbers);
        Validator.validateBonusNumber(answerNumbers, bonusNumber);
        this.lottos = generateLottos(size);
        this.answerNumbers = new Lotto(answerNumbers);
        this.bonusNumber = bonusNumber;
    }

    private List<Lotto> generateLottos(final int size) {
        List<Lotto> lottos = new ArrayList<>();

        System.out.println(size + PROMPT_PRINT_LOTTOS);
        for (int index = 0; index < size; ++index) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(
                    Constant.MIN_NUMBER.getValue(),
                    Constant.MAX_NUMBER.getValue(),
                    Constant.NUMBERS_SIZE.getValue()));
            lottos.add(lotto);
            System.out.println(lotto);
        }
        return lottos;
    }
}
