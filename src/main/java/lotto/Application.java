package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static void checkLottoBundle(List<Lotto> lottoBundle) {
        Integer lottoCount = lottoBundle.size();
        System.out.println(lottoCount + "개를 구매했습니다.");

        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.lottoFormat());
        }
    }

    static List<Integer> numbersSeparator(String numberString) {
        List<String> separatedNumbersInString = List.of(numberString.split(","));

        List<Integer> separatedNumbers = new ArrayList<Integer>();
        for (String number : separatedNumbersInString) {
            separatedNumbers.add(Integer.parseInt(number));
        }

        return separatedNumbers;
    }


}
