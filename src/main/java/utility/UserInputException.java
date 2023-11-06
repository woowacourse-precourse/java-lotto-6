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
        List<Integer> winningNumberList;
        winningNumberList = transform.winningNumberToList(winningNumber);
        duplicate(winningNumberList);
        if(winningNumberList.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void bonusNumberValidate(int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }


}
