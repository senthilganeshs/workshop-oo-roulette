package workshop.oo.roulette;

import java.util.Arrays;
import org.junit.Test;

public class BetTest {
  @Test
  public void testStraightBetOnRoulette() {
    Bet bet = Bet.straight(1, 5);
    Roulette roulette = Roulette.american();
    int iter = 380;

    assertWins(roulette, iter, bet, -360);
    assertAmount(roulette, iter, bet, -20);
  }

  @Test
  public void testSplitBetOnRoulette() {
    Bet bet = Bet.split(1, 7, 9);
    Roulette roulette = Roulette.american();
    int iter = 380;

    assertWins(roulette, iter, bet, -340);
    assertAmount(roulette, iter, bet, -20);
  }
/*
  @Test
  public void testStreetBetOnRoulette() {
    Bet bet = Bet.street(1, 7, 9, 11);
    Roulette roulette = Roulette.american();
    int iter = 380;

    assertWins(roulette, iter, bet, -320);
    assertAmount(roulette, iter, bet, -20);

  }

  @Test
  public void testSquareBetOnRoulette() {
    Bet bet = Bet.square(1, 7, 9, 11, 13);
    Roulette roulette = Roulette.american();
    int iter = 380;

    assertWins(roulette, iter, bet, -300);
    assertAmount(roulette, iter, bet, -20);
  }

  @Test
  public void testBasketBetOnRoulette() {
    Bet bet = Bet.basket(1, 1,7, 9, 11, 13);
    Roulette roulette = Roulette.american();
    int iter = 380;

    assertWins(roulette, iter, bet, -280);
    assertAmount(roulette, iter, bet, -30);
  }

  @Test
  public void testDoubleStreetBetOnRoulette() {
    Bet bet = Bet.doubleStreet(1, 1,7, 9, 11, 13, 17);
    Roulette roulette = Roulette.american();
    int iter = 380;

    assertWins(roulette, iter, bet, -260);
    assertAmount(roulette, iter, bet, -20);
  }

  @Test
  public void testDozenBetOnRoulette() {
    Roulette roulette = Roulette.american();
    int iter = 380;

    assertWins(roulette, iter, Bet.dozen(1, 1), -140);
    assertAmount(roulette, iter, Bet.dozen(1, 1), -20);

    assertWins(roulette, iter, Bet.dozen(1, 2), -140);
    assertAmount(roulette, iter, Bet.dozen(1, 2), -20);

    assertWins(roulette, iter, Bet.dozen(1, 3), -140);
    assertAmount(roulette, iter, Bet.dozen(1, 3), -20);
  }

  @Test
  public void testColumnBetOnRoulette() {
    Roulette roulette = Roulette.american();
    int iter = 380;

    assertWins(roulette, iter, Bet.column(1, 1), -140);
    assertAmount(roulette, iter, Bet.column(1, 1), -20);

    assertWins(roulette, iter, Bet.column(1, 2), -140);
    assertAmount(roulette, iter,Bet.column(1, 2), -20);

    assertWins(roulette, iter, Bet.column(1, 3), -140);
    assertAmount(roulette, iter, Bet.column(1, 3), -20);
  }

  @Test
  public void testLowHighBetOnRoulette() {
    Roulette roulette = Roulette.american();
    int iter = 380;

    assertWins(roulette, iter, Bet.low(1), -20);
    assertAmount(roulette, iter, Bet.low(1), -20);

    assertWins(roulette, iter, Bet.high(1), -20);
    assertAmount(roulette, iter,Bet.high(1), -20);
  }

  @Test
  public void testEvenOddBetOnRoulette() {
    Roulette roulette = Roulette.american();
    int iter = 380;

    assertWins(roulette, iter, Bet.even(1), -20);
    assertAmount(roulette, iter, Bet.even(1), -20);

    assertWins(roulette, 380, Bet.odd(1), -20);
    assertAmount(roulette, iter, Bet.odd(1), -20);
  }

  @Test
  public void testRedBlackBetOnRoulette() {
    Roulette roulette = Roulette.american();
    int iter = 380;

    assertWins(roulette, iter, Bet.red(1), -20);
    assertAmount(roulette, iter, Bet.red(1), -20);

    assertWins(roulette, iter, Bet.black(1), -20);
    assertAmount(roulette, iter, Bet.black(1), -20);
  }
*/
  private static void assertWins(Roulette roulette, int iter, Bet bet, int expectedWins) {
    RouletteAsserts.assertWins(roulette, iter, Arrays.asList(bet), expectedWins);
  }

  private static void assertAmount(Roulette roulette, int iter, Bet bet, double expectedAmt) {
    RouletteAsserts.assertAmount(roulette, iter, Arrays.asList(bet), expectedAmt);
  }
}
