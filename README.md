# java-blackjack

블랙잭 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)


---
# 기능 요구 분석

## 입력
- [x] 게임에 참여할 플레이어 목록을 입력 받는다.
  - [x] 이름에는 공백을 허용하지 않는다.
- [x] 플레이어가 카드를 더 받을지에 대한 여부를 입력 받는다.

## 출력
- [x] 게임에 참여할 사람의 이름을 입력받는 메세지 출력
- [x] 딜러와 플레이어들에게 2장씩 카드 분배 완료 메세지 출력
  - [x] 딜러 카드 1장 출력
  - [x] 플레이어 카드 2장 출력
- [x] 각 플레이어가 카드를 한장 더 받을지에 대한 여부를 묻는 메세지 출력
- [x] 각 플레이어가 현재 보유한 카드를 출력
- [x] 딜러가 추가적으로 카드를 받는지에 대한 메세지 출력
- [x] 딜러와 플레어의 점수와 카드를 출력
- [x] 최종 승패 출력

## 도메인

### 참여자
- [x] 보유한 `카드 목록`을 갖는다.
- [x] 보유하고 있는 카드의 합을 반환한다.
- [x] 카드를 추가한다.

### 플레이어
- [x] 이름을 갖는다
  - [x] 이름의 1이상 5이하의 길이만 가능하다.
  - [x] 이름에 공백이 있는 경우 예외가 발생한다.
  - [x] 참여자 이름은 `딜러`가 될 수 없다.
- [x] 참가자는 중복을 허락하지 않는다.
- [x] 참가자는 1명부터 7명까지 가능하다.
- [x] 카드를 더 받을지 여부를 판단한다
  - [x] 버스트나 블랙잭이 아닌 경우 계속해서 받을 수 있다.

### 딜러
- [x] 카드를 추가적으로 받을 수 있는 상황인지 확인한다.
  - [x] 16이하인 경우 카드를 받을 수 있다.
  - [x] 카드는 3장까지 받을 수 있다.

### 패 (사용자가 받은 카드들)
- [x] 카드를 추가한다.
- [x] 점수를 계산한다.
- [x] ACE의 개수를 반환한다.

## 게임 매니져
- [x] 딜러와 플레이어게 처음에 2장씩 나눠준다.
- [x] 이후에는 덱에서 카드를 뽑아서 플레이어와 딜러에게 1장씩 나눠준다.
- [x] 딜러와 플레이어와의 승패를 판단한다.

## 덱
- [x] 덱은 생성되면 52장의 카드를 갖는다.
- [x] 덱은 카드를 섞을 수 있다.
- [x] 제일 위에 있는 카드를 1장 반환한다.

### 카드
- [x] 카드는 숫자와 문양으로 구성된다.
  - [x] `스페이드`, `다이아`, `하트`, `클로버` 총 4가지 문양를 갖는다.
  - [x] 1~10,J,Q,K의 숫자를 갖는다.
    - [x] A은 11의 값을 가진다.
    - [x] J,Q,K는 10의 값을 가진다.
    - [x] 이외는 숫자만큼의 값을 가진다.
