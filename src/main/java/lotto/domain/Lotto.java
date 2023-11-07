package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.message.ExceptionMessage;
import lotto.common.utils.NumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NumberUtil.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.NUMERIC_LENGTH_CHECK);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    //로또 랜덤 번호 발행
    public static void randomNumberLotto(int lottoCount){
        List<Lotto> allLotto = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            Lotto lotto = generateUniqueLotto();
            allLotto.add(lotto);
        }
        lottoResult(allLotto);
    }

    // 중복된 로또를 생성하고 반환하는 메서드
    public static Lotto generateUniqueLotto() {
        List<Integer> numbers;
        do {
            numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, NumberUtil.LOTTO_NUMBER_COUNT);
        } while (isDuplicate(numbers)); // 중복이 있는 경우 다시 생성

        return new Lotto(numbers);
    }

    //로또에 중복이 없는지 체크
    public static boolean isDuplicate(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        return distinctNumbers.size() != NumberUtil.LOTTO_NUMBER_COUNT;
    }

    //로또 오름차순으로 보여줌
    public static void lottoResult(List<Lotto> lottoResult){
        lottoResult.forEach(lotto -> {
            List<Integer> sortedNumbers = lotto.getNumbers().stream()
                    .sorted() // 번호를 오름차순으로 정렬
                    .collect(Collectors.toList());
            System.out.println(sortedNumbers);
        });
    }


}
