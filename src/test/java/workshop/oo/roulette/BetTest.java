package workshop.oo.roulette;

import org.junit.Assert;
import org.junit.Test;

public class BetTest {
  @Test
  public void testStraightBetOnRoulette() {
    assertWins(Roulette.american(), 380, Bet.straight(5), 10);
  }

  @Test
  public void testSplitBetOnRoulette() {
    assertWins(Roulette.american(), 380, Bet.split(7, 9), 20);
  }

  @Test
  public void testStreetBetOnRoulette() {
    assertWins(Roulette.american(), 380, Bet.street(7, 9, 11), 30);
  }

  @Test
  public void testSquareBetOnRoulette() {
    assertWins(Roulette.american(), 380, Bet.square(7, 9, 11, 13), 40);
  }

  @Test
  public void testBasketBetOnRoulette() {
    assertWins(Roulette.american(), 380, Bet.basket(1,7, 9, 11, 13), 50);
  }

  @Test
  public void testDoubleStreetBetOnRoulette() {
    assertWins(Roulette.american(), 380, Bet.doubleStreet(1,7, 9, 11, 13, 17), 60);
  }

  @Test
  public void testDozenBetOnRoulette() {
    assertWins(Roulette.american(), 380, Bet.dozen(1), 120);
    assertWins(Roulette.american(), 380, Bet.dozen(2), 120);
    assertWins(Roulette.american(), 380, Bet.dozen(3), 120);
  }

  @Test
  public void testColumnBetOnRoulette() {
    assertWins(Roulette.american(), 380, Bet.column(1), 120);
    assertWins(Roulette.american(), 380, Bet.column(1), 120);
    assertWins(Roulette.american(), 380, Bet.column(1), 120);
  }

  @Test
  public void testLowHighBetOnRoulette() {
    assertWins(Roulette.american(), 380, Bet.low(), 180);
    assertWins(Roulette.american(), 380, Bet.high(), 180);
  }

  @Test
  public void testEvenOddBetOnRoulette() {
    assertWins(Roulette.american(), 380, Bet.even(), 180);
    assertWins(Roulette.american(), 380, Bet.odd(), 180);
  }

  @Test
  public void testRedBlackBetOnRoulette() {
    assertWins(Roulette.american(), 380, Bet.red(), 180);
    assertWins(Roulette.american(), 380, Bet.black(), 180);
  }

  private void assertWins(Roulette roulette, int iter, Bet bet, int expectedWins) {
    int actualWins = 0;
    while (iter > 0) {
      if (roulette.spin(bet)){
        actualWins++;
      }
      iter--;
    }

    Assert.assertEquals("Got: " + actualWins, expectedWins, actualWins);
  }
}
