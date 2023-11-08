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

            for (String num: raw_nums) {
                numbers.add(Integer.parseInt(num));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자를 입력하세요.");
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
                throw new NumberFormatException("[ERROR] 1 이상 45 이하의 숫자를 입력하세요.");
            }
        }

        int chk = Integer.parseInt(raw);
        if (chk < 1 || chk > 45) {
            throw new IllegalArgumentException("[ERROR] 1 이상 45 이하의 숫자를 입력하세요.");
        } else if (this.numbers.contains(chk)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
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
