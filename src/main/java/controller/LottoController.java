package controller;

import exception.DuplicateLottoNumberException;
import exception.NonPositiveMoneyException;
import exception.WrongBonusNumberPatternException;
import exception.WrongInputPatternException;
import exception.WrongLottoSizeException;
import exception.WrongMoneyInputException;
import exception.WrongMoneyUnitException;
import exception.WrongRangeLottoNumberException;
import java.util.List;
import java.util.regex.Pattern;
import model.EarningRate;
import model.Lotto;
import model.Money;
import model.PrizeResult;
import model.PurchasedLottos;
import model.WinningLotto;
import model.generator.LottoGenerator;
import util.LottoUtils;
import view.InputView;
import view.OutputView;

public class LottoController {
    public static final Pattern LOTTO_INPUT_PATTERN = Pattern.compile("^\\d+(,\\d+)*$");
    private static final Pattern NUMBER_INPUT_PATTERN = Pattern.compile("\\d+");

    private Money money;
    private WinningLotto winningLotto;
    private PurchasedLottos purchasedLottos;
    private PrizeResult prizeResult;
    private EarningRate earningRate;

    public void run() {
        getMoneyInput();
        printUserLotto();
        getWinningLotto();
        calculateResult(winningLotto, purchasedLottos);
        printResult(prizeResult);
    }

    public void getMoneyInput() {
        try {
            String moneyInput = InputView.inputMoney();
            validateMoneyInput(moneyInput);
            this.money = new Money(Integer.parseInt(moneyInput));
        } catch (WrongMoneyInputException | NonPositiveMoneyException | WrongMoneyUnitException e) {
            System.out.println(e.getMessage());
            getMoneyInput();
        }
    }

    public void printUserLotto() {
        List<Lotto> lottos = LottoGenerator.generateLottoGroup(money.getLottoTicketCount());
        this.purchasedLottos = new PurchasedLottos(lottos);
        OutputView.printLottoTicketCount(money.getLottoTicketCount());
        OutputView.printLottoTicket(purchasedLottos.getLottos());
    }

    public void getWinningLotto() {
        try {
            String lotto = InputView.inputWinningLotto();
            validateLottoInput(lotto);
            List<Integer> lottoNumbers = LottoUtils.lottoNumbersParser(lotto);
            getBonusnumber(lottoNumbers);
        } catch (WrongInputPatternException | WrongLottoSizeException | WrongRangeLottoNumberException e) {
            System.out.println(e.getMessage());
            getWinningLotto();
        }
    }

    public void getBonusnumber(List<Integer> lottoNumbers) {
        try {
            String bonus = InputView.inputBonusNumber();
            validateBonusNumberInput(bonus);
            int bonusNumber = LottoUtils.bonusNumberParser(bonus);
            this.winningLotto = new WinningLotto(lottoNumbers, bonusNumber);
        } catch (WrongBonusNumberPatternException | DuplicateLottoNumberException | WrongRangeLottoNumberException e) {
            System.out.println(e.getMessage());
            getBonusnumber(lottoNumbers);
        }
    }

    public void calculateResult(WinningLotto winningLotto, PurchasedLottos purchasedLottos) {
        this.prizeResult = new PrizeResult();
        prizeResult.calculateResult(winningLotto, purchasedLottos);
    }

    public void printResult(PrizeResult prizeResult) {
        OutputView.printResult(prizeResult);
        earningRate = new EarningRate(money, prizeResult);
        OutputView.printEarningRate(earningRate.getEarningRate());
    }

    public void validateLottoInput(String lotto) {
        if (!LOTTO_INPUT_PATTERN.matcher(lotto).matches()) {
            throw new WrongInputPatternException();
        }
    }

    public void validateBonusNumberInput(String bonus) {
        if (!NUMBER_INPUT_PATTERN.matcher(bonus).matches()) {
            throw new WrongBonusNumberPatternException();
        }
    }

    public void validateMoneyInput(String moneyInput) {
        if (!NUMBER_INPUT_PATTERN.matcher(moneyInput).matches()) {
            throw new WrongMoneyInputException();
        }
    }

}
