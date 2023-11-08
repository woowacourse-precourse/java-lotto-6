package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;

public class Game {
    static final int ZERO_ASCII = 48;
    static final int NINE_ACSII = 57;

    List<Integer> answerNumber = new ArrayList<>();
    int bonusNumber;
    private List<Lotto> lottoList = new ArrayList<>();

    public Game() {
    }

    public static void Run() {
        Game lotto = new Game();
        //로또 금액 입력 받기
        int cost = lotto.getMoney();
        //금액 만큼 로또 발행하기
        lotto.makeLotto(cost / 1000);
        //당첨 번호, 보너스 번호 입력 받기
        lotto.getAnswerNumber();
        lotto.getBonusNumber();
        //당첨 결과 출력하기
        int[] result = lotto.checkResult();
        int revenue = lotto.printResult(result);
        //총 수익률 출력하기
        lotto.printRevenue(revenue, cost);
    }

    private int getMoney() {
        //돈 입력 받고 예외처리하기
        int check = 0;
        int money = 0;
        System.out.println("구입금액을 입력해 주세요.");
        while (check == 0) {
            try {
                String input = Console.readLine();
                System.out.println();
                money = validateNumber(input);
                check = 1;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 최소 천 원 단위로 입력해 주세요");
            }
        }
        return money;
    }

    public int validateNumber(String input) {
        for (char num : input.toCharArray()) {
            if (num < ZERO_ASCII || num > NINE_ACSII) {
                throw new IllegalArgumentException();
            }
        }

        int money = Integer.parseInt(input);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        return money;
    }

    private void makeLotto(int count) {
        //개수만큼 로또 발행하고 로또리스트에 넣기
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            this.lottoList.add(new Lotto(pickNumbers()));
        }
        System.out.println();
    }

    private List<Integer> pickNumbers() {
        //로또 발행을 위해 랜덤번호 뽑아서 리스트 리턴하기
        List<Integer> temp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> number = new ArrayList<>(temp);
        Collections.sort(number);
        System.out.printf("[");
        for (int i = 0; i < number.size() - 1; i++) {
            System.out.printf(number.get(i) + ", ");
        }
        System.out.println(number.get(number.size() - 1) + "]");
        return number;
    }

    private void getAnswerNumber() {
        //당첨번호, 보너스번호 받기
        int check = 0;
        System.out.println("당첨 번호를 입력해 주세요.");
        while (check == 0) {
            try {
                String input = Console.readLine();
                System.out.println();
                validateAnswerNumber(input);
                check = 1;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void getBonusNumber() {
        int check = 0;
        System.out.println("보너스 번호를 입력해 주세요.");
        while (check == 0) {
            try {
                String input = Console.readLine();
                System.out.println();
                checkIsNumber(input);
                checkInRange(input);
                this.bonusNumber = Integer.parseInt(input);
                check = 1;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public void validateAnswerNumber(String input) {
        String[] numbers = input.split(",");
        //입력받은 숫자가 6개인지 확인
        if (numbers.length != 6) {
            throw new IllegalArgumentException();
        }
        Set<String> temp = new HashSet<>(Arrays.asList(numbers));
        //중복된 숫자가 없는지 확인
        if (temp.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (String number : numbers) {
            //숫자인지 확인
            checkIsNumber(number);
            //1 ~ 45 사이의 숫자인지 확인
            checkInRange(number);
        }
        for (String number : numbers) {
            this.answerNumber.add(Integer.parseInt(number));
        }
    }

    private void checkIsNumber(String number) {
        for (char c : number.toCharArray()) {
            if (c < ZERO_ASCII || c > NINE_ACSII) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkInRange(String number) {
        int num = Integer.parseInt(number);
        if (num < 0 || num > 45) {
            throw new IllegalArgumentException();
        }
    }

    private int[] checkResult() {
        int[] priceCnt = {0, 0, 0, 0, 0};
        //당첨 결과 출력하기
        for (Lotto L : this.lottoList) {
            List<Integer> result = L.checkPrize(this.answerNumber, this.bonusNumber);
            if (result.get(0) == 6) {
                priceCnt[4]++;
            } else if (result.get(0) == 5 && result.get(1) == 1) {
                priceCnt[3]++;
            } else if (result.get(0) == 5) {
                priceCnt[2]++;
            } else if (result.get(0) == 4) {
                priceCnt[1]++;
            } else if (result.get(0) == 3) {
                priceCnt[0]++;
            }
        }
        return priceCnt;
    }

    private int printResult(int[] result) {
        int revenue = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result[0] + "개");
        revenue += 5000 * result[0];
        System.out.println("4개 일치 (50,000원) - " + result[1] + "개");
        revenue += 50000 * result[1];
        System.out.println("5개 일치 (1,500,000원) - " + result[2] + "개");
        revenue += 1500000 * result[2];
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[3] + "개");
        revenue += 30000000 * result[3];
        System.out.println("6개 일치 (2,000,000,000원) - " + result[4] + "개");
        revenue += 2000000000 * result[4];
        return revenue;
    }

    private void printRevenue(int revenue, int cost) {
        //총 수익률 출력하기
        double rate = ((double) revenue / (double) cost) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }
}
