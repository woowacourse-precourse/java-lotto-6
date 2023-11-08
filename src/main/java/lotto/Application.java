package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static int lottoMoney = 0;
    static List<Integer> winningLottoNumber;
    static int bonusNumber = 0;
    static Map<String, Integer> winningCount = new HashMap<>() {{
        put("6개 일치 (2,000,000,000원)", 0);
        put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        put("5개 일치 (1,500,000원)", 0);
        put("4개 일치 (50,000원)", 0);
        put("3개 일치 (5,000원)", 0);
    }};

    public static boolean lottoMoneyInput() {
        try {
            String userInput = Console.readLine();
            lottoMoney = Integer.parseInt(userInput);
            if (lottoMoney % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public static boolean bonusNumberInput() {
        try {
            String userInput = Console.readLine();
            bonusNumber = Integer.parseInt(userInput);
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해 주세요.");
            }
            if (winningLottoNumber.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않은 숫자를 입력해 주세요.");
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public static int lottoNumberCheck(List<Integer> userLottoNumber) {
        int winningNumberCount = 0;
        for (int number : winningLottoNumber) {
            if (userLottoNumber.contains(number)) {
                winningNumberCount += 1;
            }
        }
        return winningNumberCount;
    }

    public static void lottoWinningCheck(int winningNumberCount, boolean bonusContain) {
        //enum 이용해서 당첨 내역 출력
        Ranking[] ranks = Ranking.values();
        for (Ranking rank : ranks) {
            if (winningNumberCount == rank.winningNumberCount && bonusContain == rank.bounsContain) {
                winningCount.put(rank.winningText, winningCount.get(rank.winningText)+1);
            }
        }
    }

    public static void main(String[] args) {
        // 로또 구입 금액 입력받고 예외처리
        boolean flag = true;
        while(flag) {
            System.out.println("구입금액을 입력해 주세요.");
            flag = lottoMoneyInput();
        }
        System.out.println();

        // 발행한 로또 수량 출력
        int lottoAmount = lottoMoney / 1000;
        System.out.println(lottoAmount + "개를 구매했습니다.");

        // 발행한 로또 번호 오름차순으로 출력하기
        List<List<Integer>> userLottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> userLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(userLottoNumber);
            userLottoNumbers.add(userLottoNumber);
            System.out.println(userLottoNumber);
        }
        System.out.println();

        // 당첨 번호 6개 쉼표로 구분하여 입력받기
        while (true) {
            List<Integer> numbers = new ArrayList<>();
            System.out.println("당첨 번호를 입력해 주세요.");
            String userInput = Console.readLine();
            String[] splitNumber = userInput.split(",");
            for (int i = 0; i < splitNumber.length; i++) {
                numbers.add(Integer.parseInt(splitNumber[i]));
            }
            try {
                Lotto lotto = new Lotto(numbers);
                winningLottoNumber = lotto.getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        System.out.println();

        // 보너스 번호 1개 입력 받기
        flag = true;
        while (flag) {
            System.out.println("보너스 번호를 입력해 주세요.");
            flag = bonusNumberInput();
        }
        System.out.println();

        // 당첨 내역 출력하기
        System.out.println("당첨 통계");
        System.out.println("---");
        boolean bonusContain = false;
        for (List<Integer> userLottoNumber : userLottoNumbers) {
            int winningNumberCount = lottoNumberCheck(userLottoNumber);
            if (winningNumberCount == 5 && userLottoNumber.contains(bonusNumber)) {
                bonusContain = true;
            }
            lottoWinningCheck(winningNumberCount, bonusContain);
        }
        for (Map.Entry<String, Integer> entrySet : winningCount.entrySet()) {
            System.out.println(entrySet.getKey() + " - " + entrySet.getValue() + "개");
        }

    }
}
