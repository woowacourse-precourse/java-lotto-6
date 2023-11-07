package lotto.service;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Stat;
import lotto.domain.Lotto;
import lotto.validator.NumberValidator;
import lotto.domain.Admin;




public class AdminLottoService {
    List<Integer> winningNumber;

    public List<Integer> initWinningNumber(String[] winningNumbers) {
        winningNumber = new ArrayList<Integer>();
        NumberValidator.validateInputWinningNumber(winningNumbers);
        for (int i = 0; i < winningNumbers.length; i++) {
            int parseWinningNumber = Integer.parseInt(winningNumbers[i]);
            NumberValidator.validateNumberRange(parseWinningNumber);
            winningNumber.add(parseWinningNumber);
        }
        return winningNumber;
    }

    public String[] splitWinningNumbers(String winningNumberStr) {
        String winningNumbers = winningNumberStr.replaceAll(" ", "");
        String[] splitCarNameList = winningNumbers.split(",", -1);
        return splitCarNameList;
    }

    public int parseIntBonusNumber(String bonusNumberStr) {
        int bonusNumber = Integer.parseInt(bonusNumberStr);
        NumberValidator.validateNumberRange(bonusNumber);
        NumberValidator.validateBonusNumberContainsWinningNumber(winningNumber, bonusNumber);
        return bonusNumber;
    }

    public Admin setAdmin(List<Integer> winningNumbers, int bonusNumber) {
        return new Admin(winningNumbers, bonusNumber);
    }

    public void compareCorrectLottoNumbers(List<Lotto> userLottos, List<Integer> winnerNumber, int index, Stat lottoCorrectStat, int bonusNumber) {
        List<Integer> userNumbers = userLottos.get(index).getNumbers();
        List<Integer> correctLottoNumbers = userNumbers.stream()
                .filter(userNumber -> winnerNumber.contains(userNumber))
                .collect(Collectors.toList());
        lottoCorrectStat.findCorrectName(correctLottoNumbers, userNumbers, bonusNumber);
    }
}
