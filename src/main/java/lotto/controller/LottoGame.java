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

    private static final int LOTTO_PRICE = 1000;

    private final InputSystem inputSystem = new InputSystem();
    private final PrintSystem printSystem = new PrintSystem();
    private final ValidateSystem validateSystem = new ValidateSystem();

    private Map<WinningResultType, Integer> winningResult = new HashMap<>();
    private List<Lotto> lottos = new ArrayList<>();

    public void setLottoSystem(LottoSystem lottoSystem) {
        this.lottoSystem = lottoSystem;
    }

    private LottoSystem lottoSystem;
    private Player player;

    public void play(){

        init();

        saveGeneratedLottosAndPrint(saveNumOfLotto());

        generateLottoSystem();

        saveWinningResultAndPrint();

        clear();

    }

    public void init(){
        this.player = new Player();
        this.winningResult.put(WinningResultType.WINNING_RESULT_NOTHING, 0);
        this.winningResult.put(WinningResultType.WINNING_RESULT_3_MATCH, 0);
        this.winningResult.put(WinningResultType.WINNING_RESULT_4_MATCH, 0);
        this.winningResult.put(WinningResultType.WINNING_RESULT_5_MATCH, 0);
        this.winningResult.put(WinningResultType.WINNING_RESULT_6_MATCH, 0);
        this.winningResult.put(WinningResultType.WINNING_RESULT_5_MATCH_AND_BONUS_MATCH, 0);
    }

    private int saveNumOfLotto(){
        try{
            printSystem.printAskPaymentAccountMessage();
            int paymentAccount = inputSystem.inputPaymentAccount();

            validateSystem.validatePaymentAccount(paymentAccount);

            player.savePaymentAccount(paymentAccount);
            printSystem.printResultNumOfLotto(paymentAccount/LOTTO_PRICE);

            return paymentAccount/LOTTO_PRICE;

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return saveNumOfLotto();
        }

    }

    public void saveGeneratedLottosAndPrint(int lottoCount){

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoSystem.generateLotto());
        }

        printSystem.printResultGeneratedLottos(this.lottos);
    }

    private void generateLottoSystem(){

        List<Integer> winningNumbers = saveWinningNumbers();
        this.lottoSystem = new LottoSystem(winningNumbers, saveBonusNumber(winningNumbers));

    }

    private List<Integer> saveWinningNumbers(){

        try{
            printSystem.printAskWinningNumbersMessage();
            List<Integer> winningNumbers = inputSystem.inputWinningNumbers();
            validateSystem.validateLottoNumbers(winningNumbers);

            return winningNumbers;

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return saveWinningNumbers();
        }
    }

    private int saveBonusNumber(List<Integer> winningNumbers){
        try{
            printSystem.printAskBonusNumberMessage();
            int bonusNumber = inputSystem.inputBonusNumber();
            validateSystem.validateBonusNumber(winningNumbers,bonusNumber);

            return bonusNumber;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return saveBonusNumber(winningNumbers);
        }
    }

    public void saveWinningResultAndPrint(){

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

    public Map<WinningResultType, Integer> getWinningResult() {
        return winningResult;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
