package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.List;

public class OutputView {
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printTicket(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getTicket()) {
            List<LottoNumber> lottoNumbers = lotto.getNumbers();
            String lottoLetter = makeSentence(convertToStringList(lottoNumbers));
            System.out.println(lottoLetter);
        }
    }

    private static List<String> convertToStringList(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(lottoNumber -> Integer.toString(lottoNumber.getNumber()))
                .toList();
    }

    private static String makeSentence(List<String> lottoNumbers) {
        String lottoNumbersLetter = String.join(", ", lottoNumbers);
        return String.format("[%s]",lottoNumbersLetter);
    }
}
