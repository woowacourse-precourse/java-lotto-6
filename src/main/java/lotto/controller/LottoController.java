package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoDraw;
import lotto.domain.LottoPaper;
import lotto.domain.Payment;
import lotto.util.LottoNumberGenerator;
import lotto.util.LottoTicketCalculator;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public LottoPaper createLottoPaperWithPayment(Payment payment){
        int amount = payment.amount();

        List<Lotto> lottoTickets = purchaseLottoWithAmount(amount);
        LottoPaper lottoPaper = new LottoPaper(amount,lottoTickets);
        OutputView.printLottoPaperMessage(lottoPaper);

        return lottoPaper;
    }
    public LottoDraw createLottoDraw(){
        OutputView.printWinningDrawMessage();
        Lotto winningLotto = createWinningLotto();
        LottoDraw lottoDraw = generateLottoDrawWithWinningLotto(winningLotto);
        return lottoDraw;
    }
    private Lotto createWinningLotto(){
        try {
            String winningLottoNumbersInfo = InputView.readLine();
            List<Integer> winningLottoNumbers = Parser.parseInfoToNumbers(winningLottoNumbersInfo);
            return new Lotto(winningLottoNumbers);
        }catch (IllegalArgumentException exception){
            OutputView.printErrorMessage(exception.getMessage());
            return createWinningLotto();
        }
    }
    private LottoDraw generateLottoDrawWithWinningLotto(final Lotto winningLotto){
        try{
            int bonusNumber = createBonusNumber();
            return new LottoDraw(winningLotto,bonusNumber);
        }catch (IllegalArgumentException exception){
            OutputView.printErrorMessage(exception.getMessage());
            return generateLottoDrawWithWinningLotto(winningLotto);
        }
    }
    private int createBonusNumber(){
        OutputView.printBonusDrawMessage();
        String bonusNumberInfo = InputView.readLine();
        int bonusNumber = Parser.parseInfoToNumber(bonusNumberInfo);
        return bonusNumber;
    }
    private List<Lotto> purchaseLottoWithAmount(int amount){
        int lottoTicketSize = LottoTicketCalculator.calculateLottoTicketQuantityWithAmount(amount);
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoTicketSize; i++) {
            lottoTickets.add(issueLottoTicket());
        }
        return lottoTickets;
    }
    private Lotto issueLottoTicket(){
        List<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();
        return new Lotto(lottoNumbers);
    }
}

