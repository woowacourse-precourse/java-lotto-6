package lotto.controller;


import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessage;
import lotto.constants.Message;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.ValidationService;
import lotto.utils.ParseUtils;

import java.util.List;


public class Controller {

    LottoService lottoService = new LottoService();
    ValidationService validationService = new ValidationService();

    ParseUtils parseUtils = new ParseUtils();

    public void run() {
        createUserLottos();
        showUserLottos();
        createWinningLotto();
        createBonusLotto();
    }

    private void createBonusLotto() {
        int bonusNumber = inputBonusNumber();
        lottoService.setBonusNumber(bonusNumber);
    }

    private int inputBonusNumber() {
        System.out.println("\n" + Message.BONUS_NUMBER_REQUEST_MESSAGE);

        while (true) {
            String inputBonusNumber = Console.readLine();
            try {
                int bonusNumber = parseUtils.parseStringToInt(inputBonusNumber);
                Lotto winningLotto = lottoService.getWinningLotto();
                validationService.bonusNumberValidation(bonusNumber, winningLotto);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.BONUS_NUMBER_FORMAT.getMessage());
            }
        }
    }



    private void createWinningLotto() {
        Lotto winningLotto = inputWinningLotto();
        lottoService.setWinningLotto(winningLotto);
    }

    private Lotto inputWinningLotto() {
        System.out.println(Message.WINNING_NUMBER_REQUEST_MESSAGE);

        while (true) {
            String inputWinningNumbers = Console.readLine();
            Lotto winningLotto = winningLottoValidationProcess(inputWinningNumbers);

            if (winningLotto != null) {
                return winningLotto;
            }
        }
    }

    public Lotto winningLottoValidationProcess(String inputWinningNumbers) {
        try {
            Lotto winningLotto = parseUtils.parseStringToLotto(inputWinningNumbers);
            validationService.winningLottoNumberValidation(winningLotto);

            return winningLotto;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.WINNING_NUMBER_FORMAT.getMessage());
        }
        return null;
    }

    private void showUserLottos() {
        int userLottoCount = lottoService.getUserLottoCount();
        System.out.println("\n" + userLottoCount + Message.USER_LOTTOS_COUNT_MESSAGE);
        List<Lotto> userLottos = lottoService.getUserLottos();

        for (Lotto lotto : userLottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void createUserLottos() {
        int lottoAmount = inputAmount();
        lottoService.createUserLottos(lottoAmount);
    }


    public int inputAmount() {
        System.out.println(Message.AMOUNT_REQUEST_MESSAGE);

        while (true) {
            String inputAmount = Console.readLine();
            Integer amount = amountValidationProcess(inputAmount);

            if (amount != null) {
                return amount;
            }
        }

    }

    public Integer amountValidationProcess(String inputAmount) {
        try {
            int amount = parseUtils.parseStringToInt(inputAmount);
            validationService.amountValidation(amount);

            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
