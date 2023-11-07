package lotto.controller;

import lotto.domain.db.WinningLotto;
import lotto.util.StringToNumberListParser;

import java.util.Arrays;

public class SaveLottoController {
    public static WinningLotto lottoControl(String[] lottoNumber, int bonus) {
        WinningLotto newLotto = new WinningLotto
                (new StringToNumberListParser().StringToIntlistParsing(Arrays.asList(lottoNumber)), bonus);

        return newLotto;
    }
}
