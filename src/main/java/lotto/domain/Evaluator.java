package lotto.domain;

import lotto.exception.DuplicateNumbersLottoException;

public class Evaluator {
    private Lotto winningLotto;
    private Integer bonus;
    private Prize result;

    public Evaluator(Lotto winningLotto, Integer bonusNumber) {

        validateDuplicate(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonus = bonusNumber;
        this.result = new Prize();

    }

    public void judgeLottoTicket(LottoTicket lottoTicket) {

        for (Lotto candidate : lottoTicket.getLottos()) {

            PrizeRankConstants rank = judgeLotto(candidate);

            result.increaseCountOf(rank);

        }

    }

    public Prize getResult() {
        return result;
    }


    private PrizeRankConstants judgeLotto(Lotto candidate) {

        Integer numberOfMatched = countHowManyMatch(candidate);
        boolean isBonusContained = candidate.contains(bonus);

        if (isBonusContained) {
            numberOfMatched++;
        }

        return PrizeRankConstants.getRankConstant(numberOfMatched, isBonusContained);
    }

    private Integer countHowManyMatch(Lotto candidate) {
        return (int) winningLotto.getNumbers()
                .stream()
                .filter(number -> candidate.contains(number))
                .count();
    }

    private void validateDuplicate(Lotto winningLotto, Integer bonusNumber) {
        boolean isDuplicated = winningLotto.contains(bonusNumber);

        if (isDuplicated) {
            throw new DuplicateNumbersLottoException();
        }

    }

}
