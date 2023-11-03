package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int inputLottoAmount() {
        int amount = Integer.parseInt(Console.readLine());
        validateAmount(amount);
        return amount;
    }

    public static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = inputLottoAmount();
    }
}
