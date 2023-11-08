package lotto;

import util.InputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoWithBounusNumber {
    private Lotto lotto;
    private Integer bonusNumber;

    LottoWithBounusNumber(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWithBounusNumber createLottoWithBonusNumber() {
        Lotto lotto = Lotto.inputLotto();
        Integer bounusNumber = inputBonusNumber();
        // 보너스 숫자가 입력받은 로또와 중복되지는 않는지 체크하는 기능 호출부
        return new LottoWithBounusNumber(lotto, bounusNumber);
    }

    private static Integer inputBonusNumber() {
        Integer bonusNumber;
        InputView.printUserBonusNumber();
        bonusNumber = Integer.parseInt(readLine());
        return bonusNumber;
    }
}
