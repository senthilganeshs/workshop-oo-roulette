package workshop.oo.roulette;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public interface Roulette {
  boolean spin(Bet bet);

  static Roulette american() {
    return new AmericanRoulette();
  }

  final class AmericanRoulette implements Roulette {

    private final int[] wheel;

    AmericanRoulette() {
      this.wheel = new int[38];
      fill(wheel);
    }

    private void fill(int[] wheel) {
      wheel[0] = 0; //house edge
      wheel[19] = 0; //house edge

      Set<Integer> used = new HashSet<>();
      Random rnd = new Random();
      int size = 0;
      do {
        int num = rnd.nextInt(37);
        if (num == 0 || used.contains(num)) {
          continue;
        }

        if (size == 0 || size == 19)
          size ++; //skip house edge.

        wheel[size] = num;
        size ++;
        used.add(num);
      } while (used.size() < 36);
    }

    @Override
    public String toString() {
      return Arrays.toString(wheel);
    }

    private Random rnd = new Random();
    Set<Integer> usedIndexes = new HashSet<>();

    @Override
    public boolean spin(Bet bet) {
      if (usedIndexes.size() == 38) {
        usedIndexes.clear();
      }

      int index = rnd.nextInt(38);
      while (usedIndexes.contains(index)) {
        index = rnd.nextInt(38);
      }
      usedIndexes.add(index);
      int winner = wheel[index];

      return bet.check(index, winner);
    }
  }

}
