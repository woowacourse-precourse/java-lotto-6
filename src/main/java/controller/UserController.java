package controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import validation.LottoValidation;
import view.InputView;
import view.OutputMessage;

public class UserController {
    LottoValidation lottoValidation = new LottoValidation();
    InputView inputView = new InputView();

    List<Integer> winningLottoNumbers = new ArrayList<>();

    public int inputPriceHowManyLottos() {
        boolean isValidInput = false;
        String purchasePrice = "";
        while (!isValidInput) {
            try {
                inputView.showInputPriceToUser();
                purchasePrice = Console.readLine();
                if (lottoValidation.isPriceInteger(purchasePrice)) {
                    validationInputPrice(purchasePrice);
                }
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(purchasePrice);
    }

    private void validationInputPrice(String purchasePrice) {
        int price = Integer.parseInt(purchasePrice);

        if (!lottoValidation.validateInputPrice(price)) {
            throw new IllegalArgumentException("[ERROR] " + OutputMessage.OUTPUT_ERROR_PRICE_THOUSAND.getMessage());
        } else if (!lottoValidation.isBiggerThanZero(price)) {
            throw new IllegalArgumentException("[ERROR] " + OutputMessage.OUTPUT_ERROR_PRICE_ZERO.getMessage());
        }
    }

    public List<Integer> generateUserLottoNumber() {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                inputView.showInputLottoNumberToUser();
                String[] lottoNumbersByUser = Console.readLine().split(",");
                lottoValidation.lottoNumberCount(lottoNumbersByUser);
                for (String lottoNumber : lottoNumbersByUser) {
                    int validLottoNumber = 0;
                    if (lottoValidation.isLottoNubmerInteger(lottoNumber)) {
                        validLottoNumber = Integer.parseInt(lottoNumber);
                        validationLottoNumberInputByUser(validLottoNumber);
                    }
                    winningLottoNumbers.add(validLottoNumber);
                }
                lottoValidation.lottoNumberOverlap(winningLottoNumbers);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLottoNumbers;
    }

    private void validationLottoNumberInputByUser(int lottoNumber) {
        if (!lottoValidation.validateLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException("[ERROR]" + OutputMessage.OUTPUT_ERROR_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public int inputBonusNumber() {
        boolean isValidInput = false;
        int bonusNumber = 0;
        while (!isValidInput) {
            try {
                inputView.showInputBonusNumberToUser();
                String inputNumber = Console.readLine();
                if (lottoValidation.isLottoNubmerInteger(inputNumber)) {
                    bonusNumber = Integer.parseInt(inputNumber);
                    validationLottoNumberInputByUser(bonusNumber);
                }
                lottoValidation.isOverlapWithWinningNumbers(winningLottoNumbers, bonusNumber);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

}
