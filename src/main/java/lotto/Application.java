package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private int purchaseAmount;
    private int purchaseCount;
    private List<List<Integer>> userNumbers = new ArrayList<>();
    private List<Integer> selectNumbers = new ArrayList<>();
    private final int[] ranking = new int[8];

    public static void main(String[] args) {
        Application app = new Application();
        app.play();
    }

    public void play() {
        try {
            getPurchaseAmount();
            getPurchaseCount();
            setNumbers();
            getSelectNumbers();
            lottoResult();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            if (e.getMessage().contains("로또 구입 금액")) {
                play();
            } else {
                getSelectNumbers();
            }
        }
    }

    private void getPurchaseAmount() {
        System.out.println("구입할 금액을 입력해 주세요.");
        purchaseAmount = Integer.parseInt(Console.readLine());

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위여야 합니다.");
        }
        getPurchaseCount();
        System.out.printf("%d개를 구매했습니다.\n", purchaseCount);
    }

    private void getPurchaseCount() {
        purchaseCount = purchaseAmount / 1000;
    }

    private void setNumbers() {
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = getNumbers();
            userNumbers.add(numbers);
            System.out.println(numbers);
            checkLottoNumbers(numbers);
        }
    }

    private List<Integer> getNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    private void getSelectNumbers() {
        System.out.println("구입한 로또 번호를 입력해 주세요.");
        System.out.printf("쉼표로 구분된 6개의 숫자를 입력해주세요: ");
        String inputNumbers = Console.readLine();
        String[] numbersArray = inputNumbers.split(",");
        if (numbersArray.length != 6) {
            throw new IllegalArgumentException("로또 번호는 6개를 입력해야 합니다.");
        }
        for (String number : numbersArray) {
            selectNumbers.add(Integer.parseInt(number));
        }
        System.out.println("보너스 번호를 입력해 주세요: ");
        selectNumbers.add(Integer.parseInt(Console.readLine()));
        validate();
    }

    private void validate() {
        for (Integer number : selectNumbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void checkLottoNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        int correctLottoNumbers = 0;
        for (int i = 0; i < sortedNumbers.size(); i++) {
            if (selectNumbers.contains(sortedNumbers.get(i))) {
                correctLottoNumbers++;
            }
        }
        if (correctLottoNumbers == 5 && sortedNumbers.contains(selectNumbers.get(6))) {
            ranking[0]++; // 2등.
            return;
        }
        ranking[7 - correctLottoNumbers]++;
    }

    private void lottoResult() {
        System.out.println("당첨 통계\n---");

        System.out.printf("3개 일치 (5,000원) - %d개\n", ranking[4]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", ranking[3]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", ranking[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", ranking[0]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", ranking[1]);
        double profitRate = (double) (ranking[4] * 5000 + ranking[3] * 50000 + ranking[2] * 1500000 + ranking[0] * 30000000 + ranking[1] * 2000000000) / purchaseAmount * 100;
        profitRate = Math.round(profitRate * 10.0) / 10.0;
        System.out.printf("총 수익률은 %.1f", profitRate);
        System.out.print("%입니다.");
    }
}
