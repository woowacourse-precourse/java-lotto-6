package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoService {
    private int lotto1st = 0;
    private int lotto2st = 0;
    private int lotto3st = 0;
    private int lotto4st = 0;
    private int lotto5st = 0;

    private double totalProfit = 0.0;

    public int getLotto1st() {
        return lotto1st;
    }

    public int getLotto2st() {
        return lotto2st;
    }

    public int getLotto3st() {
        return lotto3st;
    }

    public int getLotto4st() {
        return lotto4st;
    }

    public int getLotto5st() {
        return lotto5st;
    }
    public int moneyInput() {
        int moneyInput = 0;
        while (moneyInput == 0) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                moneyInput = Integer.parseInt(Console.readLine());
                moneyInput = validateMoneyInput(moneyInput);
            } catch (NumberFormatException e) {
                moneyInput = 0;
                System.out.println("[ERROR] 구입금액은 숫자로 입력해주세요.");
                e.printStackTrace();
            }
        }
        return moneyInput;
    }

    private int validateMoneyInput(int moneyInput) {
        while (moneyInput % 1000 != 0) {
            System.out.println("[ERROR] 구입금액은 1000원 단위로 입력해주세요.");
            System.out.println("구입금액을 입력해 주세요.");
            moneyInput = Integer.parseInt(Console.readLine());
        }
        return moneyInput;
    }

    public int lottoCount(int moneyInput) {
        int lottoCount = moneyInput / 1000;
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
        return lottoCount;
    }

    public List<Integer> randomNumber() {
        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
        int[] winningNumberInt = {};
        boolean isRunning = true;
        while (isRunning) {
            try {
                String[] winningNumberStr = winNumInput();
                winningNumberInt = Arrays.stream(winningNumberStr).mapToInt(Integer::parseInt).toArray();
                int i = winningNumberInt[5];
                isRunning = false;
            }catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자로 입력해주세요.");
                new IllegalArgumentException().printStackTrace();
            }catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("[ERROR] 6개의 숫자를 입력해주세요.");
                new IllegalArgumentException().printStackTrace();
            }
        }
        return winningNumberInt;
    }

    private String[] winNumInput() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumberStr = Console.readLine().split(",");
        return winningNumberStr;
    }

    public int bonusNumberInput() {
        int bonusNum = 0;

        while (bonusNum == 0) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNum = Integer.parseInt(Console.readLine());
                bonusNum = validateBonusNumberInput(bonusNum);
            } catch (NumberFormatException e) {
                bonusNum = 0;
                System.out.println("[ERROR] 숫자로 입력해주세요.");
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                bonusNum = 0;
                System.out.println("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
                e.printStackTrace();
            }
        }
        return bonusNum;
    }

    private int validateBonusNumberInput(int bonusNum) {
        if (bonusNum > 45 || bonusNum < 1) {
            throw new IllegalArgumentException();
        }
        return bonusNum;
    }

    // 숫자 비교기 제작
    public int compareNumbers(Lotto lotto, int[] winningNumber) {
        int equalsNumber = 0;
        for (int i = 0; i < 6; i++) {
            if (lotto.getNumbers().contains(winningNumber[i])) {
                equalsNumber++;
            }
        }
        return equalsNumber;
    }

    public boolean isBonusNumber(Lotto lotto, int bonusNumber) {
        for (int i = 0; i < 6; i++) {
            if (lotto.getNumbers().contains(bonusNumber)) {
                return true;
            }
        }
        return false;
    }

    public Integer addLottoWinner(int equalsNumber, boolean bonusNumber) {
        if (equalsNumber == 6) return lotto1st++;
        if (equalsNumber == 5 && bonusNumber) return lotto2st++;
        if (equalsNumber == 5) return lotto3st++;
        if (equalsNumber == 4) return lotto4st++;
        if (equalsNumber == 3) return lotto5st++;
        return null;
    }

    public void lottoResult(List<Lotto> lottos, int[] winningNumber, int bonusNumber) {
        for (int i = 0; i < lottos.size(); i++) {
            int equalsNumber = compareNumbers(lottos.get(i), winningNumber);
            boolean b = isBonusNumber(lottos.get(i), bonusNumber);
            addLottoWinner(equalsNumber, b);
        }
    }

    public double profitRate(int moneyInput) {
        totalProfit = (lotto1st*2000000000) + (lotto2st*30000000) + (lotto3st*1500000) + (lotto4st*50000) + (lotto5st*5000);
        return (totalProfit / moneyInput)*100;
    }

    public void lottoResultPrint(int moneyInput) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n",lotto5st);
        System.out.printf("4개 일치 (50,000원) - %d개\n",lotto4st);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n",lotto3st);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",lotto2st);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n",lotto1st);
        System.out.printf("총 수익률은 %.1f%%입니다.",profitRate(moneyInput));
    }

}
