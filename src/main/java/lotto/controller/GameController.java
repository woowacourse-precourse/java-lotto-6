package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.PurchaseMoney;
import lotto.model.WinningNumber;
import lotto.utils.GeneratedLottoNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private static List<Lotto> lottos;

    public static void start(){

        PurchaseMoney purchaseMoney = new PurchaseMoney(inputPurchaseMoney()); // 구매 금액 입력
        System.out.println();

        LottoCount lottoCount = new LottoCount(purchaseMoney.getValue()); // 구매 금액 -> 로또 갯수 변환
        outputLottoCount(lottoCount.getValue());
        generateLottos(lottoCount.getValue()); // 로또 번호 생성
        outputLottos();
        System.out.println();

        WinningNumber winningNumber = new WinningNumber(inputWinningNumber()); // 당첨 번호 입력

        inputBonusNumber(); // 보너스 번호 입력 받기
    }

    private static String inputPurchaseMoney(){
        return InputView.purchaseMoney();
    }

    private static void outputLottoCount(int lottoCount) {
        OutputView.purchaseLotto(lottoCount);
    }

    private static void generateLottos(int lottoCount){
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(GeneratedLottoNumber.getRandomNumber());
        }
    }

    private static void outputLottos(){
        OutputView.showEachLotto(lottos);
    }

    private static String inputWinningNumber(){
        return InputView.winningNumber();
    }

    private static String inputBonusNumber(){
        return InputView.bonusNumber();
    }
}
