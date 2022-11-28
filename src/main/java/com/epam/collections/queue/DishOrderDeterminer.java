package com.epam.collections.queue;

import java.util.*;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= numberOfDishes; i++) {
            deque.add(i);
        }

        while (!deque.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int skipNum = everyDishNumberToEat;

            if (everyDishNumberToEat > deque.size()) {
                skipNum = everyDishNumberToEat - deque.size();
                if (deque.size() == 1)
                    skipNum = 1;
            }

            for (int i = 1; i < skipNum; i++) {
                tempList.add(deque.remove());
            }

            list.add(deque.remove());
            deque.addAll(tempList);
        }

        return list;
    }
}
