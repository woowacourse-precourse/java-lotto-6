# 우아한 프리코스 미션 - 로또

----
## Project
이 프로젝트는 우아한 테크코스에서 사전 선별과정 중 프리코스 과정 3주차 미션이다.

프로젝트의 내용은 다음과 같다.

1. 로또를 구매하기 위한 비용을 입력 받는다.
2. 당첨 번호를 사용자에게서 입력 받는다. (보너스 번호 또한 받는다.)
3. 구매한 로또와 당첨번호를 비교하여 3개의 번호 이상 동일한 경우 로또 당첨 금액을 돌려받는다.
4. 받은 총 당첨 금액과 구매 금액을 비교하여 수익률을 계산하여 보여준다.
---
## Flow Chart
![flow chart.png](..%2FImages%2Fflow%20chart.png)

---
## 구현 기능
1. controller : 핵심 로직을 표현
2. domain : 핵심 로직에 들어가는 세부 로직을 구현 및 표현
3. constants : 모든 상수를 정의
4. view : 데이터를 표현하는 로직을 구현
5. dto : Lotto라는 데이터를 변환하고, 생성하는 로직을 구현

### controllor
    LottoController.java
    - 전체적인 흐름을 표현하는 코드 파일 
    - 구입한 Lotto List를 purchaseLottoNumberDomain으로 부터 받고, 
    - 당첨 로또 번호가 있는 Integer List를 setLottoNumberDomain으로 부터 받는다.
    - 위 2개의 List를 LottoWinningResultDomain에 인자로 주입한다.
### domain
    EnterLottoWinningNumbersDomain.java
    - 로또 당첨 번호를 사용자에게 받는 세부 로직이 들어간 코드 파일
    - 사용자로부터 당첨 번호를 받고, Integer List에 초기화 시켜준다.
    - 그 후 사용자로부터 보너스 번호를 받고, Integer List에 추가시켜준다.
    - 위 List를 리턴하여 controller에게 전달한다. 
    LottoStatisticsDomain.java
    - 로또 당첨 통계를 내는 세부 로직이 들어간 코드 파일
    - LottoWinningResultDomain에서 구입한 Lotto List와 당첨 번호 List를 인자로 받는다.
    - 각 로또의 번호와 당첨 번호 및 보너스 번호를 비교하여 일치하는 번호의 개수를 Integer List에 저장한다.
    - 이 저장된 리스트를 LottoWinningResultDomain에게 전달한다.
    LottoWinningResultDomain.java
    - 로또 당첨 통계를 View와 연결시키는 로직이 들어간 코드 파일
    - LottoStatisticsDomain에서부터 일치하는 번호가 들어간 Integer List를 받는다.
    - 이 List를 LottoStatisticsView에게 전달하여 보여준다.
    PurchaseLottoNumberDomain.java
    - 구입할 금액을 확인하고, 랜덤 로또를 생성하는 세부 로직이 들어간 코드 파일
    - 사용자로부터 구입할 금액을 받아 int 자료에 초기화 시킨다.
    - 이 데이터를 PurchaseLottoDto에 넘겨 Lotto List를 받아온다.
    - 받은 Lotto List 데이터를 controller에게 전달한다.
### constants
    EnterLottoWinningNumberConstants.java
    - 당첨 번호 및 보너스 번호 UI가 나올 때 사용되는 상수를 나타낸 코드 파일
    ErrorMesssageConstants.java
    - enum을 사용하여 Validation에서 사용하는 모든 에러메시지를 나타낸 코드 파일
    LottoNumberConstants.java
    - 로또에 관련한 상수를 나타낸 코드 파일
    LottoWinningResultConstants.java
    - 로또 통계 결과 UI가 나올 때 사용되는 상수를 나타낸 코드 파일
    NumberOfLottoPurchaseConstants.java
    - 구입하는 UI가 나올 때 사용되는 상수를 나타낸 코드 파일
    WinningAmountOfLottoFloat
    - enum을 사용하여 통계에 사용할 당첨 금액을 나타낸 코드 파일
    WinningAmountOfLottoString
    - enum을 사용하여 UI에 사용할 당첨 금액을 나타낸 코드 파일
    WinningLottoCount.java
    - enum을 사용하여 당첨 숫자 개수를 표현한 코드 파일
### dto
    PurchaseLottoDto.java
    - 랜덤 로또를 생성하는 세부 로직이 들어간 코드 파일
    - 구입 금액을 기반으로 Lotto를 생성하고, List자료형으로 하나의 객체로 묶는다.
    - 이 묶인 객체를 PurchaseLottoNumberDomain에게 전달한다.
### view
    EnterLottoWinningNumberView.java
    - 당첨 번호 및 보너스 번호를 사용자에게 받는 UI가 들어간 로직
    - 위 받은 번호들을 String자료형으로 EnterLottoWinningNumbersDomain에게 전달한다.
    LottoWinningStatisticsView.java
    - 당첨 로또 통계를 사용자에게 보여주는 UI가 들어간 로직
    - LottoWinningResultDomain으로부터 당첨 번호 개수가 들어간 Integer List를 받아 통계를 표현한다.
    lottoPurchasedResult.java
    - 로또 구입 금액을 사용자에게 받는 UI가 들어간 로직
    - 로또 구입 금액을 String자료형으로 받아 PurchaseLottoNumberDomain에게 전달한다.