package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Play {

    List<Lotto> lottos;
    private final int lottoCnt;   // 구입한 로또 개수
    private final int lottoNumber = 6;  // 로또는 숫자 6개를 가진다
    private final int maxLottoNum = 45; // 로또 가장 큰 숫자

    public Play(int cost) {
        // 구매 금액이 1000원으로 나누어 떨어지지 않는 경우 예외 발생
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        // 구입한 로또 개수
        this.lottoCnt = cost / 1000;
    }

    // 각 로또의 6자리 숫자 랜덤 생성
    List<Integer> getLottoNums() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);  // 오름차순으로 정렬
        return numbers;
    }

    // 당첨 번호 입력받기
    List<Integer> getAnswerNums() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            List<String> nums = Arrays.asList(Console.readLine().split(","));
            if (!checkIs6Num(nums))    // 6개의 숫자가 입력되었는지 확인
                continue;
            List<Integer> answerNums = checkEachNumRange(nums); // 각 숫자가 1~45 사이인지 확인
            if (answerNums != null)
                return answerNums;
        }
    }

    // 6개의 숫자가 입력되었는지 확인
    boolean checkIs6Num(List<String> nums) {
        try {
            if (nums.size() != lottoNumber) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호를 6개 입력해주세요.");
        }
        return false;
    }

    void checkNumRange(int num) {
        if (num <= 0 || num > 45) {
            throw new IllegalArgumentException();
        }
    }

    // 숫자가 1~45범위인지 확인
    List<Integer> checkEachNumRange(List<String> nums) {
        try {
            List<Integer> result = new ArrayList<>();
            for (String n : nums) {
                int eachNum = Integer.parseInt(n);
                checkNumRange(eachNum);
                result.add(Integer.parseInt(n));
            }
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return null;
    }

    int getBonusNum() {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                int bonus = Integer.parseInt(Console.readLine());
                checkEachNumRange(new ArrayList<>(bonus));
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public Integer[] makeListToArray(List<Integer> list) {
        Integer[] result = new Integer[maxLottoNum + 1];
        for (int i = 0; i < maxLottoNum + 1; i++) {
            result[i] = 0;
        }
        for (Integer e : list) {
            result[e] = 1;
        }
        return result;
    }

    public void printSuccess(int n, String price, int cnt) {
        int tmpN = n;
        if (n == 6 || n == 7) {
            tmpN--;
        }
        System.out.print(tmpN + "개 일치");
        if (n == 6) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.println(" (" + price + "원) - " + cnt + "개");
    }

    public int[] swapArr(int[] result, int a, int b) {
        int tmp = result[a];
        result[a] = result[b];
        result[b] = tmp;
        return result;
    }

    public Map<Integer, String> makePrizeMap() {
        Map<Integer, String> winPrize = new HashMap<>();
        winPrize.put(3, "5,000");
        winPrize.put(4, "50,000");
        winPrize.put(5, "1,500,000");
        winPrize.put(6, "30,000,000");
        winPrize.put(7, "2,000,000,000");
        return winPrize;
    }

    public int getAllSuccess(int[] result) {
        int total = 0;
        result = swapArr(result, result[lottoNumber], result[lottoNumber + 2 - 1]);
        Map<Integer, String> winPrize = makePrizeMap();
        for (int i = 3; i < result.length; i++) {
            printSuccess(i, winPrize.get(i), result[i]);
            for (int j = 0; j < result[i]; j++) {
                total += Integer.parseInt(winPrize.get(i).replaceAll("[^0-9]", ""));
            }
        }
        return total;
    }

    public void getResult(int[] result) {
        System.out.println("\n당첨 통계\n---");
        int total = getAllSuccess(result);
        double earningRate = ((double) total / (lottoCnt * 1000)) * 100;
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }

    public int[] getSuccess(int[] result, int answerCnt, boolean bonus) {
        result[answerCnt]++;
        if (answerCnt == 5 && bonus) {
            result[answerCnt]--;
            result[lottoNumber + 2 - 1]++;
        }
        return result;
    }

    public void checkSuccess(List<Integer> answerNums, int bonusNum) {
        Integer[] answers = makeListToArray(answerNums);
        int[] result = new int[lottoNumber + 2];  // n개 일치하는 로또 개수 저장할 배열. 마지막 자리는 5개일치+보너스
        for (Lotto lotto : lottos) {
            int cnt = 0;
            boolean bonus = false;
            for (Integer number : lotto.getNumbers()) {
                if (answers[number] == 1) {
                    cnt++;
                }
            }
            if (answers[bonusNum] == 1) {
                bonus = true;
            }
            result = getSuccess(result, cnt, bonus);
        }
        getResult(result);
    }

    public void startGame() {
        System.out.println("\n" + lottoCnt + "개를 구매했습니다.");
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> numbers = getLottoNums();
            System.out.println(numbers);
            lottos.add(new Lotto(numbers));
        }
        List<Integer> answerNums = getAnswerNums();
        int bonusNum = getBonusNum();
        checkSuccess(answerNums, bonusNum);
    }
}
