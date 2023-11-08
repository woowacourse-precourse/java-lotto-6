package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Input {
    public static int inputPrice(int lottoPrice) {
        int purchase = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                purchase = Integer.parseInt(Console.readLine());
                if (purchase % 1000 != 0) {
                    throw new IllegalArgumentException("구입 금액은 " + lottoPrice + "으로 나누어 떨어져야 합니다.");
                }

                validInput = true;
            } catch (NumberFormatException e) {
                new IllegalArgumentExceptionHandler("구입 금액은 정수만 가능합니다.");
            } catch (IllegalArgumentException e) {
                new IllegalArgumentExceptionHandler(e.getMessage());
            }
        }

        return purchase;
    }

    public static List<Integer> inputLotteryNums() {
        List<Integer> lotteryList = new ArrayList<>();
        boolean validInput = false;

        while (!validInput) {
            try {
                String lotteryInput = Console.readLine();
                if (lotteryInput.contains(" ")) {
                    lotteryInput = lotteryInput.replaceAll(" ", "");
                }
                List<String> lotteryString = List.of(lotteryInput.split(","));
                lotteryString = lotteryString.stream().distinct().collect(Collectors.toList());

                lotteryList.clear();
                for (String number : lotteryString) {
                    lotteryList.add(Integer.parseInt(number));
                }

//                if (lotteryList.size() != 6) {
//                    throw new IllegalArgumentException("로또 번호는 중복되지 않는 6자리여야 합니다.");
//                }

                for (int number : lotteryList) {
                    if (number > 45 || number < 1) {
                        throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이여야 합니다.");
                    }
                }

                validInput = true;
            } catch (NumberFormatException e) {
                new IllegalArgumentExceptionHandler("로또 번호는 정수여야 합니다.");
            } catch (IllegalArgumentException e) {
                new IllegalArgumentExceptionHandler(e.getMessage());
            }
        }
        return lotteryList;
    }

    public static int inputBonusNum(Lotto lotteryNums) {
        int bonusInt = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                bonusInt = Integer.parseInt(Console.readLine());

                if (lotteryNums.getNumbers().contains(bonusInt)) {
                    throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복되지 않아야 합니다.");
                }

                if (bonusInt > 45 || bonusInt < 1) {
                    throw new IllegalArgumentException("보너스 번호는 1 ~ 45 사이여야 합니다.");
                }
                validInput = true;
            } catch (NumberFormatException e) {
                new IllegalArgumentExceptionHandler("보너스 번호는 정수여야 합니다.");
            } catch (IllegalArgumentException e) {
                new IllegalArgumentExceptionHandler(e.getMessage());
            }
        }
        return bonusInt;
    }
}
