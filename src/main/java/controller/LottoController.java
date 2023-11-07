package controller;

import controller.validator.BonusNumberValidator;
import controller.validator.WinningNumberValidator;

import domain.Lotto;
import domain.LottoNumberGenerator;
import domain.Price;
import domain.WinningLotto;
import domain.repository.LottoRepository;
import domain.LottoResult;

import java.util.List;

import util.ConstOfLottoResult;

import view.InputView;
import view.OutputView;

public class LottoController {

    private Price price;
    private LottoRepository lottoRepository = new LottoRepository();
    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
    private BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
    private WinningLotto winningLotto = new WinningLotto();
    private LottoResult lottoResult = new LottoResult();

    public void run() {
        initPriceByUserInput();
        printNumOfLotto(price.numOfLotto());
        createLotto();
        showLottoTicket();
        initWinningNumber();
        initBonusNumber();
        calculateLottoResult();
        showLottoResult();
        showRateOfReturn();
    }

    private void showRateOfReturn() {
        double rate = Math.round(lottoResult.calculateRateOfProfit(price.getPrice())*100) / 100.0;
        OutputView.printRateOfReturn(rate);
    }

    private void showLottoResult() {
        OutputView.printEmptyLine();
        OutputView.printResultMessage();
        for(ConstOfLottoResult resultMessage : ConstOfLottoResult.values()) {
            String msg = resultMessage.getMessageOFRank();
            int rank = resultMessage.getRank();
            OutputView.printEachLottoResult(msg,lottoResult.getCountOfRank(rank));
        }
    }

    private void calculateLottoResult() {
        for(Lotto lotto : lottoRepository.getAllLotto()) {
            int matchedNumberCount = countOfMatchedNumber(lotto, winningLotto);
            boolean isEqualToBonus = checkBonusNumber(lotto, winningLotto);
            increaseCountOfRank(analyzeResult(matchedNumberCount,isEqualToBonus));
        }
    }

    private void increaseCountOfRank(int rank) {
        lottoResult.increaseCountOfRank(rank);
    }

    private int analyzeResult(int matchedNumberCount,boolean isEqualToBonus) {
        if(matchedNumberCount == 6) {
            return 1;
        }
        if(matchedNumberCount == 5 && isEqualToBonus) {
            return 2;
        }
        if(matchedNumberCount == 5) {
            return 3;
        }
        if(matchedNumberCount == 4) {
            return 4;
        }
        if(matchedNumberCount == 3) {
            return 5;
        }
        return 0;
    }

    private int countOfMatchedNumber(Lotto lotto, WinningLotto winLotto) {
        int count = 0;
        for(int number : lotto.getNumbers()) {
            if(winLotto.isEqualToWinningNumber(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkBonusNumber(Lotto lotto, WinningLotto winLotto) {
        for(int number : lotto.getNumbers()) {
            if(winLotto.isEqualToBonusNumber(number)) {
                return true;
            }
        }
        return false;
    }

    private void initBonusNumber() {
        try{
            OutputView.printEmptyLine();
            String input = InputView.enterBonusNumbers();
            int bonusNumber = bonusNumberValidator.checkBonusNumberValidation(input);
            winningLotto.setBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            initBonusNumber();
        }
    }

    private void initWinningNumber() {
        try {
            OutputView.printEmptyLine();
            String input = InputView.enterWinningNumbers();
            List<Integer> winningNumber = winningNumberValidator.checkWinningNumberValidation(input);
            winningLotto.setWinningNumber(winningNumber);
        } catch (IllegalArgumentException e) {
            initWinningNumber();
        }
    }

    private void showLottoTicket() {
        OutputView.printEmptyLine();
        for(Lotto lotto : lottoRepository.getAllLotto()) {
            OutputView.printLottoTickets(lotto.getNumbers());
        }
    }

    private void createLotto() {
        for(int i=0;i<price.numOfLotto();i++) {
            lottoRepository.save(new Lotto(lottoNumberGenerator.createLottoNumber()));
        }
    }

    private void printNumOfLotto(int number) {
        OutputView.printEmptyLine();
        OutputView.printNumOfLotto(number);
    }

    private void initPriceByUserInput() {
        try {
            OutputView.printEmptyLine();
            String input = InputView.enterPrice();
            price = new Price(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            initPriceByUserInput();
        }
    }
}