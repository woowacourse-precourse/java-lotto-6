package input;

import static constant.ErrorMessage.buildErrorMessage;

import constant.ServiceMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WinningNumber {
    private String input;
    private final List<Integer> winningNumbers = new ArrayList<>();
    private boolean isValidInput = false;

    public WinningNumber() {
        while(!isValidInput) {
            setWinningNumbers();
        }
    }

    private void setWinningNumbers(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(ServiceMessage.getMessageByCode(103));
            this.input = scanner.nextLine();
            isValidInput = isValidate(input);
            winningNumbers.addAll(
                    Arrays.stream(input.split(","))
                            .map(Integer::parseInt)
                            .toList());
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private boolean isValidate(final String input) {
        isValidCharacters(input);
        String[] numbers = input.split(",");
        isValidLength(numbers);
        isDuplicated(numbers);
        isValidBounds(numbers);
        return true;
    }

    private void isValidBounds(final String[] numbers) {
        Arrays.stream(numbers).mapToInt(Integer::parseInt)
                .filter(num -> num < 1 || 45 < num)
                .findAny().ifPresent(num -> {
                    throw new IllegalArgumentException(buildErrorMessage(904));
                });
    }
    private void isValidLength(final String[] numbers) {
        if(numbers.length != 6){
            throw new IllegalArgumentException(buildErrorMessage(905));
        }
    }

    private void isValidCharacters(final String input) {
        if(!input.matches("[0-9,]+")) {
            throw new IllegalArgumentException(buildErrorMessage(906));
        }
    }

    private void isDuplicated(final String[] numbers) {
        if(Arrays.stream(numbers).distinct().count() != numbers.length) {
            throw new IllegalArgumentException(buildErrorMessage(903));
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}

