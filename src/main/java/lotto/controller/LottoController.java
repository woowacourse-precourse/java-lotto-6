package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.domain.LottoTicket;
import lotto.service.InputBonusNumberService;
import lotto.service.InputMoneyService;
import lotto.service.InputWinnerNumberService;
import lotto.util.LottoGenerator;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {


    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;




    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = new Validator();
    }

    public void start() {
        Long money = inputMoney(new InputMoneyService());

        List<LottoTicket> lottoTickets = buyLottoTicket(money / 1000);

        List<Integer> lottoWinNumbers = inputWinNumbers(new InputWinnerNumberService());

        lottoWinNumbers.add(inputBonusNumber());


        /*
            금액에 따른 로또 번호 뽑기!

         */

        /*
        당첨 번호 입
         */

    }

    private Integer inputBonusNumber() {
        try {
            outputView.printBeforeInputBonusNumber();
            InputBonusNumberService inputBonusNumberService = new InputBonusNumberService();
            String bonusNumberInput = inputView.inputBonusNumber();
            inputBonusNumberService.checkRightBonusNumberInput(validator, bonusNumberInput);
            return Integer.parseInt(bonusNumberInput);
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return inputBonusNumber();
        }
    }

    private List<LottoTicket> buyLottoTicket(long count) {
        outputView.printBeforeBuyLotto(count);
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for(int i=0; i<count; i++){
             lottoTickets.add(new LottoTicket(lottoGenerator.generateNumberList()));
            outputView.printTicket(lottoGenerator.generateNumberList());
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
            inputWinnerNumberService.checkRightWinnerNumbers(validator,
                inputView.inputWinnerNumbers());
            return inputWinnerNumberService.convertedWinnerNumbers();
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return inputWinNumbers(inputWinnerNumberService);
        }
    }

}
