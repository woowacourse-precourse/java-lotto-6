package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private List<List<Integer>> randomNumbers;

    public void generateRandomNumbers(int quantity) {
        randomNumbers = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            List<Integer> singleLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            randomNumbers.add(singleLotto);
        }
    }

    public List<List<Integer>> getRandomNumbers() {
        return randomNumbers;
    }

    public void printMyLottoNumber(){
        for(int i=0;i<randomNumbers.size();i++){
            System.out.println(randomNumbers.get(i));
        }
        System.out.println();
    }
}
