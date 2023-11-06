package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoController {
//    public static final int MIN_NUM = 1;
//    public static final int MAX_NUM = 45;
//    public static final int LOTTO_NUMBER = 6;
    public static void inputPurchaseAmount(){
        InputView.requestPurchaseAmountMessage();
        String amount = Console.readLine();
        System.out.println();
        inputAmountValidator(amount);
        lottoCount(amount);
    }

    public static void inputAmountValidator(String amount){
        Validator.validateInputAmount(amount);
        int lottoCounts = (Integer.parseInt(amount)) / 1000;
        OutputView.purchaseLottoNumber(lottoCounts);
    }

    public static void inputSelectedNumbers(){
        InputView.requestWinningNumber();
        List<String> selectedNumbers = Arrays.asList(Console.readLine().split(","));
        Validator.validateLottoNumLimit(selectedNumbers);
        System.out.println(selectedNumbers);

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
