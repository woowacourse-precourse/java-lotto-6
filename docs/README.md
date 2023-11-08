# 미션 - 로또

## 🔍 진행 방식

- 미션은 기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.


## 기능 목록


### model 패키지

#### NumberGenerator 클래스
+ [ ] createRandomNumbers() - 1~45의 무작의 정수 생성하는 메서드

#### Judgement 클래스
+ [ ] countMatchingNumbers() - 몇개의 번호가 일치하는지 확인하는 메서드

#### Lotto 클래스
+ [ ] calculateWinningPrize() - 당첨 금액을 확인하는 메서드
+ [ ] validate() - 입력 정보가 유효한지 확인하는 메서드

### view 패키지

#### Input 클래스
+ [ ] purchasePrice() - 구입 금액을 입력반는 메서드
+ [ ] receiveWinningNumbers() - 당첨 번호를 입력받는 메서드
+ [ ] receiveBonusNumber() - 보너스 번호를 입력 받는 메서드

#### Output 클래스
+ [ ] requestPurchasePrice() - 구매 금액을 입력해달라는 요청을 출력하는 메서드
+ [ ] confirmPurchase() - 구매 개수를 출력하는 메서드
+ [ ] purchasedLottoNumbers() - 구매한 로또의 번호를 출력하는 메서드
+ [ ] requestWinningNumbers() - 당첨 번호를 입력해달라는 요청을 출력하는 메서드
+ [ ] requestBonusNumber() - 보너스 번호를 입력해달라고 요청하는 메서드
+ [ ] resultStatistics() - 당첨 통계를 출력하는 메서드
+ [ ] profitPercentage() - 수익률을 출력하는 메서드

### controller 패키지

#### LottoController 클래스
+ [ ] initiatePurchase() - 구매를 시작하는 메서드
+ [ ] allPurchasedLottoNumbers() - 전체 구매한 로또의 번호를 출력하는 메서드
+ [ ] setWinningNumbers - 당첨 번호와 보너스 번호를 입력받는 메서드
+ [ ] set BonusNumber - 보너스 번호를 입력받는 메서드
+ [ ] calculateResult() - 결과를 계산하는 메서드
+ [ ] showResult() - 결과를 출력하는 메서드
+ [ ] calculateTotalProfitPercentage() - 전체 수익률을 계산하는 메서드

### constants 패키지

#### StringStore 클래스
+ 사용되는 문자열 상수를 저장하는 클래스

#### IntStore 클래스
+ 사용되는 정수형 상수를 저장하는 클래스