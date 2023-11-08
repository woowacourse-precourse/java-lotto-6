package input;

import static constant.ErrorMessage.buildErrorMessage;

import constant.ServiceMessage;
import java.util.List;
import java.util.Scanner;

public class BonusNumber {
    private String input;
    private boolean isValidInput = false;

    public BonusNumber(List<Integer> winningNumbers) {
        while(!isValidInput) {
            setBonnusNumber(winningNumbers);
        }
    }

    private void setBonnusNumber(List<Integer> winningNumbers){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(ServiceMessage.getMessageByCode(104));
            this.input = scanner.nextLine();
            isValidInput = isValidate(input, winningNumbers);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private boolean isValidate(final String input, List<Integer> winningNumbers) {
        isValidCharacters(input);
        isDuplicated(winningNumbers, input);
        isValidBounds(input);
        return true;
    }

    private void isValidBounds(final String input) {
        int number = Integer.parseInt(input);
        if(number < 1 || 45 < number) {
            throw new IllegalArgumentException(buildErrorMessage(904));
        }
    }

    private void isValidCharacters(final String input) {
        if(!input.matches("[1-9]+")) {
            throw new IllegalArgumentException(buildErrorMessage(901));
        }
    }

    private void isDuplicated(List<Integer> winningNumbers, final String input) {
         if(winningNumbers.contains(Integer.parseInt(input))) {
             throw new IllegalArgumentException(buildErrorMessage(908));
         }
    }

    public int getBonnusNumber() {
        return Integer.parseInt(input);
    }
}

