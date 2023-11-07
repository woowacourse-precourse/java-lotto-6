package utility;

import static constants.ConstantNumbersManager.LOTTO_NUMBER_SIZE;
import static constants.ConstantNumbersManager.MAXIMUM_LOTTO_NUMBER;
import static constants.ConstantNumbersManager.MINIMUM_LOTTO_NUMBER;
import static constants.ConstantNumbersManager.NOTHING;
import static constants.ConstantNumbersManager.ONE_LOTTO_PRICE;

import java.util.HashSet;
import java.util.List;
import model.Transform;

public class UserInputException {

    public void lottoPriceValidate(int lottoPrice) {
        if (lottoPrice % ONE_LOTTO_PRICE != NOTHING) {
            throw new IllegalArgumentException();
        }
    }

    public void winningNumberValidate(String winningNumber) {
        Transform transform = new Transform();
        List<Integer> winningNumberList = transform.winningNumberToList(winningNumber);
        if (winningNumberList.size() != LOTTO_NUMBER_SIZE || hasDuplicates(winningNumberList)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        return set.size() < numbers.size();
    }

    public void bonusNumberValidate(int bonusNumber) {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}