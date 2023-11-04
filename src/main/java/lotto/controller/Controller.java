package lotto.controller;


import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessage;
import lotto.constants.Message;
import lotto.domain.Lotto;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.ValidationService;
import lotto.utils.ParseUtils;

import java.util.List;


public class Controller {

    InputService inputService = new InputService();
    LottoService lottoService = new LottoService();
    ValidationService validationService = new ValidationService();

    ParseUtils parseUtils = new ParseUtils();

    public void run() {
        createUserLottos();
        showUserLottos();
        createWinningLotto();
        showResult();
    }


    private void showResult() {
        System.out.println(Message.LOTTO_RESULT_MESSAGE);

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
        List<Integer> winningLottoNumbers = inputWinningLotto();
        int bonusNumber = inputBonusNumber();

        lottoService.setWinningLotto(winningLottoNumbers, bonusNumber);
    }

    private List<Integer> inputWinningLotto() {
        System.out.println(Message.WINNING_NUMBER_REQUEST_MESSAGE);

        while (true) {
            String inputWinningNumbers = Console.readLine();
            List<Integer> winningLotto = winningLottoValidationProcess(inputWinningNumbers);

            if (winningLotto != null) {
                return winningLotto;
            }
        }
    }

    public List<Integer> winningLottoValidationProcess(String inputWinningNumbers) {
        try {
            List<Integer> winningLotto = parseUtils.parseStringToIntegerList(inputWinningNumbers);
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
        int lottoAmount = inputService.inputAmount();
        lottoService.createUserLottos(lottoAmount);
    }

}
