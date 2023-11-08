![wooteco](https://github.com/AidenRoh/wooteco-precourse/assets/124841119/08c069a4-a7b0-41c1-884f-dfc6af17d373)

# 프리코스 3주차 미션: 로또

![Generic badge](https://img.shields.io/badge/precourse-week3-blue.svg)
![Generic badge](https://img.shields.io/badge/unitTest-6-green.svg)

> 우아한테크코스 6기 3주차 미션, 로또를 구현한 저장소입니다.

<br>

![lottoVideo](https://github.com/AidenRoh/wooteco-precourse/assets/124841119/f2e35062-5239-4829-8ba9-491804aa41af)

---

## 목차

- [패키지 구조](#패키지-구조)
- [게임 흐름](#게임-흐름)
- [기능 목록](#기능-목록)

<br>

---

## 패키지 구조

<br>

```



```

## 게임 흐름

<br>

---

## 기능 목록

> 게임 흐름 순서로 기능 목록이 나열되어 있습니다. [게임 흐름](#게임-흐름)

### 1️⃣ 로또 번호의 숫자 범위는 1부터 45까지이다

- [x] 필요한 기능

    - **[범위 설정]** : 숫자 범위를 설정할 수 있다.
    - **[주어진 설정 요구사항]** : 최소값이 1, 최대값이 45 이다.
      <br>

- [x] 해당 기능과 관련된 예외 상황

    - **[플레이어의 잘못된 당첨 번호]** : 플레이어가 입력한 당첨 번호에 로또 번호의 범위에 벗어난 숫자가 있는 경우
    - **[플레이어의 잘못된 보너스 번호]** : 플레이어가 입력한 보너스 번호에 로또 번호의 범위에 벗어난 숫자가 있는 경우

<br>

##### ⚠️ 예외 처리 ⚠️

- [x] ``IllegalArgumentException``를 상속한 **[LottoException]** 을 활용한다.
- [x] 예외 발생 시, 예외 사항과 관련된 메세지를 플레이어에게 출력하고 재입력을 요구한다.
    - **[INVALID_LOTTO_NUMBER]** : ``LottoException``을 호출하고 Error 메세지를 출력한다.
    - **[입력 재요청]** : 예외가 발생한 입력 지점으로 돌아와 입력 재요청한다.

<br>

### 2️⃣ 구입 금액을 정하면, 해당 구입 금액만큼 로또를 구매한다.

- [x]

<br>

##### ⚠️ 예외 처리 ⚠️

- [x] ``IllegalArgumentException``를 상속한 **[LottoException]** 을 활용한다.
- [x] 예외 발생 시, 예외 사항과 관련된 메세지를 플레이어에게 출력하고 재입력을 요구한다.
    - **[EmptyPlayTimeValidator]** : 입력값이 비어있는 경우, ``RacingCarException``을 호출한다
    - **[IntegerTypeValidator]** : 입력값이 ``Integer``타입이 아닌 경우, ``RacingCarException``을 호출한다
    - **[MinimumPlayTimeValidator]** : 입력값이 최소 시도 횟수 (1) 미만인 경우, ``RacingCarException``을 호출한다

<br>

### 3️⃣ 당첨 번호와 보너스 번호를 설정한다.

- [x] 시도 횟수만큼 다음 과정을 반복하여 진행한다.

<br>

### 4️⃣ 당첨 통계를 출력한다.

- [x] 게임이 모두 진행된 우승자를 출력한다.
    
---