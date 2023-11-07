package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int num = 0;

        try {
            num = Integer.parseInt(Console.readLine());
            if(num % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 구입금액은 1000의 배수여야 합니다.");
        }

        System.out.println();

        int bought = num / 1000;
        System.out.println(bought + "개를 구매했습니다.");

        Lotto[] lottoNum = new Lotto[bought];
        for(int i = 0; i < bought; i++) {
            lottoNum[i] = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNum[i].getNumbers());
        }

        for(Lotto l : lottoNum) {
            System.out.println(l.getNumbers().toString());
        }

        List<Integer> userNum = new ArrayList<>();
        while(true) {
            System.out.println("당첨 번호를 입력해 주세요.");

            try {
                String[] str = Console.readLine().split(",");
                if (str.length != 6) {
                    throw new IllegalArgumentException("당첨 번호는 6개를 입력해야 합니다.");
                }

                for (String s : str) {
                    int n = Integer.parseInt(s);
                    if (n < 1 || n > 45) {
                        throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    userNum.add(n);
                }

                Set<Integer> userSet = new HashSet<>(userNum);
                if (userNum.size() != userSet.size()) {
                    throw new IllegalArgumentException("당첨 번호는 서로 중복되지 않아야 합니다.");
                }

                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        System.out.println();
        while(true) {
            System.out.println("보너스 번호를 입력해 주세요.");

            try {
                int n = Integer.parseInt(Console.readLine());
                if(n < 1 || n > 45) {
                    throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }

                userNum.add(n);
                Set<Integer> userSet = new HashSet<>(userNum);
                if (userNum.size() != userSet.size()) {
                    userNum.remove(userNum.size() - 1);
                    throw new IllegalArgumentException("당첨 번호와 보너스 번호는 서로 중복되지 않아야 합니다.");
                }

                break;
            }
            catch(IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
