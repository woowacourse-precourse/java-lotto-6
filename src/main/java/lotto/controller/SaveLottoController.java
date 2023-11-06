package lotto.controller;

import lotto.domain.db.Lotto;
import lotto.domain.db.WinningLotto;
import lotto.util.StringToNumberListParser;
import lotto.view.InputAboutLottoNumber;

import java.util.Arrays;
import java.util.List;

public class SaveLottoController {
    public static WinningLotto lottoControl(String[] lottoNumber, int bonus) {
        WinningLotto newLotto = new WinningLotto
                (new StringToNumberListParser().StringToIntlistParsing(Arrays.asList(lottoNumber)), bonus);

        return newLotto;
    }
}
