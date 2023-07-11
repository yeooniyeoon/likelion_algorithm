package org.example.bf;

public class PowerSetIter {
    public static void main(String[] args) {
        int[] set = new int[]{2, 3, 5};
        // 선택 여부를 저장하는 배열
        int[] select = new int[3];

        // set의 각 원소를 선택할까 말까?
        // i == 0이면 첫번째 원소 선택 X
        // i == 1이면 첫번째 원소 선택 O
        for (int i = 0; i < 2; i++) {
            select[0] = i;


            // j ==0이면 두번째 원소 선택 X
            // j ==1이면 두번째 원소 선택 O
            for (int j = 0; j < 2; j++) {
                select[1] = j;


                // k ==0이면 두번째 원소 선택 X
                // k ==1이면 두번째 원소 선택 O
                for (int k = 0; k < 2; k++) {
                    select[2] = k;
                    // select[n]의 값이 1이라면
                    // set[n]의 값을 부분집합에 포함
                    for (int n = 0; n < 3; n++) {
                        if (select[n] == 1)
                            System.out.println(set[n] + " ");
                    }
                    // 가독성을 위한 한줄 출력
                    System.out.println();
                }
            }
        }
    }
}
