package lotto.view;

import java.util.List;

public class OutputView {

    public void printLottoBuyingResult(int lottoAmount, List<List<Integer>> lottoNumbers) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
        for (List<Integer> lottoNumber : lottoNumbers) {
            printNumbers(lottoNumber);
            System.out.println();
        }
    }

    private void printNumbers(List<Integer> numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(numbers.get(i));
        }
        System.out.print("]");
    }
}
