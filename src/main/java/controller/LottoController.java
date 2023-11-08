package controller;

import domain.Lotto;
import domain.Lottos;
import domain.Player;
import service.LottoService;
import view.InputMessage;
import view.OutputMessage;

import java.util.HashMap;
import java.util.List;

public class LottoController {
    private LottoService lottoService = new LottoService();

    public void play() {
        int money = init();
        initPlayer(money);
        initPlayerWinningNumbers();
        initPlayerBonusNumber();
        result();
        end();
    }

    public int init() {
        int input = InputMessage.printMoneyInputMessage();
        int totalCount = lottoService.getTotalCount(input);
        OutputMessage.moneyToNumberPrint(totalCount);
        List<Lotto> lottosList = lottoService.buyLotto(totalCount);
        OutputMessage.printLottosListOutputMessage(lottosList);
        return input;
    }

    public void initPlayer(int money) {
        lottoService.generatePlayer(money);
    }

    public void initPlayerWinningNumbers() {
        List<Integer> winningNumbers = InputMessage.printWinNumberInputMessage();
        try {
            lottoService.setPlayerWinningNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            initPlayerWinningNumbers();
        }
    }

    public void initPlayerBonusNumber() {
        int bonusNumber = InputMessage.printBonusNumberInputMessage();
        try {
            lottoService.setPlayerBonusMatchNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            initPlayerBonusNumber();
        }
    }

    public void end() {
        double earnRatio = lottoService.getEarnRatio();
        OutputMessage.printEarnRatioOutputMessage(earnRatio);
    }

    public void result() {
        OutputMessage.printResultReadyOutputMessage();
        HashMap resultMap = lottoService.getWinningResult();
        OutputMessage.printResultOutputMessage(resultMap);
    }
}
