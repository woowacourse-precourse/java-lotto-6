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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoController {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int LOTTO_NUMBER = 6;
    public static List<Integer> winningBalls; // 당첨볼
    public static int bonusBall;
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

    public static List<Integer> inputWinningNumbers(){
        InputView.requestWinningNumber();
        List<String> selectedNumbers = Arrays.asList(Console.readLine().split(","));
        Validator.validateLottoIsNum(selectedNumbers);
        Validator.validateLottoNumLimit(selectedNumbers);
        List<Integer> winningBalls = convertNumLst(selectedNumbers);
        return winningBalls;
    }

    public static List<Integer> convertNumLst(List<String> winningBalls){
        List<Integer> winningBallsNum = new ArrayList<>();
        for(String winningBall : winningBalls){
            winningBallsNum.add(Integer.parseInt(winningBall));
        }
        return  winningBallsNum;
    }

    public static Integer inputBonusNumber(){
        InputView.requestBonusNumber();
        String bonusNum = Console.readLine();
        Validator.validateBonusNumChange(bonusNum);
        return Integer.parseInt(bonusNum);
    }

    public static void lottoReady(String amount){
        int lottoCounts = (Integer.parseInt(amount)) / 1000;
        for(int i=0; i< lottoCounts; i++){
            lottoRun(lottoCounts);
        }
        winningBalls = inputWinningNumbers();
        bonusBall = inputBonusNumber();
        Validator.validateWinningAndBonus(bonusBall, winningBalls);
        CompareLottoValue.compareValueStart(winningBalls, LottoRepository.getLottoRepo(), bonusBall, Integer.parseInt(amount));
    }

    public static void lottoRun(Integer lottoCounts){
        List<Integer> lottoBalls = pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_NUMBER);
        LottoRepository.lottoSave(lottoBalls);
        Lotto lotto = new Lotto(lottoBalls);
        OutputView.lottoPrinter(lottoBalls);
        Lottos.createLotto(lottoCounts, lotto);
    }

}