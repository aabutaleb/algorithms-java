package org.aabutaleb.algorithms.challenges;

import java.util.concurrent.atomic.AtomicInteger;

public class BalancedParenthesis {
    public static void main(String[] args) {
        System.out.println(balancedParenthesis("(1+(2*12))"));
    }

    private static boolean balancedParenthesis(String string) {
        final AtomicInteger count = new AtomicInteger(0);

        string.chars().mapToObj(x -> (char)x).forEach(character -> {
            if (character == '(') count.incrementAndGet();
            else if (character == ')') count.decrementAndGet();
        });

        return count.get() == 0;
    }
}
