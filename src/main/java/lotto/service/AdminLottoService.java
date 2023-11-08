package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Stat;
import lotto.domain.User;
import lotto.validator.NumberValidator;
import lotto.domain.Admin;

public class AdminLottoService {
    List<Integer> winningNumber;
    Admin admin;

    public void setAdmin(List<Integer> winningNumbers, int bonusNumber) {
        admin = new Admin(winningNumbers, bonusNumber);
    }

    public List<Integer> initWinningNumber(String[] winningNumbers) {
        winningNumber = new ArrayList<>();
        NumberValidator.validateInputWinningNumber(winningNumbers);
        for (String number : winningNumbers) {
            int parseWinningNumber = Integer.parseInt(number);
            NumberValidator.validateNumberRange(parseWinningNumber);
            winningNumber.add(parseWinningNumber);
        }
        return winningNumber;
    }

    public String[] splitWinningNumbers(String winningNumberStr) {
        String winningNumbers = winningNumberStr.replaceAll(" ", "");
        return winningNumbers.split(",", -1);
    }

    public int parseIntBonusNumber(String bonusNumberStr) {
        int bonusNumber = Integer.parseInt(bonusNumberStr);
        NumberValidator.validateNumberRange(bonusNumber);
        NumberValidator.validateInputBonusNumber(bonusNumberStr);
        NumberValidator.validateBonusNumberContainsWinningNumber(winningNumber, bonusNumber);
        return bonusNumber;
    }

    public void compareCorrectLottoNumbers(User user, Stat lottoCorrectStat) {
        StatLottoService statLottoService = new StatLottoService();
        for (int index = 0; index < user.getLottoList().size(); index++) {
            List<Integer> userNumbers = user.getLottoList().get(index).getNumbers();
            List<Integer> correctLottoNumbers = userNumbers.stream()
                    .filter(admin.getWinnerNumber()::contains)
                    .collect(Collectors.toList());
            statLottoService.findCorrectName(correctLottoNumbers, userNumbers, admin.getBonusNumber(),
                    lottoCorrectStat);
        }
    }
}
