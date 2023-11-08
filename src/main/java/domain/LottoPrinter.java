package domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPrinter {
    public static void printFormattedLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            printSortedLotto(lotto);
        }
    }

    private static void printSortedLotto(Lotto lotto) {
        List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers()); // 복사하여 새 리스트 생성
        sortedNumbers.sort(Integer::compareTo); // 오름차순 정렬

        System.out.print("[");
        for (int i = 0; i < sortedNumbers.size(); i++) {
            System.out.print(sortedNumbers.get(i));
            if (i < sortedNumbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}