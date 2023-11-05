# 로또

* * *

## 기능 목록
### 0. 게임 시작
게임을 시작하고, 게임에 필요한 기본적인 클래스들을 생성한다.

### 1. 로또 발행
플레이어에게 로또 구입 금액을 입력 받는다.
사용자가 입력한 로또 구입 금액에 따라, 로또를 발행한다.
- (로또 개수) = (로또 구입 금액)/1000

잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨다.

입력은 문제에서 주어진 라이브러리를 이용한다.
- `camp.nextstep.edu.missionutils.Console`의 `readLine()`

로또 발행은 문제에서 주어진 라이브러리를 이용하여, 번호를 랜덤으로 생성한다.
- `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`

### 2. 당첨 번호 입력 받기
당첨 번호 6개와 보너스 번호 1개를 입력 받는다.
- `camp.nextstep.edu.missionutils.Console`의 `readLine()`

### 3. 상금 통계 내기
사용자가 입력한 당첨번호, 보너스번호와 기능(1)에서 발행한 로또 숫자들을 비교하여 당첨 통계를 계산한다.

### 4.수익률 계산하기
기능(3)에서 구한 통계를 토대로 수익률을 계산한다.
- (수익률) = (상금) / (구입 금액+상금)