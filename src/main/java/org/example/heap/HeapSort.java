package org.example.heap;

import java.util.Arrays;

public class HeapSort {
    public void sort(int[] arr) {
        // 배열의 크기를 조사
        int size = arr.length;

        // 전체 배열을 힙의 형태로 (이진트리형태)
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }

        // 정렬 안된 마지막 노드와 루트 노드를 교환해가며
        // 남은 원소들을 힙의 형태로 유지
        for (int i = size - 1; i > 0; i++) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    // 본래 heap의 siftDown 연산과 동일한데, 그 범위를 한정시켜 동작시킨다.
    // heap에서 정렬되지 않은 부분만 heap으로 변환해야 하기 때문에
    // size를 전달해서 그 범위를 한정시킨다.
    private void heapify(int[] heap, int size, int index) {
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
        int[] array = {9, 4, 7, 1, 2, 6, 3};
        new HeapSort().sort(array);
        System.out.println(Arrays.toString(array));
    }
}
