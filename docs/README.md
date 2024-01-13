필요한 기능들을 패키지로 묶어보자

- 로또 번호들이 있는 패키지 (numbers)
    - 난수 생성된 로또 번호가 있는 클래스 Lotto
    - 사용자로부터 로또 번호 6개와 보너스 번호 1개를 입력받아 저장하는 클래스 UserInputNumbers
- 각종 메서드가 있는 패키지 (util):
    - LottoManager
    - Money
    - 당첨된 로또 개수를 enum으로 저장 (당첨금과 수 포함)

1. 구입 금액을 입력 받는 메서드 receivePurchaseAmount() → Money 객체로 저장
2. 로또를 발행하고 수량과 번호들을 오름차순으로 출력한다.
   generateLottos(int money) -> return List<Lotto> lottos 객체로 저장
   -> printGeneratedLottoNumbers(List<Lotto> lottos)
3. 당첨 번호 6개를 입력받음(쉼표로 구분), 보너스 번호 1개를 입력받음
   receiveLottoNumber() -> return new UserInputNumbers 객체로 저장
4. enum 당첨 금액과 수량 저장 (출력 기능 포함)
5. 일치하는 개수를 검사하고 등수를 체크, 출력하는 기능 Map<WinningCheck, Integer>에 저장
   -> printWinningResult(Map<WinningCheck, Integer> result)
6. 수익률을 출력하는 기능 (소수 둘째 자리에서 반올림) printProfitRate(int amount, Map<WinningCheck, Integer> result)
