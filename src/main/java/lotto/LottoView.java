package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class LottoView {
    public void showRequestMessageOfPrice(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public Optional<String> inputPurchaseMoney(){
        return Optional.ofNullable(Console.readLine());
    }

    public void showAlertMessageOfNumberOfLotto(Integer numberOfLotto){
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    /**
     * 로또 번호 출력
     * @param purchasedLotto 구매한 로또 번호
     */
    public void showAlertMessageOfLottoNumber(List<Lotto> purchasedLotto){
        StringBuilder lottoNumbers = new StringBuilder();
        purchasedLotto.forEach(lotto-> lottoNumbers.append(lotto.toString()+"\n"));
        System.out.println(lottoNumbers);
    }

    public void showRequestMessageOfWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public Optional<String> inputWinningNumber(){
        return Optional.ofNullable(Console.readLine());
    }

    public void showRequestMessageOfBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public Optional<String> inputBonusNumber() {
        return Optional.ofNullable(Console.readLine());
    }

    public void showWinningStatisticsStartMessage(){
        System.out.println("당첨 통계\n---");
    }

    /**
     * 로또 당첨 통계 출력
     * @param purchasedLotto 구매한 로또
     */
    public void showWinningStaticsDetailMessage(Map<WinningPrice, List<Lotto>> purchasedLotto) {
        StringBuilder sb = new StringBuilder();
        purchasedLotto.forEach((winningPrice, lottos) -> {
            Optional<String> info = WinningPrice.getInfo(winningPrice);
            info.ifPresent(s -> sb.append(s).append(lottos.size()).append("개\n"));
        });

        System.out.println(sb);
    }

    public void showEarningsRate(Double earningsRate) {
        System.out.println("총 수익률은 " + parseEarningsRateToString(earningsRate) + "%입니다.");
    }

    /**
     * 수익률에 구분자 추가
     * @param earningsRate 구분자 없는 수익률
     * @return 구분자가 포함되어 있는 수익률
     */
    private String parseEarningsRateToString(Double earningsRate) {
        String earningsRateStr = earningsRate.toString();
        String[] earningsRateArr = earningsRateStr.split("\\.");
        earningsRateArr[0] = earningsRateArr[0].replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");

        return String.join(".", earningsRateArr);
    }
}
