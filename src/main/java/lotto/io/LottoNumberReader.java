package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.entity.Lotto;

import java.util.List;

import static lotto.exception.LottoNumberException.LottoNumberException;

public class LottoNumberReader {
    public List<Integer> lotto_reader() {
        try {
            String input = Console.readLine();
            List<Integer> lottonumbers = LottoNumberException(input);
            Lotto lotto = new Lotto(lottonumbers);
            System.out.println("로또 번호 : "+lottonumbers);
            return lottonumbers;
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return lotto_reader(); // 예외가 발생한 경우 다시 입력하도록 재귀 호출
        }catch (IllegalArgumentException e) {
            System.out.println("다시 입력하시오"); // "다시 입력하세요" 출력
            return lotto_reader(); // 예외가 발생한 경우 다시 입력하도록 재귀 호출
        }
    }
}