package org.example.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BinaryMaxHeap {
    private int[] heap;
    private int size;

    public BinaryMaxHeap() {
        heap = new int[32];
        size = 0;
    }

    // arr는 힙이 아니라고 가정
    public BinaryMaxHeap(int[] arr) {
        // TODO
        // 주어진 arr를 힙의 형태로 heap에 저장
        heap = Arrays.copyOf(arr, arr.length);
        size = heap.length;
        // 마지막 자식이 존재하는 노드
        int lastIndex = size - 1;
        // 마지막 자식의 부모
        int lastParentIndex = (lastIndex -1 ) / 2;
        // 자식이 존재하는 노드 중에서 가장 나중에 존재하는 노드부터 (가장 아래쪽부터 ..)
        // (마지막 자식의 부모 노드)
        // siftDown을 해주면 된다.
        for (int i = lastParentIndex; i >= 0; i--) {
            siftDown(i);
        }
    }

    // 삽입 연산
    public void insert(int item) {
        heap[size] = item;
        siftUp(size);
        size++;
    }

    // index에 존재하는 원소를 자신의 부모와 비교해서
    // 힙의 조건을 만족시키도록 교환을 반복적으로 진행
    private void siftUp(int index) {
        // 루트 원소가 아닌 동안
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            // 힙의 조건을 만족하는 관계면 반복 중단.
            if (heap[index] <= heap[parentIndex])
                break;

            // 아니면 교환
            int temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;
            index = parentIndex;

        }
    }

    public int remove() {
        // 루트 노드 제거하고
        int root = heap[0];
        // 루트에 마지막 자식 할당
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);

        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void siftDown(int index) {
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            // 최대 원소의 위치 저장됨
            int maxIndex = index;
            // 왼쪽 자식이 존재하며 && 왼쪽 자식의 값이 현재 최대 원소(루트) 보다 큰 경우
            if (leftChild < size && heap[leftChild] > heap[maxIndex]) {
                // 둘을 교환할 준비
                maxIndex = leftChild;
            }
            // 오른쪽도 동일, 이때 왼쪽이 더 컸으면 maxIndex가 갱신되었을 것이고,
            // 아니라면 그대로 루트였을 것이다. 그래서 한번만 비교해도 둘 중 더 큰 것과 비교가 된다.
            if (rightChild < size && heap[rightChild] > heap[maxIndex]) {
                maxIndex = rightChild;
            }

            // 양쪽 자식과 비교했는데
            // 최대값의 위치가 갱신되지 않은 경우
            // 힙의 조건에 부합함.
            if (maxIndex == index) break;

            int temp = heap[index];
            heap[index] = heap[maxIndex];
            heap[maxIndex] = temp;
            index = maxIndex;
        }
    }

    public static void main(String[] args) {
        BinaryMaxHeap maxHeap = new BinaryMaxHeap(
                new int[]{1, 21, 14, 6, 10, 2, 5, 6, 8}
        );
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.remove());
        }

//        BinaryMaxHeap maxHeap = new BinaryMaxHeap();
//        for (int i = 0; i < 32; i++) {
//            maxHeap.insert(i);
//        }
//
//        for (int i = 0; i < 32; i++) {
//            System.out.println(maxHeap.remove());
//        }
//
//        int[] arr = new int[]{3, 4, 0, 5, 1, 2, 8, 6, 9};
//
//        System.out.println("priority queue");
//        // min heap을 사용하는것과 비슷한 PriorityQueue
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        for (int i = 0; i < arr.length; i++) {
//            priorityQueue.offer(i);
//        }
//        while (!priorityQueue.isEmpty()) {
//            System.out.println(priorityQueue.poll());
//        }
//
//        System.out.println("priority queue reverse");
//        // max heap은 Collections.reverseOrder()를 사용할 수 있다.
//        PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>(Collections.reverseOrder());
//        for (int i = 0; i < arr.length; i++) {
//            priorityQueueMax.offer(arr[i]);
//        }
//        while (!priorityQueueMax.isEmpty()) {
//            System.out.println(priorityQueueMax.poll());
//        }
    }
}
