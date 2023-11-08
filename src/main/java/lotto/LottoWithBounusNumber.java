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
함        while (true){
            try {
                lotto = Lotto.inputLotto();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                bounusNumber = inputBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return new LottoWithBounusNumber(lotto, bounusNumber);
    }

    private static Integer inputBonusNumber() {
        Integer bonusNumber;
        InputView.printUserBonusNumber();
        bonusNumber = Integer.parseInt(readLine());
        return bonusNumber;
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }
}
