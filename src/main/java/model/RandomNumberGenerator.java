package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {
    public List<Integer> createNewRandomNumber() {
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        bubbleSort(randomNumber);
        return randomNumber;
    }

    private void bubbleSort(List<Integer> list) {
        int randomNumberSize = list.size();
        for (int i = 0; i < randomNumberSize - 1; i++) {
            for (int j = 0; j < randomNumberSize - i - 1; j++) {
                swapTempAndList(list, j);
            }
        }
    }

    private void swapTempAndList(List<Integer> list, int j) {
        if (list.get(j) > list.get(j + 1)) {
            int temp = list.get(j);
            list.set(j, list.get(j + 1));
            list.set(j + 1, temp);
        }
    }
}
