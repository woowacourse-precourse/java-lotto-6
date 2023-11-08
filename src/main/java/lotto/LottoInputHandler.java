package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class LottoInputHandler {
    public int getPurchaseAmount() {
        int purchaseAmount = 0;
        boolean isValidAmount = false;
        boolean isNumeric = false;
        while (!isValidAmount) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();

                for (int i = 0; i < input.length(); i++) {
                    if (!Character.isDigit(input.charAt(i))) {
                        throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
                    }
                    isNumeric = true;
                }
                purchaseAmount = Integer.parseInt(input);

                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
                }
                isValidAmount = true;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력
            }
        }
        return purchaseAmount;
    }

    public List<Integer> getWinningNumbers() {
        boolean isValidAmount = false;
        List<Integer> newNumbers = new ArrayList<>();
        while (!isValidAmount) {
            try {

                System.out.println("당첨 번호를 입력해 주세요.");
                String inputNumbers = Console.readLine();
                List<String> numbers = (Arrays.asList(inputNumbers.split(",")));

                for (String s : numbers) {
                    newNumbers.add(Integer.parseInt(s));
                }
                Set<Integer> numSet = new HashSet<>(newNumbers);
                if (numbers.size() != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨번호는 6자리로 입력해주세요.");
                }
                if (numSet.size() != numbers.size()) {
                    throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력해주세요.");
                }
                isValidAmount = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력
            }

        }
        return newNumbers;
    }
}
