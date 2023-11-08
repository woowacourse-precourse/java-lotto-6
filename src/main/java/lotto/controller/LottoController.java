package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResult;
import lotto.domain.Number;
import lotto.domain.Ranking;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoResult lottoResult;
    
    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoResult = new LottoResult();
    }
    
    public void start() {
        LottoPurchase lottoPurchase = inputAmount();
        outputView.printNewLine();
        
        int ticketCount = lottoPurchase.calculateTicketCount();
        outputView.printTicketCount(ticketCount);
        
        List<Lotto> lottoTickets = buyTickets(ticketCount);
        outputView.printTickets(lottoTickets);
        
        Number number = getNumbers();
        
        lottoResult.calculateWinningResult(lottoTickets, number);
        
        Map<Ranking, Integer> winningResult = lottoResult.getWinningResult();
        outputView.printWinningstatistics(winningResult);
        
        double profitRate = lottoResult.getProfitRate(lottoPurchase);
        outputView.printProfitRate(profitRate);
    }
    
    private LottoPurchase inputAmount() {
        try {
            return new LottoPurchase(inputView.inputAmount());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputAmount();
        }
    }
    
    private List<Lotto> buyTickets(int ticketCount) {
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> new Lotto(LottoNumberGenerator.generateRandomNumbers()))
                .collect(Collectors.toList());
    }
    
    private Number getNumbers() {
        Lotto winningNumbers = getWinningNumbers();
        outputView.printNewLine();
        int bonusNumber = getBonusNumber();
        return createNumbers(winningNumbers, bonusNumber);
    }
    
    private Lotto getWinningNumbers() {
        try {
            return new Lotto(inputView.inputWinningNumbers());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getWinningNumbers();
        }
    }
    
    private int getBonusNumber() {
        try {
            return inputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getBonusNumber();
        }
    }
    
    private Number createNumbers(Lotto winningNumbers, int bonusNumber) {
        try {
            return new Number(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createNumbers(winningNumbers, getBonusNumber());
        }
    }
}
