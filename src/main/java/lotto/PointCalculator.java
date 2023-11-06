package lotto;

public class PointCalculator {
    private final double BONUS_NUMBER_MATCH_POINT = 0.5;
    private final double BONUS_NUMBER_NOT_MATCH_POINT = 0;

    public double calculateTotalPoint(Lotto lotto, AnswerLotto answerLotto, BonusNumber bonusNumber) {
        return calculateGeneralPoint(lotto, answerLotto) + calculateBonusPoint(lotto, bonusNumber);
    }

    private int calculateGeneralPoint(Lotto lotto, AnswerLotto answerLotto) {
        return answerLotto.countMatchNumber(lotto);
    }

    private double calculateBonusPoint(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.hasNumber(bonusNumber.getBonusNumber())) {
            return BONUS_NUMBER_MATCH_POINT;
        }
        return BONUS_NUMBER_NOT_MATCH_POINT;
    }
}
