package ui;

import camp.nextstep.edu.missionutils.Console;
import domain.LottoPurchaseManager;

public class LottoPurchaseConsoleUI {

    private final LottoPurchaseManager manager;

    public LottoPurchaseConsoleUI(LottoPurchaseManager manager) {
        this.manager = manager;
    }

    public int startPurchaseProcess() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int purchaseAmount = Integer.parseInt(Console.readLine());
                return manager.calculateNumOfLotto(purchaseAmount);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자(정수)만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
