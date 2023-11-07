package utility;

import java.util.HashSet;
import java.util.List;
import model.Transform;

public class UserInputException {

    public void lottoPriceValidate(int lottoPrice) {
        if (lottoPrice % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void winningNumberValidate(String winningNumber) {
        Transform transform = new Transform();
        List<Integer> winningNumberList = transform.winningNumberToList(winningNumber);
        if (winningNumberList.size() != 6 || hasDuplicates(winningNumberList)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        return set.size() < numbers.size();
    }

    public void bonusNumberValidate(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }
}