package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoGenerator {
    public static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        List<Integer> candidateNumbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            candidateNumbers.add(i);
        }

        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(candidateNumbers.size());
            int selectedNumber = candidateNumbers.remove(randomIndex);
            lottoNumbers.add(selectedNumber);
        }

        return lottoNumbers;
    }
}
