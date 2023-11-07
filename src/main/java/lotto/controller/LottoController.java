package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoPurchase;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    
    private final InputView inputView;
    private final OutputView outputView;
    
    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }
    
    public void start() {
        LottoPurchase lottoPurchase = inputAmount();
        outputView.printNewLine();
        
        int ticketCount = lottoPurchase.calculateTicketCount();
        outputView.printTicketCount(ticketCount);
        
        List<Lotto> lottoTickets = buyTickets(ticketCount);
        outputView.printTickets(lottoTickets);
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
}
