package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final String PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_GUIDE = "보너스 번호를 입력해 주세요.";
    private static final String SPLIT_COMMA = ",";
    private static final int PURCHASE_UNIT = 1000;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT_NUMBER = 6;

    private List<Lotto> lottos;
    private Lotto winningLotto;

    public String readAmount() {
        System.out.println(PURCHASE_AMOUNT_GUIDE);
        String purchaseAmountText = readLine();
        return purchaseAmountText;
    }

    public int purchaseAmountTextToInt(String purchaseAmountText) {
        int purchaseAmount = Integer.parseInt(purchaseAmountText);
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public int amountToIssueCount(int purchaseAmount) {
        int issueCount = purchaseAmount / PURCHASE_UNIT;
        return issueCount;
    }

    public List<Lotto> generate(int issueCount) {
        for (int i = 0; i < issueCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    START_NUMBER, END_NUMBER, COUNT_NUMBER
            );
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public String readWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_GUIDE);
        String winningNumberText = readLine();
        return winningNumberText;
    }

    public Lotto textToLotto(String winningNumberText) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumberText.split(SPLIT_COMMA)) {
            int winningNumber = Integer.parseInt(number);
            if (!winningNumbers.contains(winningNumber)) {
                winningNumbers.add(winningNumber);
            }
        }
        validateWinningNumber(winningNumbers);
        winningLotto = new Lotto(winningNumbers);
        return winningLotto;
    }

    public int readBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_GUIDE);
        String bonusNumberText = readLine();
        int bonusNumber = Integer.parseInt(bonusNumberText);
        return bonusNumber;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % PURCHASE_UNIT!=0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size()!=6) {
            throw new IllegalArgumentException();
        }
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
