package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.*;

public class LottoUtils {

    private static final int INPUT_SIZE = 6;
    private static final int MIN_AMOUNT = 1;
    private static final int MAX_AMOUNT = 45;

    public static Lotto[] createLottos(int numberOfLottos){
        Lotto[] lottos = new Lotto[numberOfLottos];
        for(int i = 0; i < numberOfLottos; i++){
            lottos[i] = createLotto();
        }

        return lottos;
    }

    public static boolean invalidLottoInput(List<Integer> numbers) {
        Set<Integer> usedNumbers = new HashSet<>();
        for(int num : numbers){
            usedNumbers.add(num);
        }

        return usedNumbers.size() != numbers.size();
    }

    private static Lotto createLotto() {
        List<Integer> lottoNumbers = createLottoNumbers();
        Lotto lotto = new Lotto(sortLotto(lottoNumbers));

        return lotto;
    }

    private static List<Integer> sortLotto(List<Integer> input) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : input){
            queue.offer(num);
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }

    private static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_AMOUNT, MAX_AMOUNT, INPUT_SIZE);
    }
}
