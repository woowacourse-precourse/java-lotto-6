package lotto;

import java.util.List;
import java.util.Objects;
import org.mockito.internal.matchers.Find;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자가 6개가 아닙니다.");
        }
        for(int i=0; i<numbers.size(); i++)
        {
            for(int t=i+1; t<numbers.size(); t++){
                if(Objects.equals(numbers.get(i), numbers.get(t)))
                    throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> Get_numbers() {
        return this.numbers;
    }

    public int Lotto_Jackpot_Return(List<Integer> Win_lotto_list, int Win_lotto_bonus_number) {
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            int tmp = numbers.get(i);
            for (int t = 0; t < 6; t++) {
                if (tmp == Win_lotto_list.get(t)) {
                    cnt++;
                    break;
                }
            }
        }
        return Lotto_Bonus_Checkout(cnt, Win_lotto_bonus_number);
    }

    public int Lotto_Bonus_Checkout(int cnt, int Win_lotto_bonus_number) {
        if (cnt == 5) {
            boolean bonus_correction = false;
            for (int i = 0; i < 6; i++) {
                if (numbers.get(i) == Win_lotto_bonus_number) {
                    return 7;
                }
            }
        }
        return cnt;
    }
}