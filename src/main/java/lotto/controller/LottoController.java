package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.message.ExceptionMessage;
import lotto.common.message.InputMessage;
import lotto.common.message.OutputMessage;
import lotto.domain.Lotto;
import lotto.validator.InputValidator;
import lotto.views.InputView;
import lotto.views.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;
    private static final List<Lotto> lottoResult = new ArrayList<>();
    private final InputValidator inputValidator = new InputValidator();


    public void start(){
        String inputPrice = inputPrice();
        boolean isRestart;
        try{
           isRestart = inputValidator.validateInputPrice(inputPrice);
        } catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
            start();
            return;
        }
        nextPriceCheck(isRestart, Integer.parseInt(inputPrice));
    }

    public String inputPrice(){
        System.out.println(InputMessage.INPUT_PRICE);
        return Console.readLine();
    }

    public void nextPriceCheck(boolean isRestart, int inputPrice) {
        if (isRestart) {
            System.out.println(ExceptionMessage.INPUT_PRICE_CHECK);
            start();
            return;
        }
        int lottoCount = publishLotto(inputPrice);
        randomNumberLotto(lottoCount);
    }

    public int publishLotto(int inputPrice){
        int lottoCount = inputPrice / LOTTO_PRICE;
        System.out.println();
        System.out.println(String.format(OutputMessage.BUYING_RESULT, lottoCount));
        return lottoCount;
    }

    //로또 랜덤 번호 발행
    public void randomNumberLotto(int lottoCount){
        lottoResult.clear();
        for (int count = 0; count < lottoCount; count++) {
            Lotto lotto = generateUniqueLotto();
            lottoResult.add(lotto);
        }
        lottoResult(lottoResult);
    }

    //로또에 중복이 없는지 체크
    public boolean isDuplicate(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        return distinctNumbers.size() != LOTTO_NUMBER_COUNT;
    }

    // 중복된 로또를 생성하고 반환하는 메서드
    public Lotto generateUniqueLotto() {
        List<Integer> numbers;
        do {
            numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT);
        } while (isDuplicate(numbers)); // 중복이 있는 경우 다시 생성

        return new Lotto(numbers);
    }

    //로또 오름차순으로 보여줌
    public void lottoResult(List<Lotto> lottoResult){
        lottoResult.forEach(lotto -> {
            List<Integer> sortedNumbers = lotto.getNumbers().stream()
                    .sorted() // 번호를 오름차순으로 정렬
                    .collect(Collectors.toList());
            System.out.println(sortedNumbers);
        });
    }

}
