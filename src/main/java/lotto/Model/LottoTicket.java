package lotto.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private List<Integer> numbers;

    public LottoTicket() {
        this.numbers = generateRandomNumbers();
    }

    public LottoTicket(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> potentialNumbers = generatePotentialNumbers();
        shuffleNumbers(potentialNumbers);
        List<Integer> selectedNumbers = selectNumbers(potentialNumbers);
        return sortNumbers(selectedNumbers);
    }

    private List<Integer> generatePotentialNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i=MINIMUM_LOTTO_NUMBER; i<= MAXIMUM_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private void shuffleNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }

    private List<Integer> selectNumbers(List<Integer> shuffledNumbers) {
        return new ArrayList<>(shuffledNumbers.subList(0, LOTTO_NUMBER_COUNT));
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

}
