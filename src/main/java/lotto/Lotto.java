package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 45;
    private static final int BALL_COUNT = 6;
    private final List<List<Integer>> lottos = new ArrayList<>();
    private final List<Integer> numbers;
    private List<Integer> winningNumber;
    private int lottoQuantity, bonusNumber;
    private String winningNumberWithComma;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호 개수는 6개어야 합니다.");
            throw new IllegalArgumentException();
        }

        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
    Input input = new Input();
    private void setLottoQuantity() {
        this.lottoQuantity = input.getTotalPrice() / 1000;
    }

    private void setWinningNumber() {
        this.winningNumberWithComma = input.getWinningNumber();
        String[] winningNumbers = winningNumberWithComma.split(",");
        for(int i=0; i<winningNumbers.length; i++){
            if(winningNumbers[i].length() > 6) {
                throw new IllegalArgumentException("당첨 번호 갯수가 6개를 초과함");
            }
            this.winningNumber.add(Integer.parseInt(winningNumbers[i]));
        }
        validate(winningNumber);
    }

    private void setBonusNumber() {
        this.bonusNumber = input.getBonusNumber();
    }

    private void setLottoQuantity(int totalPrice) {
        this.lottoQuantity = totalPrice/1000;
    }

    private void createLottos(){
        for(int i=0; i<lottoQuantity; i++) {
            this.lottos.add(getRandomNumbers());
        }
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER, BALL_COUNT);
    }

    private

}
