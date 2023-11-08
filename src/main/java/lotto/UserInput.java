package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class UserInput {

    public int getPurchaseAmount() {
        int purchaseAmount;

        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                purchaseAmount = Integer.parseInt(Console.readLine());

                validatePurchaseAmount(purchaseAmount);

                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        return purchaseAmount;
    }


    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해 주세요.");
        }

    }


    //당첨 번호 입력
    public List<Integer> getWinningNumbers() {
        String winningNumbersInput;
        List<String> splittedWinningNumbersInput;
        List<Integer> winningNumbers = new ArrayList<>();

        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                winningNumbersInput = Console.readLine();

                //Array보다는  Collections 사용! - 1주차 피드백
                //변수 이름에 자료형&자료구조 사용하지 마! - 2주차 피드백
                splittedWinningNumbersInput = splitNumbers(winningNumbersInput);

                validateWinningNumbers(splittedWinningNumbersInput);

                validateDuplicates(splittedWinningNumbersInput);

                saveIntWinningNumbers(splittedWinningNumbersInput, winningNumbers);

                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        return winningNumbers;
    }


    private List<String> splitNumbers(String winningNumbersInput){
        List<String> splittedWinningNumbersInput;

        splittedWinningNumbersInput = Arrays.asList(winningNumbersInput.split(","));

        return splittedWinningNumbersInput;
    }


    private void validateWinningNumbers(List<String> splittedWinningNumbersInput) {
        if (splittedWinningNumbersInput.size() != 6) {
            throw new IllegalArgumentException("당첨 번호 6개를 입력해 주세요");
        }

        for(var number : splittedWinningNumbersInput) {
            int intNumber = Integer.parseInt(number);
            if ( !((intNumber >= 1) && ( intNumber <= 45)) ){
                throw new IllegalArgumentException("1부터 45 사이의 숫자들을 입력해 주세요.");
            }
        }

    }


    private void validateDuplicates(List<String> splittedWinningNumbersInput) {
        Set<String> set = new HashSet<>();

        for (var number : splittedWinningNumbersInput) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("서로 다른 당첨 번호들을 입력해 주세요.");
            }
        }

    }


    private List<Integer> saveIntWinningNumbers(List<String> splittedWinningNumbersInput, List<Integer> winningNumbers){

        for (var number : splittedWinningNumbersInput) {
            Integer.parseInt(number);
            winningNumbers.add(Integer.valueOf(number));
        }

        return winningNumbers;
    }


    public void sortWinningNumbers(List<Integer> winningNumbers) {
        Collections.sort(winningNumbers);
    }








    //보너스 번호 입력
    public int getBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;

        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = Integer.parseInt(Console.readLine());

                validateBonusNumber(bonusNumber);

                checkOverlapWithWinningNumber(winningNumbers, bonusNumber);

                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        return bonusNumber;
    }


    private void validateBonusNumber(int bonusNumber) {

        if (!((bonusNumber >= 1) && (bonusNumber <= 45))) {
            throw new IllegalArgumentException("1부터 45 사이의 숫자를 하나 입력해 주세요.");
        }

        return;
    }


    private void checkOverlapWithWinningNumber(List<Integer> winningNumbers, int bonusNumber) {

        for (var winningNumber : winningNumbers) {
            if (winningNumber == bonusNumber) {
                throw new IllegalArgumentException("당첨 번호와 다른 숫자를 입력해주세요.");
            }
        }

        return;
    }

}
