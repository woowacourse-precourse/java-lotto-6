package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Validator.LottoValidator;

public class Game {

    private Lotto문 winningLotto;

    public void askWinningNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (true) {
            System.out.println("당첨 번호를 입력해주세요");
            String input = Console.readLine();

            try {
                validate(input);
                String[] inputs = input.split(",");

                for (String number :
                        inputs) {
                    numbers.add(Integer.parseInt(number));
                }
                this.setWinningLotto(numbers);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setWinningLotto(List<Integer> numbers) {
        this.winningLotto = new Lotto(numbers);
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    private void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 다시 입력해주세요.");
        }
    }
}
