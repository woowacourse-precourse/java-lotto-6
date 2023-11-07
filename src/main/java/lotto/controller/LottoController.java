package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run(){
        long money = getMoney();
        Lottos lottos = getUserLottos(money);
        Lotto winningLotto = getWinningLotto();
        int bonus = getBonusNumber(winningLotto);
        lottoService.calculrateResult(lottos, winningLotto, bonus);
        outputView.printLottoResult(lottoService.getFinalPrize(money));
    }

    private long getMoney(){
        while(true){
            try {
                outputView.printMoneyPrompt();
                long money = Long.parseLong(inputView.inputMoney());
                outputView.printLottoPurchaseMessage(money);
                return money;
            } catch (IllegalArgumentException e){
                outputView.printErrorMessage(e);
            }
        }
    }

    private Lottos getUserLottos(long money){
        while(true){
            try{
                Lottos lottos = new Lottos(money);
                outputView.printUserLottos(lottos);
                return lottos;
            } catch (IllegalArgumentException e){
                outputView.printErrorMessage(e);
            }
        }
    }

    private Lotto getWinningLotto(){
        while(true){
            try {
                outputView.printWinningLottoPrompt();
                String numbers = inputView.inputWinningNumbers();
                List<Integer> winningNumbers = Arrays.stream(numbers.split(","))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .toList();
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e){
                outputView.printErrorMessage(e);
            }
        }
    }

    private int getBonusNumber(Lotto winningLotto){
        while(true){
            try {
                outputView.printBonusNumberPrompt();
                int bonus = Integer.parseInt(inputView.inputBonus());
                winningLotto.validateBonusNumber(bonus);
                return bonus;
            } catch (IllegalArgumentException e){
                outputView.printErrorMessage(e);
            }
        }
    }
}
