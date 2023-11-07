package lotto.object;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    public Integer lottoPurchaseNumber;
    private String purchaseAmount;
    private Integer bonusNumber;
    private List<Integer> lottoWinningNumbers;

    public Integer getLottoPurchaseNumber() {
        return lottoPurchaseNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public Integer getPurchaseAmount() {
        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> getLottoWinningNumbers() {
        return lottoWinningNumbers;
    }

    public void purchaseAmountInput() {
        do {
            System.out.println("구입금액을 입력해 주세요.");
            purchaseAmount = readLine();
        } while (!AmountInputValidation());
    }

    public void lottoWinningNumberInput() {
        do {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = readLine();
            lottoWinningNumbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).boxed().toList();
        } while (!winningNumberValidation(lottoWinningNumbers));
    }

    public void bonusNumberInput() {
        do {
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNumber = Integer.parseInt(readLine());
        } while (!bonusInputValidation());


    }

    private void amountValidation() {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(purchaseAmount);
        if (!matcher.matches())
            throw new IllegalArgumentException();

        if (Integer.parseInt(purchaseAmount) % Host.PURCHASEUNIT != 0)
            throw new IllegalArgumentException();
        lottoPurchaseNumber = Integer.parseInt(purchaseAmount) / Host.PURCHASEUNIT;

    }

    private void bonusValidaiton() {
        if (bonusNumber <= 0 || bonusNumber > 45)
            throw new IllegalArgumentException();

        if (lottoWinningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean AmountInputValidation() {
        try {
            amountValidation();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
        }
        return false;
    }

    private boolean winningNumberValidation(List<Integer> lottoWinningNumbers) {
        try {
            Lotto lotto = new Lotto(lottoWinningNumbers);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호를 입력하는 데 에러가 발생하였습니다.");
        }
        return false;
    }

    private boolean bonusInputValidation() {
        try {
            bonusValidaiton();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스 번호를 입력하는 데 에러가 발생하였습니다. 현재 보너스 번호 : " + bonusNumber);
        }
        return false;
    }


}
