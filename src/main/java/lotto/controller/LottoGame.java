package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.service.WinningStatisticsService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private InputView inputView;
    private OutputView outputView;
    private PurchaseManager purchaseManager;
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private Result result;

    public LottoGame(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startGame(){
        purchase();
        makeLottos();
        getWinningNumbers();
        getBonusNumber();
        calcWinning();
        outputView.printStatistics(result);
    }
    private void purchase(){
        boolean validateInput=false;
        while(!validateInput){
            validateInput = validatePurchaseAmount(inputView.inputPurchaseAmount());
        }
        outputView.printResult(purchaseManager.calcPurchaseNumber());
    }
    private boolean validatePurchaseAmount(String purchaseAmount){
        try {
            purchaseManager = new PurchaseManager(purchaseAmount);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
    private void makeLottos(){
        lottos = new Lottos(makeLotto());
        outputView.printLottos(lottos.getLottos());
    }
    private List<Lotto> makeLotto(){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<purchaseManager.calcPurchaseNumber();i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
    private void getWinningNumbers(){
        boolean validateInput=false;
        while(!validateInput){
            validateInput = validateWinningNumber(inputView.inputWinningNumber());
        }
    }
    private boolean validateWinningNumber(String input){
        try {
            winningNumbers = new WinningNumbers(input);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
    private void getBonusNumber(){
        boolean validateInput=false;
        while(!validateInput){
            validateInput = validateBonusNumber(inputView.inputBonusNumber());
        }
    }
    private boolean validateBonusNumber(String input){
        try {
            winningNumbers.setBonusNumber(input);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
    private void calcWinning(){
        WinningStatisticsService winningStatisticsService = new WinningStatisticsService();
        result = winningStatisticsService.calcScore(lottos.getLottos(), winningNumbers.getWinningNumbers(), winningNumbers.getBonusNumber());
    }
}
