# 기능 구현 목록

## LottoGenerator (로또 생성기)
로또를 생성해주는 클래스이다. 로또를 생성해주고 반환하는 함수를 가진다.

## Lotto (로또)
로또 클래스 이다. 로또의 number를 가지며 로또에 대한 validation 과 WinningNumber 와 check 하는 함수를 가진다. 

## User (사용자)
money 와 `List<Lotto>` 를 가지는 클래스이다.

## WinningNumber (당첨 번호)
당첨 번호와 보너스 번호를 저장하는 불변 객체이다.

## LottoSeller (로또 판매자)
LottoGenerator를 통해 로또를 만들고 사용자의 money에 따라 개수에 맞는 로또를 반환해주는 클래스이다.

## LottoManager
로또 전체를 진행하는 클래스이다.

## Rank (enum)
상금과 보너스 번호 여부, 로또 번호와 어느 정도 맞는 지에 따라 상금을 결정하는 enum 이다.

## InputView
Input과 관련된 기능을 수행하는 클래스이다.

## Printer
출력을 담당하는 클래스이다.
