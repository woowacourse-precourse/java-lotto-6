package lotto;

import java.util.ArrayList;
import java.util.List;

public class Target {
    private Input ipt = new Input();
    private List<Integer> numbers;
    private Lotto lotto;
    private int bonus;

    private void checkNums(String raw) {
        try {
            String[] raw_nums = raw.split(",");
            this.numbers = new ArrayList<>();

            for (String num : raw_nums) {
                numbers.add(Integer.parseInt(num));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Message.INPUT_NUMBER.getMessage());
        }
    }

    public Lotto targetNums() {
        while (true) {
            try {
                String input = ipt.targetInput();
                checkNums(input);
                lotto = new Lotto(this.numbers);
                return lotto;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkBonus(String raw) {
        for (int i = 0; i < raw.length(); i++) {
            if (!Character.isDigit(raw.charAt(i))) {
                throw new NumberFormatException(Message.INPUT_NUMBER_BETWEEN.getMessage());
            }
        }

        int chk = Integer.parseInt(raw);
        if (chk < 1 || chk > 45) {
            throw new IllegalArgumentException(Message.INPUT_NUMBER_BETWEEN.getMessage());
        } else if (this.numbers.contains(chk)) {
            throw new IllegalArgumentException(Message.INPUT_BONUS_DUPLICATE.getMessage());
        }

        this.bonus = chk;
    }

    public int bonusNum() {
        while (true) {
            try {
                String raw_num = ipt.bonusInput();
                checkBonus(raw_num);
                return this.bonus;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
