package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoService {
    public List<Integer> makeRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
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
}
