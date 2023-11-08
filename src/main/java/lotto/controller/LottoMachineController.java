package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.domain.Member;
import lotto.domain.exception.LottoMachineExceptionHandler;
import lotto.io.LottoMachineConsoleManager;
import lotto.io.LottoMachineDisplayManager;

public class LottoMachineController {
    private final LottoMachine lottoMachine;
    private final Member member;

    public LottoMachineController(LottoMachine lottoMachine, Member member) {
        this.lottoMachine = lottoMachine;
        this.member = member;
    }

    public void run() {
        Member member = LottoMachineExceptionHandler.handleOperation(this::registerLottoPurchaseAmount);

        List<Lotto> lottos = displayGeneratedLottos(member.getLottoCount());

        List<Integer> winningLottoNumbers = LottoMachineExceptionHandler.handleListOperation(this::registerWinningLottoNumbers);

        Integer bonusLottoNumber = LottoMachineExceptionHandler.handleOperation(this::registerBonusLottoNumber);

        displayLottoStatics(lottos, winningLottoNumbers, bonusLottoNumber, member.getLottoPurchaseAmount());
    }

    private Member registerLottoPurchaseAmount() {
        LottoMachineDisplayManager.printPromptPurchaseLottoAmount();
        String lottoPurchaseAmount = LottoMachineConsoleManager.readLine();

        return member.buyLotto(lottoPurchaseAmount);
    }

    private List<Lotto> displayGeneratedLottos(int lottoCount) {
        LottoMachineDisplayManager.printPurchaseLottoCount(lottoCount);

        List<Lotto> lottos = lottoMachine.generateLottos(lottoCount);
        LottoMachineDisplayManager.printPurchaseLottoNumbers(lottos);

        return lottos;
    }

    private List<Integer> registerWinningLottoNumbers() {
        LottoMachineDisplayManager.printPromptWinningLottoNumber();
        String winningLottoNumbers = LottoMachineConsoleManager.readLine();

        return lottoMachine.registerWinningNumber(winningLottoNumbers);
    }

    private Integer registerBonusLottoNumber() {
        LottoMachineDisplayManager.printPromptBonusLottoNumber();
        String lottoBonusNumber = LottoMachineConsoleManager.readLine();

        return lottoMachine.registerBonusNumber(lottoBonusNumber);
    }

    private void displayLottoStatics(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber, int lottoPurchaseAmount) {
        Map<LottoRank, Integer> lottoRanks = displayLottoRanking(lottos, winningNumbers, bonusNumber);
        displayTotalYieldRate(lottoRanks, lottoPurchaseAmount);
        LottoMachineConsoleManager.close();
    }

    private Map<LottoRank, Integer> displayLottoRanking(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        Map<LottoRank, Integer> lottoRanks = lottoMachine.computedLottoRanking(lottos, winningNumbers, bonusNumber);
        LottoMachineDisplayManager.printLottoStatistics();
        LottoMachineDisplayManager.printLottoRanking(lottoRanks);

        return lottoRanks;
    }

    private void displayTotalYieldRate(Map<LottoRank, Integer> lottoRanks, int lottoPurchaseAmount) {
        double yieldRate = lottoMachine.computedYieldRate(lottoPurchaseAmount, lottoRanks);
        LottoMachineDisplayManager.printTotalLottoYieldRateMessage(yieldRate);
    }
}
