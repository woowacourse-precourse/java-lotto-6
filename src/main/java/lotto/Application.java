package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playLotto();
    }

    public static void playLotto() {
        int purChaseAmount = inputPurchaseAmount();
        List<Integer> lottoNumbers = inputLottoNumbers();
        int bonusNumber = inputBonusNumber();

        System.out.println(purChaseAmount);
        for (Integer lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
        System.out.println(bonusNumber);
    }

    public static int inputPurchaseAmount() {
        int purchaseAmount = Integer.parseInt(Console.readLine());

        return purchaseAmount;
    }

    public static List<Integer> inputLottoNumbers() {
        String inputLottoNumbers = Console.readLine();

        String[] splitInputLottoNumbers = inputLottoNumbers.split(",");
        List<String> lottoNumbers = List.of(splitInputLottoNumbers);

        return stringListToIntegerList(lottoNumbers);
    }

    public static List<Integer> stringListToIntegerList(final List<String> lottoNumbers) {
        return lottoNumbers
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());

        return bonusNumber;
    }

}
