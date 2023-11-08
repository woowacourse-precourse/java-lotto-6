package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static constants.LottoConstant.*;

public class LottoService {
    private final static int MIN_LOTTO=1;
    private final static int MAX_LOTTO=45;
    private final static int LOTTO_LENGTH=6;
    public List<Integer> makeRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO, MAX_LOTTO, LOTTO_LENGTH);
        return numbers;
    }

    public Lotto[] makeLottoList(int how) {
        Lotto[] lottos = new Lotto[how];
        for (int i = 0; i < how; i++) {
            lottos[i] = new Lotto(makeRandomNumber());
        }
        return lottos;
    }

    public int compare(Lotto answer, Lotto consumer) {
        List<Integer> answerNumbers = answer.getNumbers();
        List<Integer> consumerNumbers = consumer.getNumbers();
        int correct = 0;
        for (int i = 0; i < consumerNumbers.size(); i++) {
            if (answerNumbers.contains(consumerNumbers.get(i))) {
                correct++;
            }
        }
        return correct;
    }

    public boolean compareBonusNumber(Lotto answer, int bonusNumber) {
        return answer.getNumbers().contains(bonusNumber);
    }

    public int[] compareAllLotto(Lotto[] lottos, Lotto answer, int bonusNum) {
        int[] result = new int[LOTTO_LENGTH-1];
        for (int i = 0; i < lottos.length; i++) {
            int correct = compare(answer, lottos[i]);
            boolean bonus = compareBonusNumber(lottos[i], bonusNum);
            increaseResult(result, correct, bonus);
        }
        return result;
    }

    private void increaseResult(int[] result, int correct, boolean bonus) {
        if (correct == CORRECT_THREE.getResult()) result[FIFTH_PLACE.getResult()]++;
        if (correct == CORRECT_FOUR.getResult()) result[FOURTH_PLACE.getResult()]++;
        if (correct == CORRECT_FIVE.getResult() && !bonus) result[THIRD_PLACE.getResult()]++;
        if (correct == CORRECT_FIVE.getResult() && bonus) result[SECOND_PLACE.getResult()]++;
        if (correct == CORRECT_SIX.getResult()) result[FIRST_PLACE.getResult()]++;
    }
}
