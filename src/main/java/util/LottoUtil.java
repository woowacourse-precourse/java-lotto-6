package util;

public class LottoUtil {

    // 금액 계산기
    public static int countLotto(int pay) {
        return pay / 1000; // TODO: 상수 처리 필요
    }

    // 로또 생성기
    public static List<Lotto> makeLottoList(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        while(count-- > 0) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6)); // TODO: 상수 처리 필요
            Collections.sort(numbers);
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }
}
