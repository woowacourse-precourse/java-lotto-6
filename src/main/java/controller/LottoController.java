package controller;

import constant.Rank;
import domain.*;
import validator.BonusNumberValidator;
import validator.LottoValidator;
import view.Input;
import view.Output;

import java.util.HashMap;
import java.util.Iterator;

public class LottoController {
    private LottoMoney lottoMoney;
    private Input input;
    private Lottos lottos;
    private Lotto winningNumber;
    private BonusNumber bonusNumber;
    private WinningMachine winningMachine;

    public LottoController() {
        input = new Input();

    }

    public void start() {
        // 로또 살 금액 입력
        lottoMoney = getLottoMeney();
        lottos = issueLottos(lottoMoney.getAvaliablePurcahaseCount());
        printIssueLottos();

        // 당첨 번호 입력
        winningNumber = getWinningNumber();

        // 보너스 번호 입력
        bonusNumber = getBonusNumber();

        // 당첨 여부 가리기
        startDetermineWinningLottos();

        //수익률 계산 후 출력
        calcurateProfitRate();

    }

    private LottoMoney getLottoMeney() {
        LottoMoney tempLottoMoney;
        while (true) {
            try {
                tempLottoMoney = new LottoMoney(input.getInputForLottoMoney());
                return tempLottoMoney;
            } catch (NumberFormatException error) {
                Output.errorMessage(error);
            } catch (IllegalArgumentException error) {
                Output.errorMessage(error);
            }
        }
    }

    private Lottos issueLottos(long issueCount) {
        return new Lottos(issueCount);
    }

    private void printIssueLottos() {
        Output.print();
        Output.printLottoPurchaseMessage(lottos.getLottos().size());
        for (Lotto lotto : lottos.getLottos()) {
            Output.printLotto(lotto);
        }
    }

    private Lotto getWinningNumber() {
        Lotto tempWinningNumber;
        while (true) {
            try {
                String userInputData = input.getInputForWinningNumber();
                tempWinningNumber = new Lotto(LottoValidator.validNumberic(userInputData));
                return tempWinningNumber;

            } catch (NumberFormatException error) {
                Output.errorMessage(error);
            } catch (IllegalArgumentException error) {
                Output.errorMessage(error);
            }

        }
    }

    private BonusNumber getBonusNumber() {
        BonusNumber bonusNumber;
        while (true) {
            try {
                int userInputBonusNumber = BonusNumberValidator.validNumberic(input.getInputForBonusNumber());
                BonusNumberValidator.validDuplicate(winningNumber.getNumbers(), userInputBonusNumber);

                bonusNumber = new BonusNumber(userInputBonusNumber);
                return bonusNumber;
            } catch (NumberFormatException error) {
                Output.errorMessage(error);
            } catch (IllegalArgumentException error) {
                Output.errorMessage(error);
            }
        }
    }

    private void startDetermineWinningLottos(){
        winningMachine = new WinningMachine(winningNumber, bonusNumber);
        winningMachine.calcurateRankResult(lottos.getLottos());

        // 당첨 여부 출력
        printWinningLottos(winningMachine.getRankResult());
    }

    private void printWinningLottos(HashMap<Rank, Integer> result){
        Output.print();
        Output.printWinningStatisticMessage();
        Output.printStatistics(result);
    }

    private void calcurateProfitRate(){
        long totalProfit = getTotalProfit(winningMachine.getRankResult());
        ProfitRate profitRate = new ProfitRate(lottoMoney.getMoney(), totalProfit);
        Output.printProfitRate(profitRate);
    }

    private static long getTotalProfit(HashMap<Rank, Integer> rankResult) {
        long totalIncome = 0;
        Iterator<Rank> ranks = rankResult.keySet().iterator();
        while(ranks.hasNext()){
            Rank currentRank = ranks.next();
            int count = rankResult.get(currentRank);
            totalIncome+= currentRank.getPrize()*count;
        }
        return totalIncome;
    }
}
