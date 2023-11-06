package lotto;

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
    }

    public void printLottoNumber() {
        StringBuilder lottoNumbers = new StringBuilder();
        lottoNumbers.append("[");
        for(int lottoNumber : numbers) {
            lottoNumbers.append(lottoNumber + ", ");
        }
        lottoNumbers.delete(lottoNumbers.length() - 2, lottoNumbers.length());
        lottoNumbers.append("]");

        System.out.println(lottoNumbers);
    }
    public int checkWinning(int[] winningNumbers, int bonusNumber) {
        int winningCount = 0;
        for (int i = 0; i < winningNumbers.length; i++) {
            if(numbers.contains(winningNumbers[i])) {
                winningCount++;
            }
        }

        if(winningCount == 5 && numbers.contains(bonusNumber)) {
            return 9;
        }
        return winningCount;
    }

}
