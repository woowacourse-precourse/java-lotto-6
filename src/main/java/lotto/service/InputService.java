package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessage;
import lotto.constants.Message;
import lotto.domain.Lotto;
import lotto.utils.ParseUtils;

import java.util.List;

public class InputService {

    LottoService lottoService = new LottoService();
    ParseUtils parseUtils = new ParseUtils();
    ValidationService validationService = new ValidationService();

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

    private Integer amountValidationProcess(String inputAmount) {
        try {
            int amount = parseUtils.parseStringToInt(inputAmount);
            validationService.amountValidation(amount);

            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.AMOUNT_FORMAT.getMessage());
        }

        return null;
    }

    public List<Integer> inputWinningLottoNumbers() {
        System.out.println(Message.WINNING_NUMBER_REQUEST_MESSAGE);

        while (true) {
            String inputWinningNumbers = Console.readLine();
            List<Integer> winningLottoNumbers = winningLottoNumberValidationProcess(inputWinningNumbers);

            if (winningLottoNumbers != null) {
                return winningLottoNumbers;
            }
        }
    }

    private List<Integer> winningLottoNumberValidationProcess(String inputWinningNumbers) {
        try {
            List<Integer> winningLottoNumbers = parseUtils.parseStringToIntegerList(inputWinningNumbers);
            validationService.winningLottoNumberValidation(winningLottoNumbers);

            return winningLottoNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.WINNING_NUMBER_FORMAT.getMessage());
        }

        return null;
    }

    public int inputBonusNumber() {
        System.out.println(Message.BONUS_NUMBER_REQUEST_MESSAGE);

        while (true) {
            String inputBonusNumber = Console.readLine();
            Integer bonusNumber = bonusNumberValidationProcess(inputBonusNumber);

            if (bonusNumber != null) {
                return bonusNumber;
            }
        }
    }

    private Integer bonusNumberValidationProcess(String inputBonusNumber) {
        try {
            int bonusNumber = parseUtils.parseStringToInt(inputBonusNumber);
            Lotto winningLotto = lottoService.getWinningLotto();

            validationService.bonusNumberValidation(bonusNumber, winningLotto);

            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BONUS_NUMBER_FORMAT.getMessage());
        }

        return null;
    }




}
