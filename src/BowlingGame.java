public class BowlingGame {

  private int currentRoll = 0;
  private int[] rolls = new int[21];

  public void roll(int pins) {
    rolls[currentRoll++] = pins;
  }

  public int score() {
    int score = 0;
    int rollIndex = 0;

    for (int frameIndex = 0; frameIndex < 10; frameIndex++) {
      if (isStrike(rolls[rollIndex])) {
        score += strikeScore(rollIndex);
        rollIndex++;
      } else if (isSpare(rollIndex)) {
        score += spareScore(rollIndex);
        rollIndex += 2;
      } else {
        score += currentScore(rollIndex);
        rollIndex += 2;
      }
    }

    return score;
  }

  private int currentScore(int rollIndex) {
    return rolls[rollIndex] + rolls[rollIndex + 1];
  }

  private boolean isSpare(int rollIndex) {
    return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
  }

  private int spareScore(int rollIndex) {
    return rolls[rollIndex] + rolls[rollIndex + 1] + rolls[rollIndex + 2];
  }

  private boolean isStrike(int roll) {
    return roll == 10;
  }

  private int strikeScore(int rollIndex) {
    return rolls[rollIndex] + rolls[rollIndex + 1] + rolls[rollIndex + 2];
  }
}