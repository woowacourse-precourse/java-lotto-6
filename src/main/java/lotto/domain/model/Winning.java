package lotto.domain.model;

import java.util.List;

import static lotto.domain.constant.ErrorConst.WINNING_HAS_DUPLICATE;
import static lotto.domain.validation.Validator.checkCondition;

public class Winning {

    private final Lotto main;
    private final Bonus bonus;

    public Winning(Lotto main, Bonus bonus) {
        validate(main, bonus);
        this.main = main;
        this.bonus = bonus;
    }

    /**
     * 로또와 당첨 번호가 얼마나 일치하는지 판단한다.
     *
     * @param lotto 발행한 로또
     * @return CorrectResult 객체
     *      <p>sameCount: 당첨 번호 6개와 발행한 로또 번호 6개중 일치하는 번호의 개수(int)<br>
     *      existBonus: 발행한 로또 번호 6개 중 보너스 번호가 있는지 여부(boolean)
     */
    public CorrectResult countSameNumber(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningMainNumbers = main.getNumbers();
        int winningBonusNumber = bonus.getNumber();

        int sameCount = Math.toIntExact(
                lottoNumbers.stream()
                        .filter(winningMainNumbers::contains)
                        .count()
        );
        boolean existBonus = lottoNumbers.contains(winningBonusNumber);

        return new CorrectResult(sameCount, existBonus);
    }

    private void validate(Lotto main, Bonus bonus) {
        List<Integer> winningMainNumbers = main.getNumbers();
        int winningBonusNumber = bonus.getNumber();

        checkCondition(winningMainNumbers.stream().anyMatch(
                        number -> number == winningBonusNumber),
                WINNING_HAS_DUPLICATE);
    }
}
