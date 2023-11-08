package lotto.service;

import static lotto.constant.ErrorMessage.ERROR_BONUS;
import static lotto.constant.ErrorMessage.ERROR_PRICE;
import static lotto.constant.ErrorMessage.ERROR_RANGE;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottosList;
import lotto.view.ConsolePrint;

public class LottoService {

    public LottosList readPrice() {
        while (true) {
            try {
                return new LottosList(ConsolePrint.readPrice());
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PRICE.getMessage());
            }
        }
    }

    public Lotto readWinningNum() {
        while (true) {
            try {
                return new Lotto(
                        ConsolePrint.readWinningNum().split(","));
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_RANGE.getMessage());
            }
        }
    }

    public BonusNumber readBonusNum(Lotto winningNumber) {
        while (true) {
            try {
                return new BonusNumber(ConsolePrint.readBonusNum(), winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_BONUS.getMessage());

            }
        }


    }
}
