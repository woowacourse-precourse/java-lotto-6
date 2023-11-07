package lotto.machine.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleUI implements UI {

    private static final int ZERO = 0;
    private static final int MILLION = 100000000;

    private static final int LOTTO_MAX_VALUE = 45;
    private static final int LOTTO_MIN_VALUE = 1;

    @Override
    public void requirePurchaseView() {
        System.out.println("구입금액을 입력해주세요.");
    }

    @Override
    public int inputPurchaseAmount() {
        int purchaseAmount = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                purchaseAmount = validateInputPurchaseAmount();
                isValid = true;
            } catch (NumberFormatException numberFormatException) {
                System.err.println("[ERROR] 값은 정수로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }


    @Override
    public void outputPurchaseLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            System.out.println('[' + lotto.toString() + ']');
        });
    }

    @Override
    public void requireWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new LinkedList<>();

        boolean isValid = false;

        while (!isValid) {

            try {
                winningNumbers = validateInputWinningNumbers();
                isValid = true;
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 값은 정수로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }

        }
        return winningNumbers;
    }




    @Override
    public void requireBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public int inputBonusNumber() {
        int bounusNumber = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                bounusNumber = validateInputBonusNumber();
                isValid = true;
            } catch (NumberFormatException numberFormatException) {
                System.err.println("[ERROR] 값은 정수로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        return bounusNumber;
    }



    @Override
    public void outputGameResult(
            int matchThree, int matchFour, int matchFiveIncludeBonus, int matchFiveExceptBonus, int matchSix, double rateOfReturn
    ) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchThree + '개');
        System.out.println("4개 일치 (50,000원) - " + matchFour + '개');
        System.out.println("5개 일치 (1,500,000원) - " + matchFiveIncludeBonus + '개');
        System.out.println("5개 일치, 보너스 불 일치 (30,000,000원) - " + matchFiveIncludeBonus + '개');
        System.out.println("6개 일치 (2,000,000,000원) - " + matchSix + '개');
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }


    private int validateInputPurchaseAmount() {
        int purchaseAmount = 0;
        purchaseAmount = Integer.parseInt(Console.readLine());

        if (purchaseAmount < ZERO || purchaseAmount > MILLION)
            throw new IllegalArgumentException("[ERROR] 숫자의 정의된 값의 범위를 벗어났습니다.(0~1억)");

        if (purchaseAmount % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 숫자의 값은 1000의 배수여야 합니다.");

        return purchaseAmount;
    }

    private List<Integer> validateInputWinningNumbers() {
        String[] result = Console.readLine().split(",");
        if (result.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 골라야 합니다.");
        }

        return Arrays.stream(result)
                .map(Integer::parseInt)
                .peek(number -> {
                    if (number < LOTTO_MIN_VALUE || number > LOTTO_MAX_VALUE) {
                        throw new IllegalArgumentException("[ERROR] 숫자는 1에서 45 사이여야 합니다.");
                    }
                })
                .collect(Collectors.toList());
    }

    private int validateInputBonusNumber() {
        int bonusNumber = 0;
        bonusNumber = Integer.parseInt(Console.readLine());

        if (bonusNumber < LOTTO_MIN_VALUE || bonusNumber > LOTTO_MAX_VALUE)
            throw new IllegalArgumentException("[ERROR] 숫자는 1에서 45 사이여야 합니다.");

        return bonusNumber;
    }
}
