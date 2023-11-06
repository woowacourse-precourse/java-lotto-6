package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoController {
//    public static final int MIN_NUM = 1;
//    public static final int MAX_NUM = 45;
//    public static final int LOTTO_NUMBER = 6;
    public static void inputPurchaseAmount(){
        InputView.requestPurchaseAmountMessage();
        String amount = Console.readLine();
        Validator.validateInputAmount(amount);
        OutputView.purchaseLottoNumber();
        lottoCount(amount);
    }

    public static void lottoCount(String amount){
        int lottoCounts = (Integer.parseInt(amount)) / 1000;
        createLottoNum(lottoCounts);
    }

    public static void createLottoNum(Integer lottoCounts){ // 횟수 만큼 반복
        for(int i = 0; i< lottoCounts; i++){
            createlLottoLst();
        }
    }
    public static void createlLottoLst(){ // 생성 후 리스트로
        OutputView.lottoPrinter(); // 로또 리스트 출력
    }



}
