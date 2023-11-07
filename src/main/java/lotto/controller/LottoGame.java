package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Player;
import lotto.service.InputSystem;
import lotto.service.LottoSystem;
import lotto.service.PrintSystem;
import lotto.service.ValidateSystem;
import lotto.type.WinningResultType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private final InputSystem inputSystem = new InputSystem();
    private final PrintSystem printSystem = new PrintSystem();
    private final ValidateSystem validateSystem = new ValidateSystem();

    private Map<WinningResultType, Integer> winningResult = new HashMap<>();
    private List<Lotto> lottos = new ArrayList<>();
    private LottoSystem lottoSystem;
    private Player player;

    public void play(){

        init();

        saveGeneratedLottosAndPrint(saveNumOfLotto());

        saveWinningNumbersAndBonusNumber();

        saveWinningResultAndPrint();

        clear();

    }

    private void init(){
        this.player = new Player();
        this.winningResult.put(WinningResultType.WINNING_RESULT_NOTHING, 0);
        this.winningResult.put(WinningResultType.WINNING_RESULT_3_MATCH, 0);
        this.winningResult.put(WinningResultType.WINNING_RESULT_4_MATCH, 0);
        this.winningResult.put(WinningResultType.WINNING_RESULT_5_MATCH, 0);
        this.winningResult.put(WinningResultType.WINNING_RESULT_6_MATCH, 0);
        this.winningResult.put(WinningResultType.WINNING_RESULT_5_MATCH_AND_BONUS_MATCH, 0);
    }

    private int saveNumOfLotto(){

        printSystem.printAskPaymentAccountMessage();
        int paymentAccount = inputSystem.inputPaymentAccount();

        validateSystem.validatePaymentAccount(paymentAccount);

        player.savePaymentAccount(paymentAccount);
        printSystem.printResultNumOfLotto(paymentAccount/1000);

        return paymentAccount/1000;
    }

    private void saveGeneratedLottosAndPrint(int lottoCount){

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoSystem.generateLotto());
        }

        printSystem.printResultGeneratedLottos(this.lottos);
    }

    private void saveWinningNumbersAndBonusNumber(){

        printSystem.printAskWinningNumbersMessage();
        List<Integer> winningNumbers = inputSystem.inputWinningNumbers();
        validateSystem.validateWinningNumbers(winningNumbers);

        printSystem.printAskBonusNumberMessage();
        int bonusNumber = inputSystem.inputBonusNumber();
        validateSystem.validateBonusNumber(winningNumbers,bonusNumber);

        this.lottoSystem = new LottoSystem(winningNumbers, bonusNumber);

    }

    private void saveWinningResultAndPrint(){

        for(Lotto lotto:lottos){

            WinningResultType winningResultType = lottoSystem.checkWinning(lotto);
            winningResult.put(winningResultType, winningResult.get(winningResultType) + 1);

            lottoSystem.giveWinningAccountToPlayer(winningResultType,player);
        }

        printSystem.printResultWinningStatisticsAndRateOfRevenue(winningResult,player.calculateRateOfRevenue());

    }

    private void clear(){
        this.lottos.clear();
        this.winningResult.clear();
        this.lottoSystem = null;
        this.player = null;
    }

}
