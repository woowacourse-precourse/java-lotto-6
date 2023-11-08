package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
            validate(numbers);
            this.numbers = numbers;
        }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이어야 합니다.");
            }
            for (int j = i + 1; j < numbers.size(); j++) {
                if (number.equals(numbers.get(j))) {
                    throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
                }
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public static int inputCoin() {
        System.out.println("구입금액을 입력해 주세요.");   //구입 금액 입력
        int coin = 0;
        while (true) {
            String coinInput = Console.readLine();
            if (validCoinInput(coinInput)) {
                coin = Integer.parseInt(coinInput) / 1000;
                return coin;
            }
            System.out.println("[ERROR] 1000원 단위로 다시 입력해 주세요.");
        }
    }


    public static boolean validCoinInput(String coinInput) {
        int coin;
        try {
            coin = Integer.parseInt(coinInput);
            if (coin % 1000 != 0 || coin < 0) {
                return false;
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static List<Lotto> toChangeLotto(int coin) {    //리턴될 로또목록
        List<Lotto> lottoList = new ArrayList<>();
        System.out.println("\n"+coin + "개를 구매했습니다.");
        for (int i = 0; i < coin; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
            System.out.println(numbers); // 각 로또 번호 출력
        }
        return lottoList;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");  //TODO 추후 당첨번호 입력 메소드 분리
        String lottoInput = Console.readLine();
        List<Integer> winnerNumber = new ArrayList<>();
        String[] inputArray = lottoInput.split(",");
        if (inputArray.length != 6) {
            System.out.println("[ERROR] 6자리 당첨번호를 다시 입력하세요.");
            return inputWinningNumbers(); // 입력호출
        }
        List<Integer> winningNumbers = new ArrayList<>();
        for (String token : inputArray) {
            try {
                int number = Integer.parseInt(token);
                if (number < 1 || number > 45 || winningNumbers.contains(number)) {
                    System.out.println("[ERROR] 1부터 45 사이의 중복되지 않는 숫자를 입력하세요.");
                    return inputWinningNumbers(); // 입력호출
                }
                winningNumbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 입력입니다. 다시 입력하세요.");
                return inputWinningNumbers(); // 입력호출
            }
        }
        for (String numStr : inputArray) {
            winnerNumber.add(Integer.parseInt(numStr.trim()));
        }
        return winningNumbers;
    }
    public static int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber;
        while (true) {
            String bonusInput = Console.readLine();
            try {
                bonusNumber = Integer.parseInt(bonusInput);
                if (bonusNumber >= 1 && bonusNumber <= 45) {
                    return bonusNumber;
                }
                System.out.println("[ERROR] 1부터 45 사이의 숫자를 입력하세요.");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 입력입니다. 숫자를 입력하세요.");
            }
        }
    }
}
