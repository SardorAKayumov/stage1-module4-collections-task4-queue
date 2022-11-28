package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> firstDeque = new ArrayDeque<>(firstQueue);
        ArrayDeque<Integer> secondDeque = new ArrayDeque<>(secondQueue);

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(firstDeque.remove());
        deque.offer(firstDeque.remove());
        deque.offer(secondDeque.remove());
        deque.offer(secondDeque.remove());

        while (!firstDeque.isEmpty() && !secondDeque.isEmpty()) {
            firstDeque.offer(deque.removeLast());
            deque.offer(firstDeque.remove());
            deque.offer(firstDeque.remove());

            secondDeque.offer(deque.removeLast());
            deque.offer(secondDeque.remove());
            deque.offer(secondDeque.remove());
        }

        return deque;
    }
}
