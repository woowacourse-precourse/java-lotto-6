package lotto;

public class PointCalculator {
    private final double BONUS_NUMBER_MATCH_POINT = 0.5;
    private final double BONUS_NUMBER_NOT_MATCH_POINT = 0;

    public double calculateTotalPoint(Lotto lotto, AnswerLotto answerLotto) {
        return calculateGeneralPoint(lotto, answerLotto) + calculateBonusPoint(lotto, answerLotto.getBonusNumber());
    }

    private int calculateGeneralPoint(Lotto lotto, AnswerLotto answerLotto) {
        return answerLotto.countMatchNumber(lotto);
    }

    private double calculateBonusPoint(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.hasNumber(bonusNumber.getNumber())) {
            return BONUS_NUMBER_MATCH_POINT;
        }
        return BONUS_NUMBER_NOT_MATCH_POINT;
    }
}
