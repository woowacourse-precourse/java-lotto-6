package lotto.service;

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
            }
        }
    }

    public Lotto readWinningNum() {
        while (true) {

            try {
                return new Lotto(
                        ConsolePrint.readWinningNum().split(","));
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public BonusNumber readBonusNum() {
        while (true) {
            try {

                return new BonusNumber(ConsolePrint.readBonusNum());
            } catch (IllegalArgumentException e) {

            }
        }


    }
}
