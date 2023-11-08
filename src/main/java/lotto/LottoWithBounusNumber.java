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
        Lotto lotto;
        Integer bounusNumber;

        try {
            lotto = Lotto.inputLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lotto = Lotto.inputLotto();
        }

        try {
            bounusNumber = inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bounusNumber = inputBonusNumber();
        }
        return new LottoWithBounusNumber(lotto, bounusNumber);
    }

    private static Integer inputBonusNumber() {
        Integer bonusNumber;
        InputView.printUserBonusNumber();
        bonusNumber = Integer.parseInt(readLine());
        return bonusNumber;
    }
}
