package lotto.view;

public class OutputView {

    public int printPurchases(int numberOfLotto) {
        int number = numberOfLotto / 1000;
        System.out.println(number + "개를 구매했습니다.");
        return number;
    }
}
