package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.CompareLottoValue;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.repository.LottoRepository;
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
    static List<String> winningBalls ; // 당첨볼
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

    public static List<String> inputWinningNumbers(){ // 문자형 당첨볼을 정수형 당첨볼로 바꾸기
        InputView.requestWinningNumber();
        List<String> selectedNumbers = Arrays.asList(Console.readLine().split(","));
        Validator.validateLottoIsNum(selectedNumbers);
        Validator.validateLottoNumLimit(selectedNumbers);
        return selectedNumbers; // 당첨볼 리턴
    }

    public static void inputBonusNumber(){
        InputView.requestBonusNumber();
        String bonusNum = Console.readLine();
        Validator.validateBonusNumChange(bonusNum);
    }

    public static void lottoReady(String amount){
        int lottoCounts = (Integer.parseInt(amount)) / 1000;
        // 당첨볼 생성, lottoRun에 값 전달, lottoRun에서 로또볼과 당첨볼 전달
        for(int i=0; i< lottoCounts; i++){
            lottoRun(lottoCounts);// 로또 발행
             // 로또볼과 당첨볼을 넘겨야 함
        }
        winningBalls = inputWinningNumbers(); // 당첨볼
        CompareLottoValue.compareValueStart(winningBalls, LottoRepository.getLottoRepo()); // 로또볼과 당첨볼을 넘겨야 함
//        createLottoNum(lottoCounts);
    }

    public static void lottoRun(Integer lottoCounts){
        List<Integer> lottoBalls = pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_NUMBER);
        LottoRepository.lottoSave(lottoBalls);
        Lotto lotto = new Lotto(lottoBalls);
        OutputView.lottoPrinter(lottoBalls);
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