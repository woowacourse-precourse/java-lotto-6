package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.dto.BuyLottoInfo;
import lotto.domain.dto.LottoWinResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService){
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void doGame(){
        BuyLottoInfo lottoTickets = buyTicket();
        outputView.printUserLottoInfo(lottoTickets);

        createWinningLotto();

        LottoWinResult lottoWinResult = lottoService.checkWinningLotto();
        outputView.printLottoResult(lottoWinResult);
    }

    private BuyLottoInfo buyTicket() {
        while(true){
            try{
                int amount = inputView.inputPurchaseAmount();
                BuyLottoInfo lottoTickets = lottoService.createLottoTickets(amount);
                return lottoTickets;
            } catch (IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }

    private void createWinningLotto(){
        while(true){
            try{
                List<Integer> winningNumbers = getWinningNumber();
                int bonusNumber = inputView.inputBonusNumber();
                lottoService.createWinningLotto(winningNumbers, bonusNumber);
                return;
            } catch (IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumber() {
        while(true){
            try{
                List<Integer> winningNumbers = inputView.inputWinningNumber();
                return winningNumbers;
            }catch (IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }

}
