package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LottoService {
    private int lotto1st = 0;
    private int lotto2st = 0;
    private int lotto3st = 0;
    private int lotto4st = 0;
    private int lotto5st = 0;



    public int moneyInput() {
        System.out.print("구입금액을 입력해 주세요.");
        System.out.println();
        return Integer.parseInt(Console.readLine());
    }

    public int lottoCount(int moneyInput) {
        int lottoCount = moneyInput / 1000;
        System.out.println();
        System.out.printf("%d개를 구입했습니다.\n", lottoCount);
        return lottoCount;
    }

    public List<Integer> randomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public List<Lotto> lottoIssuance(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i <lottoCount; i++) {
            Lotto lotto = new Lotto(randomNumber());
            lottos.add(lotto);
        }
        return lottos;
    }

    public void lottosPrint(List<Lotto> lottos) {
        for (int i = 0; i <lottos.size(); i++) {
            System.out.println(lottos.get(i).toString());
        }
    }

    public int[] winningNumberInput() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumberStr = Console.readLine().split(",");
        int[] winningNumberInt = Arrays.stream(winningNumberStr).mapToInt(Integer::parseInt).toArray();
        return winningNumberInt;
    }

    public int bonusNumberInput() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    // 숫자 비교기 제작
    public int compareNumbers(Lotto lotto, int[] winningNumber) {
        int equalsNumber = 0;
        for (int i = 0; i < 6; i++) {
            if (lotto.getNumbers().get(i) == winningNumber[i]) {
                equalsNumber++;
            }
        }
        return equalsNumber;
    }

    public Integer addLottoWinner(int equalsNumber) {
        if (equalsNumber == 6) return lotto1st++;
        if (equalsNumber == 5) return lotto3st++;
        if (equalsNumber == 4) return lotto4st++;
        if (equalsNumber == 3) return lotto5st++;
        return null;
    }

    public void lottoResult(List<Lotto> lottos, int[] winningNumber) {
        for (int i = 0; i < lottos.size(); i++) {
            int equalsNumber = compareNumbers(lottos.get(i), winningNumber);
            addLottoWinner(equalsNumber);
        }
    }

    public double profitRate(int moneyInput) {
        Long totalProfit = (long) ((lotto1st*2000000000) + (lotto2st*30000000) + (lotto3st*1500000) + (lotto4st*50000) + (lotto5st*5000));
        return (totalProfit / moneyInput) * 100;
    }

    public void lottoResultPrint(int moneyInput) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n",lotto5st);
        System.out.printf("4개 일치 (50,000원) - %d개\n",lotto4st);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n",lotto3st);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",lotto2st);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n",lotto1st);
        System.out.printf("총 수익률은 %.1f %%입니다.",profitRate(moneyInput));
    }

}
