<p align="center">
    <img src="https://i.namu.wiki/i/SkMTyiOBeQBy4NXE89AWo53cPQM1lMbEz82RGF8MTdhB9xjLY5WSV7u9NXMVbxfQ5Ie84YQd9l96-tyTbCDZFQ.webp" alt="우아한테크코스" width="250px">
</p>

# 프리코스 3주차 미션 - 로또

![Generic badge](https://img.shields.io/badge/precourse-week3-green.svg)

[//]: # (![Generic badge]&#40;https://img.shields.io/badge/test-2_passed-blue.svg&#41;)

> 우아한테크코스 6기 프리코스 3주차 미션, 로또를 구현한 저장소입니다.

#### 실행 결과 예시

```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

---

# 목차
- [기능 목록](#기능-목록)
  - [금액, 당첨 번호, 보너스 번호 입력 및 로또 번호 출력](#금액,-당첨-번호,-보너스-번호-입력-및-로또-번호-출력)
  - [로또 번호와 당첨 번호 비교 및 수익률 계산](#로또-번호와-당첨-번호-비교-및-수익률-계산)
  - [당첨 내역 및 수익률 출력 후 게임 종료](#당첨-내역-및-수익률-출력-후-게임-종료)

---


## 기능 목록

### 금액, 당첨 번호, 보너스 번호 입력 및 로또 번호 출력

- 로또 구입 금액을 입력받는다.
  - 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - 금액에 문자가 들어간 경우 (ex. 100a, abc)
    - 1000원으로 나누어 떨어지지 않는 경우 (ex. 900, 14500)
- 발행한 로또 수량 및 번호를 출력한다. (로또 번호는 오름차순으로 정렬한다.)
```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]
```
- 당첨 번호를 입력받는다.(번호는 쉼표(,)를 기준으로 구분)
  - 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - 당첨 번호가 1~45사이 번호가 아닌 경우 (ex. 46, 0, -1)
    - 당첨 번호가 숫자가 아닌 경우 (ex. a, '')
    - 당첨 번호가 중복된 경우 (ex. '1,2,2,3,4,5')
    - 당첨 번호가 6개가 아닌 경우 (ex. '1,2,3,4,5')
- 보너스 번호를 입력받는다.
  - 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - 보너스 번호가 1~45사이 번호가 아닌 경우 (ex. 46, 0, -1)
    - 보너스 번호가 숫자가 아닌 경우 (ex. a, '')
    - 보너스 번호가 당첨 번호와 중복된 경우 (ex. 당첨 번호: 1,2,3,4,5,6 보너스 번호: 2)

### 로또 번호와 당첨 번호 비교 및 수익률 계산

- 당첨 번호 및 보너스 번호와 내가 구입한 로또 번호를 비교한다.
  - 당첨은 1등부터 5등까지 있다. 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 수익률을 계산한다. (소수점 둘째 자리에서 반올림)
  - ex. 100.0%, 51.5%, 1,000,000.0%

### 당첨 내역 및 수익률 출력 후 게임 종료

- 당첨 내역을 출력한다.
```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```
- 수익률을 출력한다.
```
총 수익률은 62.5%입니다.
```