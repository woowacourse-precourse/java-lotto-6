package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessage;
import lotto.constants.Message;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
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


    public WinningLotto inputWinningLottoNumbersAndBonusNumber() {
        List<Integer> winningLottoNumbers = inputWinningLottoNumbers();
        int bonusNumber = inputBonusNumber(winningLottoNumbers);

        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }



    private List<Integer> inputWinningLottoNumbers() {
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

    private int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(Message.BONUS_NUMBER_REQUEST_MESSAGE);

        while (true) {
            String inputBonusNumber = Console.readLine();
            Integer bonusNumber = bonusNumberValidationProcess(inputBonusNumber, winningNumbers);

            if (bonusNumber != null) {
                return bonusNumber;
            }
        }
    }

    private Integer bonusNumberValidationProcess(String inputBonusNumber, List<Integer> winningNumbers) {
        try {
            int bonusNumber = parseUtils.parseStringToInt(inputBonusNumber);

            validationService.bonusNumberValidation(bonusNumber, winningNumbers);

            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BONUS_NUMBER_FORMAT.getMessage());
        }

        return null;
    }




}
