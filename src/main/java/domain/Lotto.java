package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final String START_MESSAGE = "[ERROR]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate();
        this.numbers = numbers;
    }

    private void validate() {
        validateEmpty(numbers);
        validateSize(numbers);
        validDuplicates(numbers);
    }

    // TODO: 추가 기능 구현
    private static void validateEmpty(List<Integer> numbers) {
        if (numbers.size() == 0) {
            throw new IllegalArgumentException(
                    String.format("%s 아무 것도 입력되지 않았습니다."));
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(
                    String.format("%s 로또 번호의 개수는 %d개여야 합니다.", START_MESSAGE, LOTTO_SIZE));
        }
    }

    private static void validDuplicates(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(
                        String.format("%s 중복된 숫자가 입력되었습니다.", START_MESSAGE));
            }
        }
    }

    public static long countLottoTickets(long payment) {
        return payment / 1000;
    }

    public static Lotto generateLottoTicket() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    public static List<Lotto> generateTotalLottoList(long ticketsCount) {
        List<Lotto> totalLottoList = new ArrayList<>();
        for (int i = 0; i < ticketsCount; i++) {
            totalLottoList.add(generateLottoTicket());
        }
        return totalLottoList;
    }

    public List<Integer> cloneNumbers() {
        return new ArrayList<>(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
