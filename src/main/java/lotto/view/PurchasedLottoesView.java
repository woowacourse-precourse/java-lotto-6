package lotto.view;

import java.util.List;

public class PurchasedLottoesView {
    // 구매한 로또 내역을 보여줄 클래스입니다.
    public void printNumberOfIssues(int numberOfIssues) {
        System.out.println("\n" + numberOfIssues + "개를 구매했습니다.");
    }

    public void printPurchasedLottoes(List<List<Integer>> lottoes) {
        for (int i = 0; i < lottoes.size(); i++) {
            System.out.println(getLottoNumber(lottoes.get(i)));
        }
    }

    private String getLottoNumber(List<Integer> lotto) {
        String numbers = "[";
        for (int i = 0; i < lotto.size(); i++) {
            numbers = numbers.concat(lotto.get(i) + ", ");
        }
        numbers = numbers.substring(0, numbers.length() - 2);
        numbers = numbers.concat("]");

        return numbers;
    }
}
