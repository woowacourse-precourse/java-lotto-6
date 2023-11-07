package lotto.model;

import java.util.List;

import static lotto.Utils.makeLottoNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개로 이루어져있습니다.");
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.indexOf(numbers.get(i)) != numbers.lastIndexOf(numbers.get(i))) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다");
            }
        }
    }

    // TODO: 추가 기능 구현


    public static Lotto makeLotto() {
        List<Integer> lottoNumbers = makeLottoNumber();
        return new Lotto(lottoNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // Lotto 클래스 내에 추가할 메소드입니다.
    public int checkWinning(Lotto winningLotto, int bonusNumber) {
        int matchCount = 0;
        for (int number : this.numbers) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }

        if (matchCount == 6) {
            return 1; // 1등
        } else if (matchCount == 5 && this.numbers.contains(bonusNumber)) {
            return 2; // 2등
        } else if (matchCount == 5) {
            return 3; // 3등
        } else if (matchCount == 4) {
            return 4; // 4등
        } else if (matchCount == 3) {
            return 5; // 5등
        } else {
            return 0; // 당첨되지 않음
        }
    }

}