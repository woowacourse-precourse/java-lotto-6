package lotto;

import camp.nextstep.edu.missionutils.Console;
import domain.GenerateLotto;
import domain.PrizeEnum;
import domain.UserInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Application {
    static HashMap<String, Integer> countWin = new HashMap<>();

    public static void main(String[] args) {
        //금액입력받기
        UserInput userInput = new UserInput();
        int count = userInput.ableBuy();
        System.out.println("\n" + count + "개를 구매했습니다.");

        //랜덤번호 생성
        GenerateLotto[] lottos = new GenerateLotto[count];
        for (int i = 0; i < lottos.length; i++) {
            lottos[i] = new GenerateLotto();
            System.out.println(lottos[i].generatedNumbers);
        }

        //당첨번호 입력
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> numbers;
        while (true) {
            try {
                numbers = inputNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw new IllegalArgumentException();
            }

        }
        //보너스 번호 입력
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNum = bonusNumber();

        //해쉬맵 초기화
        for (int i = 0; i < 5; i++) {
            countWin.put(String.valueOf(i + 3), 0);
        }

        System.out.println("\n당첨 통계\n---");
        //당첨유무 계산
        calculate(lottos, numbers, bonusNum);
        PrizeEnum[] prizeEnums = PrizeEnum.values();
        int benefit = 0;
        //Enum에 있는 상수값 따라 당첨개수 계산
        for (PrizeEnum prize : prizeEnums) {
            switch (prize) {

                case FIFTH:
                    System.out.println(prize.getMatch() + "개 일치 " + prize.getPrize() + " - " + countWin.get(prize.getMatch()) + "개");
                    benefit = benefit + (5000 * countWin.get(prize.getMatch()));
                    break;
                case FOURTH:
                    System.out.println(prize.getMatch() + "개 일치 " + prize.getPrize() + " - " + countWin.get(prize.getMatch()) + "개");
                    benefit = benefit + (50000 * countWin.get(prize.getMatch()));
                    break;
                case THIRD:
                    System.out.println(prize.getMatch() + "개 일치 " + prize.getPrize() + " - " + countWin.get(prize.getMatch()) + "개");
                    benefit = benefit + (1500000 * countWin.get(prize.getMatch()));
                    break;
                case SECOND:
                    System.out.println((Integer.parseInt(prize.getMatch()) - 1) + "개 일치, 보너스 볼 일치 " + prize.getPrize() + " - " + countWin.get(prize.getMatch()) + "개");
                    benefit = benefit + (30000000 * countWin.get(prize.getMatch()));
                    break;
                case FIRST:
                    System.out.println((Integer.parseInt(prize.getMatch()) - 1) + "개 일치 " + prize.getPrize() + " - " + countWin.get(prize.getMatch()) + "개");
                    benefit = benefit + (2000000000 * countWin.get(prize.getMatch()));
            }

        }

        double percent = (double) ((double) benefit * 100 / (double) UserInput.money);

        System.out.println("총 수익률은 " + String.format("%.1f", percent) + "%입니다.");
    }

    public static List<Integer> inputNumber() {
        String[] inputWinNumber = Console.readLine().trim().split(",");
        List<Integer> winNumbers = new ArrayList<>();
        try {
            for (int i = 0; i < inputWinNumber.length; i++) {
                winNumbers.add(Integer.parseInt(inputWinNumber[i]));
            }
            Lotto winLotto = new Lotto(winNumbers);
            return winLotto.getNumbers();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static int bonusNumber() {
        while (true) {
            try {
                int bonusNum = Integer.parseInt(Console.readLine().trim());
                if (bonusNum < 1 | bonusNum > 45) {
                    throw new IllegalArgumentException();
                }
                return bonusNum;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요");
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void calculate(GenerateLotto[] generateLottos, List<Integer> numbers, int bonusNum) {
        for (int i = 0; i < generateLottos.length; i++) {
            int cnt = 0;
            for (int j = 0; j < generateLottos[i].generatedNumbers.size(); j++) {
                if (generateLottos[i].generatedNumbers.contains(numbers.get(j))) {
                    cnt++;
                }
            }
            if (cnt > 2 & cnt < 6) {
                countWin.put(String.valueOf(cnt), countWin.get(String.valueOf(cnt)) + 1);
            } else if (cnt == 6) {
                countWin.put(String.valueOf(7), countWin.get("7") + 1);
            }
            if (generateLottos[i].generatedNumbers.contains(bonusNum) & cnt == 5) {
                countWin.put(String.valueOf(6), countWin.get("6") + 1);
            }
        }
    }
}
