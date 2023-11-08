## 🎯 흐름 정리
1. 로또 구입 금액 입력 받음 
2. 구매한 장수에 맞게 1 ~ 45 사이의 랜덤한 숫자 6개 발행
3. 당첨 번호를 입력 받음
4. 보너스 번호를 입력 받음
5. 구매한 모든 로또들과 당첨 번호 비교 
6. 구매한 모든 로도들에 대해 당첨내역 및 수익률 출력 
7. 게임 종료 

## ⚒️ 기능 목록
- 예외 발생 시 해당 부분부터 다시 입력을 받는다.
### 로또 구매
- 로또 구매 금액을 입력받는 기능
- 예외: 금액이 1000원으로 나누어 떨어지지 않는 경우
### 로또 발행
- 구매한 로또에 대해 1 ~ 45 사이의 임의의 숫자 6개를 뽑는 기능
- 번호를 오름차순으로 정렬하여 출력하는 기능
- 발행한 로또의 수 출력하는 기능
### 당첨 번호와 보너스 번호를 입력받는 기능
- 쉼표(,)로 연결된 여섯개의 번호와 보너스 번호를 추가적으로 입력 받는 기능 
- 예외: 입력 받은 번호가 1~45 사이의 수가 아닐 경우 예외처리
- 예외: 입력 받은 수가 문자가 아닌 경우
- 예외: 입력 받은 수가 중복이 되는 경우
- 예외: 입력 받은 수가 6개가 아닌 경우
### 로또 번호와 당첨 번호 비교
- 로또 번호와 당첨 번호를 비교하는 기능
- 당첨 내역과 수익률을 계산 및 저장하는 기능
- 보너스 번호를 확인하는 기능
- 총 수익률과 당첨내역을 출력하는 기능 

## 🪜구조
### domain
- JackpotNumber : 당첨 로또 번호와 보너스 번호를 저장하는 도메인
- Lotto : 한장의 로또 번호를 저장하는 도메인
- Rank : 결과를 알려주는 Enum을 활용한 클래스
- Result : 사용자의 결과를 저장하는 클래스
- User : 로또 장 수와 사용자의 로또번호를 저장하는 클래스
### service
- DecideAward : 사용자의 로또와 JackpotNumber를 비교해 결과를 반환하는 서비스
- ProfitCalculator : 로또 결과에 따른 수익률 계산 서비스
- UserBillToAmount : 사용자 입력 금액에 따른 로또 장 수 게산 서비스
- UserLottoService : 사용자 로또 생성 서비스
### utils
- BillException : 사용자가 입력한 금액에 대한 예외처리
- JackpotNumberException : 사용자가 입력한 당첨 로또번호와 보너스 번호에 대한 예외처리
### view
- InputView : 사용자의 입력을 필요로하는 뷰 
- OutputView : 출력만을 필요로하는 뷰

## 🤔 테스트 목록
### 1️⃣ domainTest

#### jackpotTest
- isInRangeTest : 당첨 로또가 1 ~ 45 사이의 번호인지 여부 테스트
- isRepeatedTest : 당첨 로또 속에 중복된 번호가 존재하는지 테스트
- isSixValuesTest : 당첨 로또의 번호 수가 6개인지 테스트
- isBonusRepeatedTest : 보너스 번호가 당첨 로또 번호와 중복이 되는지 테스트
#### LottoTest
- lottoSixValuesTest : 로또 입력 값이 6개 이상인지 테스트
- lottoOrderedTest : 로또가 정렬된 채 저장이 되었는지 테스트
#### RankTest
- firstWinTest : 모든 번호가 일치할 경우 FIRST을 반환해야한다
- secondWinTest : 다섯개의 번호와 보너스 번호가 맞을 경우 SECOND를 반환해야한다
- thirdWinTest : 다섯개의 번호는 일치하고 보너스 번호는 일치하지 않을 경우 THIRD를 반환해야한다
- noneWinTest : 한개의 번호만이 일치할 경우 NONE을 반환해야한다
#### ResultTest
- lottoOrderedTest : Result 배엘에 rank가 올바르게 저장되는지 확인하는 테스트
#### UserTest
- billToLottoTest : 사용자가 입력한 구매 금액이 1000원 단위인지 테스트
- lottoCountTest : 사용자가 입력한 구매 금액에 따른 생성된 로또의 수가 올바른지 확인하는 테스트

### 2️⃣ serviceTest
#### DecideAwardTest
- examineGettingAwardTest : 사용자의 로또와 당첨 로또에 대한 올바른 결과 반환 여부 테스트