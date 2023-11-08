package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.RandomIntGenerator;
import lotto.view.LottoView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        //mvc연결
//        LottoView lottoView = new LottoView();
//        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        LottoController lottoController = new LottoController();

        //로또 금액 입력
        LottoController.setPrice();
        //구매한 로또번호 출력
        LottoController.setBuyLottoNumberPrint();
        LottoController.setPrizeNumberInput();
//        LottoController.setBonusNumberInput();
//        lottoController.setRandomNumber(lottoView.askPrice());
        LottoController.winningStatstic();
        LottoController.PerformanceCalculation();

    }


}
