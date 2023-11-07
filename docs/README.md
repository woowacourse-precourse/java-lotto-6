# 기능 목록
### 진행 순서대로 작성하였다.
- 게임 시작
- 도메인 세팅(Lotto, Lottos, User)
  - 금액을 입력받는다.
  - 입력받은 금액을 통해 유저 생성
  - 로또 개수에 맞게 Lotto 도메인에 추가
  - Lottos 도메인 안에 Lotto객체들 포장
- 중간 출력
  - 로또들의 리스트를 출력한다.
- 도메인 세팅(WinningNum, BonusNum)
  - 당첨 번호를 입력받는다.
  - WinningNum 도메인에 저장한다.
  - 보너스 번호를 입력받는다.
  - BonusNum 도메인에 저장한다.
- Rank(Enum) 생성
- 사용자의 도메인 업데이트(수익, n개 일치하는 로또를 m개 소유하고 있는지)
  - 유저의 로또들이 n개의 숫자가 m번 맞았는지 확인한다.
  - 사용자의 도메인에 수익과 보유 로또에 대한 정보를 업데이트 한다.
- 당첨 통계 출력
  - Rank(Enum)을 통해 정보를 받아와 형태에 맞게 결과를 출력한다.
  - 수익률을 계산하여 출력한다.

# 패키지 분리
## model/domain

---
### Lotto.java 
- Lotto의 도메인

### Lottos.java
- Lotto들을 ArrayList안에 포장한 Lottos 도메인

### User.java
- User의 도메인

### WinnigNum.java
- WinningNum(당첨번호)의 도메인

### Rank.java
- Rank의 도메인 (Enum)

### BonusNum.java
- BonusNum(보너스 번호)의 도메인

<br>

## model/service

---
### LottoService
- Lotto와 관련된 로직을 수행한다.

### UserService
- User의 정보와 관련된 로직을 수행한다.

## util

---
### LottoGenerator.java
- 로또에 들어갈 랜덤한 숫자를 만든다.

### NumberParser.java
- String(readLine)을 split한다.

<br>

## view

---
### OutputView.java
- 출력

### InputView.java
- 입력

<br>

## controller

---
### LottoController.java
- 컨트롤러
  - 게임의 진행을 담당한다.
