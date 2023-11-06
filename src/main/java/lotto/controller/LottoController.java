package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoController {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int LOTTO_NUMBER = 6;
    public static void inputPurchaseAmount(){
        InputView.requestPurchaseAmountMessage();
        String amount = Console.readLine();
        System.out.println();
        inputAmountValidator(amount);
        lottoReady(amount);
    }

    public static void inputAmountValidator(String amount){
        Validator.validateInputAmount(amount);
        int lottoCounts = (Integer.parseInt(amount)) / 1000;
        OutputView.purchaseLottoNumber(lottoCounts);
    }

    public static void inputSelectedNumbers(){
        InputView.requestWinningNumber();
        List<String> selectedNumbers = Arrays.asList(Console.readLine().split(","));
        Validator.validateLottoIsNum(selectedNumbers);
        Validator.validateLottoNumLimit(selectedNumbers);
        System.out.println(selectedNumbers);
    }

    public static void inputBonusNumber(){
        InputView.requestBonusNumber();
        String bonusNum = Console.readLine();
        Validator.validateBonusNumChange(bonusNum);
    }

    public static void lottoReady(String amount){
        int lottoCounts = (Integer.parseInt(amount)) / 1000;
        for(int i=0; i< lottoCounts; i++){
            lottoRun(lottoCounts);
        }
//        createLottoNum(lottoCounts);
    }

    public static void lottoRun(Integer lottoCounts){
        List<Integer> numbers = pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_NUMBER);
        Lotto lotto = new Lotto(numbers);
        OutputView.lottoPrinter(numbers);
        Lottos.createLotto(lottoCounts, lotto);
    }

//    public static void createLottoNum(Integer lottoCounts){ // 횟수 만큼 반복
//        for(int i = 0; i< lottoCounts; i++){
//            createlLottoLst();
//        }
//    }
//    public static void createlLottoLst(){ // 생성 후 리스트로
//        OutputView.lottoPrinter(); // 로또 리스트 출력
//    }



}