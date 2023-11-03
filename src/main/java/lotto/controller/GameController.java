package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoCount;
import lotto.model.PurchaseMoney;
import lotto.utils.GeneratedLottoNumber;
import lotto.view.InputView;

public class GameController {

    private static List<List<Integer>> lottos;

    public static void start(){

        PurchaseMoney purchaseMoney = new PurchaseMoney(inputPurchaseNumber()); // 구매 금액 입력
        LottoCount lottoCount = new LottoCount(purchaseMoney.getValue()); // 구매 금액 -> 로또 갯수 변환
        generateLottos(lottoCount.getValue()); // 로또 번호 생성
        inputWonNumber(); // 당첨 번호 입력


    }

    private static String inputPurchaseNumber(){
        return InputView.purchaseMoney();
    }

    private static void generateLottos(int lottoCount){
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(GeneratedLottoNumber.getRandomNumber());
        }
    }

    private static String inputWonNumber(){
        return InputView.wonNumber();
    }
}
