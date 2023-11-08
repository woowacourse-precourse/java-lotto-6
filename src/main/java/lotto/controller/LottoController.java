package lotto.controller;

import lotto.*;
import lotto.util.ErrorMessage;
import lotto.validate.Check;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputWinningNumber;

public class LottoController {

    public static int setPurchaseAmount() {
        try {
            PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.inputLottoAmount());
            return purchaseAmount.lottoCount();
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INSERT_COIN.getMessage());
            return setPurchaseAmount();
        }
    }

    private static List<Integer> lottoNumber() {
        LottoNumber lottoNumber = new LottoNumber();
        return lottoNumber.getNumbers();
    }

    public static List<Lotto> setLottoNumber(int amount) {
        List<Lotto> lottoNumber = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(lottoNumber());
            lottoNumber.add(lotto);
        }
        return lottoNumber;
    }

    public static List<Integer> lottoNumbers() {
        try {
            List<Integer> winningNumber = inputWinningNumber();
            Lotto lotto = new Lotto(winningNumber);
            return lotto.getNumbers();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return lottoNumbers();
        }
    }

    public static int setBonusNumber(List<Integer> winningNumbers) {
        try {
            List<Integer> bonusNumber = inputBonusNumber();
            Check.bonusNumberCount(bonusNumber);
            Check.rightRange(bonusNumber);
            Check.numberDuplicate(winningNumbers,bonusNumber);
            return bonusNumber.get(0);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return setBonusNumber(winningNumbers);
        }
    }

    public static Winning getWinning(List<Lotto> lotto, List<Integer> winningNumbers, int bonusNumber) {
        Winning winning = new Winning();
        lotto.forEach(value -> {
            int matchCount = numberCount(winningNumbers, value);
            boolean isSecond = isMatchBonusNumber(bonusNumber, value);
            winning.setWinningTickets(matchCount, isSecond);
        });
        return winning;
    }

    private static boolean isMatchBonusNumber(int bonusNumber, Lotto lotto) {
        return lotto.getNumbers().stream()
                .mapToInt(Integer::intValue)
                .anyMatch(number -> number == bonusNumber);
    }

    private static int numberCount(List<Integer> winningNumbers, Lotto lotto) {
        int matchCount = 0;
        int bound = winningNumbers.size();
        for (int i = 0; i < bound; i++) {
            if (winningNumbers.contains(lotto.getNumbers().get(i))) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
