package controller;

import constant.Rank;
import domain.*;
import validator.LottoValidator;
import view.Input;
import view.Output;

import java.util.HashMap;

public class LottoController {
    private LottoMoney lottoMoney;
    private Input input;
    private Lottos lottos;
    private Lotto winningNumber;
    private BonusNumber bonusNumber;
    private WinningRankController winningRankController;

    public LottoController() {
        input = new Input();

    }

    public void start() {
        //lottoCostRequst = new LottoCostRequst(Input.getInputForLottoMoney());
        // 로또 살 금액 입력
        lottoMoney = getLottoMeney();

        lottos = issueLottos(lottoMoney.getAvaliablePurcahaseCount());
        printIssueLottos();

        // 당첨 번호 입력
        winningNumber = getWinningNumber();

        // 보너스 번호 입력
        bonusNumber = getBonusNumber();

        // 당첨 여부 가리기
        determineWinningLottos();

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

    private Lottos issueLottos(int issueCount) {
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
                bonusNumber = new BonusNumber(input.getInputForBonusNumber());
                return bonusNumber;
            } catch (NumberFormatException error) {
                Output.errorMessage(error);
            } catch (IllegalArgumentException error) {
                Output.errorMessage(error);
            }
        }
    }

    private void printResult(HashMap<Rank, Integer> result){
        Output.printWinningStatisticMessage();
        Output.printStatistics(result);
    }

    private void determineWinningLottos(){
        winningRankController = new WinningRankController(new WinningMachine(winningNumber, bonusNumber));
        HashMap<Rank, Integer> reult = winningRankController.getRankCountResult(lottos.getLottos());

        // 당첨 여부 출력
        printResult(reult);
    }
}
