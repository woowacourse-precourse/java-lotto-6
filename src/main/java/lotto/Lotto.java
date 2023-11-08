package lotto;
/*
    로또 객체 관리 클래스
    validate: 리스트 형식 판별 매소드
    lottoContains: 해당 번호가 로또번호 내에 존재하는지 판별하는 매소드.
    getNumbers: 로또번호 반환 매소드
    countMatch: 맞은 번호 카운팅 매소드
*/
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        String ErrorCode = "[ERROR] 로또 번호는 중복되지 않는 6개 번호 입니다. 프로그렘을 종료합니다.";
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode);
        }
        for (Integer integer : numbers) {
            int count = 0;
            for (Integer integer2 : numbers) {
                if (integer == integer2)
                    count++;
            }
            if (count == 2)
                throw new IllegalArgumentException(ErrorCode);
        }
    }

    // TODO: 추가 기능 구현

    //lottoContains: 해당 번호가 로또번호 내에 존재하는지 판별하는 매소드 - 맞는지 아닌지(boolean) 반환
    public boolean lottoContains(int a) {
        for (Integer integer : numbers) {
            if (a == integer)
                return true;
        }

        return false;
    }

    //getNumbers: 로또번호 반환 매소드
    public List<Integer> getNumbers() {
        return numbers;
    }

    //countMatch: 맞은 번호 카운팅 매소드 - 맞춘 번호 개수 반환
    public int countMatch(Lotto user) {
        int count = 0;
        int[] tmp = new int[46];

        for (Integer integer : user.getNumbers()) {
            tmp[integer] = 1;
        }

        for (int i : numbers) {
            count += tmp[i];
        }

        return count;
    }
}
