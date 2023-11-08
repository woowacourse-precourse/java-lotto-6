package lotto.model.domain.lotto;

import java.util.List;
import lotto.constance.GameConst;
import lotto.exception.LottoGameException;
import lotto.model.domain.result.compare.LottoAnswerCompareResult;

/**
 * 로또 게임의 정답을 저장하기 위한 클래스
 *
 * <p>로또 숫자 리스트와 더불어 보너스 숫자를 가지고 있다.</p>
 */
public class LottoAnswer extends Lotto {
    private final Integer bonusNumber;

    public LottoAnswer(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw LottoGameException.DUPLICATED_BONUS_NUMBER.makeException();
        }
    }

    /**
     * 로또를 정답과 비교해 결과를 반환한다.
     *
     * @param lotto 정답과 비교할 로또 객체
     * @return {@link lotto.model.domain.result.compare.LottoAnswerCompareResult} - 로또와 정답의 비교 결과
     */
    @Override
    public LottoAnswerCompareResult compareLotto(Lotto lotto) {
        int collectNumber = collectNumber(lotto);
        boolean collectBonus = false;
        if (collectNumber == GameConst.BONUS_CHECK_NECESSARY_NUMBER) {
            collectBonus = isCollectBonus(lotto);
        }
        return new LottoAnswerCompareResult(collectNumber, collectBonus);
    }

    private int collectNumber(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(this.getNumbers()::contains)
                .count();
    }

    private boolean isCollectBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
