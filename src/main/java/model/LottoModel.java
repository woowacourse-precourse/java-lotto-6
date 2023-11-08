package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoModel {
    private List<Integer> numbers;

    public void generateRandomNumbers() {
        numbers = new ArrayList<>();
        Random random = new Random();
        while (numbers.size() < 6) {
            int num = random.nextInt(45) + 1;
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

