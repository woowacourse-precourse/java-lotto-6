package lotto.controller;

import lotto.model.Lotto;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

import static lotto.service.LottoService.generateLottoList;

public class LottoController {
    public static void playLotto() {
        Integer numberOfLotto = LottoView.getNumberOfLottoForPrice();
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        List<Lotto> lottoList = generateLottoList(numberOfLotto);
        for (int i = 0; i < lottoList.size(); i++) {
            System.out.println(lottoList.get(i).toString());
        }
    }
}
