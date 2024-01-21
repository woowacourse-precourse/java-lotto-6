Application과 동일 선상에 RunLotto 클래스 생성

LottoManager에 필요한 기능들을 패키지로 묶어보자

- 도메인 모델 패키지 (domain)
    - 사용자로부터 입력받은 구입금액을 저장하는 클래스 PurchaseAmount
    - 난수 생성된 로또 번호가 있는 클래스 Lotto
    - 사용자로부터 로또 번호 6개와 보너스 번호 1개를 입력받아 저장하는 클래스 UserInputNumbers
    - 상금과 당첨 수를 저장하는 열거형 enum WinningCheck
- 비즈니스 로직을 수행하는 서비스 패키지 (service)
    - 당첨 결과를 계산하는 클래스 LottoResultCalculator
    - 수익률을 계산하는 클래스 LottoProfitRateCalculator
    - 구입금액만큼 로또를 발행하는 클래스 LottoGenerator
- 각종 메서드가 있는 패키지 (util)
    - 사용자로부터 값들을 입력받는 클래스 InputManager
    - 결과들을 출력하는 클래스 OutputManager

동작 구조

1. receivePurchaseAmount()로 구입금액을 입력받아 PurchaseAmount에 객체로 저장(유효성 검사)
2. 생성된 PurchaseAmount를 받아 generateLottos(PurchaseAmount purchaseAmount)
   입력받은 양 만큼 Lotto 객체로 로또를 발행(유효성 검사) -> 리턴 값은 List<Lotto>로 generatedLottos를 리턴
3. generatedLottos를 매개변수로 받아 printGeneratedLottoNumbers(List<Lotto> lottos) 생성된 로또들을 출력
4. calculateWinningResult(List<Lotto> lottos, UserInputNumbers receivedLotto)
   Map<WinningCheck, Integer>을 이용해서 result를 생성 WinningCheck에 열거형으로 상금과 당첨 수를 저장
   Lotto클래스에서 각 로또 당 matchCount와 bonusMatch를 가져온다 -> WinningCheck.getPrize(matchCount, bonusMatch)
   -> 각 로또 당 상금과 수를 result에 저장 후 리턴
5. calculateProfitRate(PurchaseAmount purchaseAmount, Map<WinningCheck, Integer> result)
   구입금액과 결과를 비교하여 수익률을 계산(소수 둘째에서 반올림) -> 리턴 값은 double profitRate
6. printResults(Map<WinningCheck, Integer> result, double profitRate) 최종 결과 출력
