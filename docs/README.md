# Mission
우아한 테크코스 3주차 프리코스 미션 - 로또

---------------
## 개발 목표
  1. Console.close(); 를 빼먹지 않는다.
  2. test사용법을 익숙해진다.
  3. 주석을 너무 과하지 않게 쓴다.
  4. Class명과 메서드명의 의미를 정확하게 하여 주석없이도 이해가능하도록 만든다.
  5. 작동하는 Application에서는 Lotto.start();만 호출해보자!
  6. Lotto클래스에서 전부 구현을 해보고 기능별로 나누는 연습을 해보자!
----------------
### 개발 환경

- `Java 17.0.9`
- `Eclipse`

### 개발 작업
- Application.java 의 main에서 작동

 Application();
```
- Lotto 클래스에 필요한 메서드 추가
```
MatchType();
```
- Enum으로 숫자 관리)
```
drawLottoNumbers();
```
- 로또번호 추첨
```
printPurchaseLottoNumbers();
```
- 구매 및 검사, 수익률 추출
```
updateMatchArr();
```
- 숫자가 5개가 맞고 보너스번호도 맞은 결과값을 받을경우 2등에당첨
```
printMatchStatistics();
```
- 당첨통계출력
```
calculateRateOfReturn();
```
 - 수익률계산
```
countMatchingNumbers();
```
 - 보너스번호까지 맞았을 결과물을 만드는 메서드
```
getUserPurchaseAmount();
```
로또 구입갯수 정하는 매서드
```
getWinningNumber();
```
사용자로부터 번호를 입력받는 메서드
```
getValidBonusNumber();
```
- 사용자로부터 보너스번호를 입력받는 메서드
```
