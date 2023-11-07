package lotto.view;

import java.util.List;

public class OutputView {

    public void displayPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount+"개를 구매했습니다.");
    }

    public void printInfo(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
