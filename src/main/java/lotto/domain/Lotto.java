package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Lotto {

    //    private final List<Integer> numbers; // 여기에 로또 번호 6개 넣어주기
    //    private final int bonusNumber;
    private static final String getPriceMsg = "구입금액을 입력해 주세요.";
    private static final String getWinningNumbersMsg = "당첨 번호를 입력해 주세요.";
    private static final String getBonusNumberMsg = "구입금액을 입력해 주세요.";


//    public Lotto(List<Integer> numbers, int bonusNumber) {
//        this.bonusNumber = bonusNumber;
//
//        validate(numbers);
//        this.numbers = numbers;
//    }

//
//    public Lotto(int number) {
//        if (number >= 1 && number <= 45) {
//            this.bonusNumber = number;
//        }
//    }
//
//    public Lotto(int price) {
//        if (number >= 1 && number <= 45) {
//            this.price = price;
//        }
//    }


    private int getPrice() {
        int price;
        while (true) {
            System.out.println(getPriceMsg);
            String input = readLine();
            try {
                price = checkPrice(input);
                break;
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] " + e.getMessage());
            }
        }
        return price;
    }

    private int checkPrice(String input) {
        try {
            int price = Integer.parseInt(input);
            if (price < 1000 || price % 1000 != 0) {
                throw new IllegalArgumentException("구입 금액이 유효하지 않습니다.");
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력이 숫자가 아닙니다.");
        }
    }

    private List<List<Integer>> generateLottoNumbers() {
        int count = getPrice()/1000;
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        System.out.println();
        System.out.println(count + "개를 구매했습니다.");

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottoNumbers.add(numbers);
            System.out.println(numbers);
        }
        return lottoNumbers;
    }


//
//    private void getWinningNumbers() {
//        System.out.println(getWinningNumbersMsg);
//        String numbers = readLine();
//
//        List<Integer> winningNumbers = new ArrayList<>();
//        for (String number : numbers.split(",")) {
//            winningNumbers.add(Integer.parseInt(number));
//        }
//
//        return new Game(userInput);
//    }
//
//    private int getBonusNumber(){
//        System.out.println(getBonusNumberMsg);
//        String input = readLine();
//        return Integer.parseInt(input);
//    }
//
//
//    private void validate(List<Integer> numbers) {
//
//        while (true) {
//            try {
//                System.out.print("정수를 입력하세요: ");
//                String input = scanner.nextLine();
//                number = Integer.parseInt(input);
//                break; // 올바른 입력이면 루프 종료
//            } catch (NumberFormatException e) {
//                System.err.println("[ERROR] 올바른 숫자를 입력하세요.");
//            }
//            List<Integer> winningNumbers = new ArrayList<>();
//            for (String number : numbers.split(",")) {
//                winningNumbers.add(Integer.parseInt(number));
//            }
//
//            List<Integer> distinctNumbers = numbers.stream().distinct().toList();
//
//            if (distinctNumbers.size() != 6) {
//                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 없이 6개를 입력하셔야 합니다.");
//            }
//        }

    // TODO: 추가 기능 구현
//    }
}