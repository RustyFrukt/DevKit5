package ru.geekbrains.seminar_5;


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Fork[] forks = new Fork[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork(i + 1);
        }
        for (int i = 0; i < forks.length; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % 5];
            if (i == 0) {
                philosophers[i] = new Philosopher(rightFork, leftFork, philName.get(i));
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork, philName.get(i));
            }
            Thread thread = new Thread(philosophers[i]);
            thread.start();
        }
    }

    private static final Map<Integer, String> philName = new HashMap<>() {{
        put(0, "Платон");
        put(1, "Аристотель");
        put(2, "Сократ");
        put(3, "Макиавелли");
        put(4, "Кант");
    }};
}
