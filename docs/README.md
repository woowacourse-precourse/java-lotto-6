# 기능 목록
### 흐름 순서대로 작성
- 게임 시작
  - 금액을 입력받는다.
  - 입력받은 금액을 통해 유저 생성
  - 개수에 맞게 로또 생성 후 Lottos로 로또들 포장
  - 로또들의 리스트를 출력한다.
  - 당첨 번호를 입력받는다.
  - 유저의 로또들이 n개의 숫자가 m번 맞았는지 확인한다.
  - Rank(Enum)을 통해 정보를 받아와 형태에 맞게 결과를 출력한다.
  - 수익률을 계산하여 출력한다.

# 패키지 분리 및 메서드
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
