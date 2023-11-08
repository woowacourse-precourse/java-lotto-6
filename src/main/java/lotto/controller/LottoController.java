package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.constant.Condition;
import lotto.constant.Message;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.Prize;
import lotto.domain.Procedure;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final OutputView outputView;
    private final InputView inputView;

    public LottoController() {
        this.lottoService = new LottoService();
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public LottoController(LottoService lottoService, OutputView outputView, InputView inputView) {
        this.lottoService = lottoService;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void playLottoGame() {
        String input;

        int money = inputMoney();
        int count = money / Condition.THOUSAND;
        List<Lotto> purchasedLotto = lottoService.generateLotto(count);
        String lottoNumber = lottoService.ShowPurchasedLottoNumbers(purchasedLotto);
        outputView.printPurchasedLotto(lottoNumber);

        Lotto winLotto = drawWinLotto();

        int bonusNumber = drawBonusNumber();

        LottoBuyer lottoBuyer = lottoService.createLottoBuyer(purchasedLotto, winLotto, bonusNumber, money);

        List<Integer> rank = lottoBuyer.retrieveAllResult();

        long interests = lottoService.calculateInterests(rank);

        double interestRate = lottoBuyer.calculateInterestRate(interests);
        String res = lottoService.PrizeInfoToString(rank);
        outputView.printTotalResult(res, interestRate);
    }

    public int drawBonusNumber() {
        while (true){
            String input = inputView.drawBonusString();
            List<Integer> numbers = refineNumbers(Procedure.DRAW_WINNING_NUMBERS, input);
            if (numbers != null) {
                return numbers.get(0);
            }
        }
    }

    public Lotto drawWinLotto() {
        while (true){
            String input = inputView.drawWinningString();
            List<Integer> numbers = refineNumbers(Procedure.DRAW_WINNING_NUMBERS, input);
            if (numbers != null) {
                return new Lotto(numbers);
            }
        }
    }

    public int inputMoney() {
        while (true){
            String input = inputView.inputPurchaseAmount();
            List<Integer> numbers = refineNumbers(Procedure.PURCHASE_LOTTO, input);
            if (numbers != null) {
                return numbers.get(0);
            }
        }
    }

    public List<Integer> refineNumbers(Procedure procedure, String input) {
        try {
            List<Integer> numbers = lottoService.parseInputToNumberCandidates(input);
            procedure.checkPossibleError(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            outputView.printErrorMessage(Message.PURCHASE_MONEY + Message.ERROR_NOT_A_NUMBER);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
        return null;
    }
}
