package lotto.lottosystem.presentation.reader;

import lotto.lottosystem.bussiness.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Reader {

    private final LottoConsole lottoConsole;

    public Reader(LottoConsole lottoConsole) {
        this.lottoConsole = lottoConsole;
    }

    public MoneyVO readMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        String rawValue = lottoConsole.readLine();
        if (validateNumber(rawValue)) {
            return new MoneyVO(Integer.parseInt(rawValue));
        }
        throw new IllegalArgumentException("구입 금액은 숫자만 입력 가능합니다.");
    }

    public LottoNumbersVO readLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto lottoNumbers = readNumbers();
        System.out.println();
        System.out.println("보너스 번호를 입력 해주세요.");
        int bonusNumber = readNumber();
        System.out.println();
        return new LottoNumbersVO(lottoNumbers, bonusNumber);
    }

    private Lotto readNumbers() {
        String numbers = lottoConsole.readLine();
        if (validateNumbers(numbers)) {
            return new Lotto(parseNumbers(numbers));
        }
        throw new IllegalArgumentException("당첨 번호는 공백을 제외한 숫자와 숫자 사이의 콤마만 입력 가능합니다.");
    }

    private int readNumber() {
        String number = lottoConsole.readLine();
        if (validateNumber(number)) {
            return Integer.parseInt(number);
        }
        throw new IllegalArgumentException("보너스 번호는 숫자만 입력 가능합니다.");
    }

    private boolean validateNumbers(String rawNumbers) {
        return rawNumbers.matches("^\\d+(,\\d+)*$");
    }

    private boolean validateNumber(String number) {
        return number.matches("\\d+");
    }

    private List<Integer> parseNumbers(String rawNumbers) {
        String[] numbers = rawNumbers.split(",");
        List<Integer> lottoNumber = new ArrayList<>();
        for (String number : numbers) {
            lottoNumber.add(Integer.parseInt(number));
        }
        return lottoNumber;
    }

    private void checkDuplicate(Lotto lotto, Integer bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자와 당첨 번호는 중복 되어선 안됩니다.");
        }
    }
}
