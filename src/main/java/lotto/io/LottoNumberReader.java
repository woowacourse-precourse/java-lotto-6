package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.exception.LottoNumberException.LottoNumberException;

public class LottoNumberReader {
    public List<Integer> lotto_reader() {
        String input = Console.readLine();
        List<Integer> lotto_numbers = LottoNumberException(input);
        System.out.println("로또 번호:"+lotto_numbers);
        return lotto_numbers;
    }
}