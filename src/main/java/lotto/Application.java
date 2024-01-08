package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 구입 금액 입력 -> 입력 금액 검증
        int purchaseAmount = receivePurchaseAmount();
        // 발행된 로또 수량 출력, 번호를 오름 차순으로 출력 [ ]

        // 당첨 번호 6개 입력(쉼표로 구분) -> 입력 숫자 검증(1~45 사이 중복 없는 숫자)

        // 보너스 번호 입력 -> 입력 숫자 검증(1~45 사이 중복 없는 숫자)

        // 몇개가 일치하는지 확인

        // 당첨 통계 출력

        // 수익률 출력. 소수 둘째 자리에서 반올림
    }

    private static int receivePurchaseAmount() {
        int inputAmount = 0;
        while (inputAmount == 0) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            try {
                inputAmount = Integer.parseInt(input);
                validatePurchaseAmount(inputAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1000 단위의 금액을 입력하세요.");
            }
        }
        return inputAmount;
    }

    private static void validatePurchaseAmount(int inputAmount) {
        if (inputAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
