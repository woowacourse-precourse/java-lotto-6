package lotto;

import java.util.Scanner;

public class Amount {
    private static final Scanner scanner = new Scanner(System.in);
    private final int amount;

    public Amount() {
        this.amount = requestAndValidateAmount();
    }

    private int requestAndValidateAmount() {
        int inputAmount;
        while (true) {
            try {
                System.out.print("로또를 구매할 금액을 입력하세요: ");
                String input = scanner.nextLine();
                inputAmount = Integer.parseInt(input); //throw NumberFormatException
                validate(inputAmount); //throw IllegalArgumentException
                System.out.println((inputAmount / 1000) + "개의 로또를 구매했습니다.");
                break; // 올바른 입력이면 루프를 빠져나감
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return inputAmount;
    }

    private void validate(int inputAmount){
        if (inputAmount <= 0 || inputAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 투입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}