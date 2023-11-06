package lotto.controller;

import static lotto.constant.NumberConstant.MONEY_UNIT;
import static lotto.constant.NumberConstant.PERCENT;
import static lotto.constant.NumberConstant.ZERO;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.service.InputBonusNumberService;
import lotto.service.InputMoneyService;
import lotto.service.InputWinnerNumberService;
import lotto.service.LottoService;
import lotto.util.LottoGenerator;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {


    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;
    private final LottoService lottoService;


    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = new Validator();
        this.lottoService = new LottoService();
    }

    public void start() {
        Long money = inputMoney(new InputMoneyService());
        List<LottoTicket> lottoTickets = buyLottoTicket(money / MONEY_UNIT.getNumber());
        List<Integer> lottoWinNumbers = inputWinNumbers(new InputWinnerNumberService());
        Integer bonusNumber = inputBonusNumber(lottoWinNumbers);
        Long result = lottoService.calculateMoney(lottoTickets, lottoWinNumbers, bonusNumber);
        outputView.printResult();
        outputView.printYield(calculateYield(result, money));
    }

    private static double calculateYield(Long result, Long money) {
        double v = result.doubleValue();
        double yield = v / money * PERCENT.getNumber();
        return yield;
    }

    private Integer inputBonusNumber(List<Integer> lottoWinNumbers) {
        try {
            outputView.printBeforeInputBonusNumber();
            InputBonusNumberService inputBonusNumberService = new InputBonusNumberService();
            String bonusNumberInput = inputView.inputBonusNumber();
            inputBonusNumberService.checkRightBonusNumberInput(validator, lottoWinNumbers,
                bonusNumberInput);
            return Integer.parseInt(bonusNumberInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputBonusNumber(lottoWinNumbers);
        }
    }

    private List<LottoTicket> buyLottoTicket(long count) {
        outputView.printBeforeBuyLotto(count);
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int ticketNum = ZERO.getNumber(); ticketNum < count; ticketNum++) {
            lottoTickets.add(new LottoTicket(lottoGenerator.generateNumberList()));
            outputView.printTicket(lottoTickets.get(ticketNum).getNumbers());
        }
        return lottoTickets;
    }


    private Long inputMoney(InputMoneyService inputMoneyService) {
        try {
            outputView.printBeforeInputMoney();
            String money = inputView.inputMoney();
            inputMoneyService.getRightMoneyProcess(validator, money);
            return Long.parseLong(money);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputMoney(inputMoneyService);
        }
    }

    private List<Integer> inputWinNumbers(InputWinnerNumberService inputWinnerNumberService) {
        inputWinnerNumberService.init();
        try {
            outputView.printBeforeInputWinNumbers();
            inputWinnerNumberService.checkRightWinnerNumbers(validator,
                inputView.inputWinnerNumbers());
            return inputWinnerNumberService.convertedWinnerNumbers();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputWinNumbers(inputWinnerNumberService);
        }
    }

}
