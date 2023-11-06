package lotto.controller;

import lotto.view.LottoView;

public class LottoController {
    public static void playLotto() {
        Integer numberOfLotto = LottoView.getNumberOfLottoForPrice();
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        
    }
}
