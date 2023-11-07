package lotto.machine.ui;

import lotto.Lotto;

import java.util.List;

public interface UI {
    void requirePurchaseView();
    int inputPurchaseAmount();
    void outputPurchaseLottoNumbers(List<Lotto> lottos);

    void requireWinningNumbers();
    List<Integer> inputWinningNumbers();

    void requireBonusNumber();
    int inputBonusNumber(List<Integer> lotto);

    // TODO : outputGameResult 의 매개 변수는 아직 정해지지 않음
    void outputGameResult(int matchThree, int matchFour, int matchFiveIncludeBonus, int matchFiveExceptBonus, int matchSix, double rateOfReturn);

}
