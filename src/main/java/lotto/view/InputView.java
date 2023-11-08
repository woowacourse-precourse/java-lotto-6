package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

import lotto.Lotto;
import lotto.Application;

public class InputView {

    public static int readPurchaseAmount() {
        while (true) {
            System.out.print("구입 금액을 입력해 주세요: ");
            String input = Console.readLine();

            try {
                int purchaseAmount = parseAndValidateInput(input);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입금액은 숫자만 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parseAndValidateInput(String input) {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위어야 합니다.");
        }
        return purchaseAmount;
    }

    public static <Lotto> Lotto readWinningLotto() {
        while (true) {
            try {
                System.out.print("당첨 번호를 입력해 주세요 (쉼표로 구분된 6개 숫자): ");
                String[] winningNumbersStr = Console.readLine().split(",");

                if (winningNumbersStr.length != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 숫자를 입력해야 합니다.");
                }

                List<Integer> winningNumbers = parseNumbers(winningNumbersStr);

                if (winningNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45까지의 숫자로 입력해야 합니다.");
                }

                if (winningNumbers.stream().distinct().count() != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
                }

                return (Lotto) Application.createLotto(winningNumbers);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseNumbers(String[] numbersStr) {
        return List.of(numbersStr).stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int readBonusNumberUI() {
        System.out.print("보너스 번호를 입력해 주세요. ");
        String input = Console.readLine().trim();

        // 입력값이 공백인 경우 에러 메시지 출력
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해주세요.");
        }

        return Integer.parseInt(input);
    }

    public static int readBonusNumber(Lotto winningNumber) {
        while (true) {
            try {
                int bonusNumber = readBonusNumberUI();

                if (bonusNumber < 1 || bonusNumber > 45)
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45까지의 숫자로 입력해야 합니다.");

                if (winningNumber.containsNumber(bonusNumber))
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");

                // 올바른 입력일 경우 보너스 번호 반환
                return bonusNumber;
            } catch (NumberFormatException e) {
                // 숫자로 변환할 수 없는 입력값이 들어온 경우 에러 메시지 출력
                System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                // 기타 유효성 검사 실패한 경우 에러 메시지 출력 후 다시 입력을 받기 위해 루프 계속 진행
                System.out.println(e.getMessage());
            }
        }
    }
}