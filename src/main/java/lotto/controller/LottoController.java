package lotto.controller;

import lotto.view.lottoView;

public class LottoController {
    public static void playLotto() {
        Integer numberOfLotto = lottoView.getNumberOfLottoForPrice();
        System.out.println(numberOfLotto);
    }
}
