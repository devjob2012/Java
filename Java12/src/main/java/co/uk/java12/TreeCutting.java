package co.uk.java12;

import java.util.Arrays;

public class TreeCutting {
    public static void main(String[] args) {
        TreeCutting tc = new TreeCutting();
        int[] treeHeight = new int[]{3, 4, 5, 3, 7};
        int[] treeHeightLast = new int[]{3, 4, 2, 3, 7};
        int[] treeNoHeight = new int[]{1, 2, 3, 4, 2, 5};
        int[] treeHeightAlready = new int[]{1, 3, 3, 2};
        int[] treeBigHeightLast = new int[]{1, 3, 4, 1, 3, 2, 3, 3, 4};

        System.out.println(tc.solution(treeHeightAlready));
//        System.out.println(tc.solution(treeBigHeightLast));
//        Assert.assertEquals(3, tc.solution(treeHeight));
//        Assert.assertEquals(3, tc.solution(treeHeightLast));
//        Assert.assertEquals(-1, tc.solution(treeNoHeight));
//        Assert.assertEquals(0, tc.solution(treeHeightAlready));
    }

    public int solution(int[] treeHeight) {
        int num = -1;
        int possibleWays = 0;
        if (isTreePatternAesthetical(processTreePattern(treeHeight))) {
            return 0;
        }

        for (int i = 0; i < treeHeight.length; i++) {
            int[] tempTreePattern = newTreePAttern(treeHeight, i);
            int[] tempTreeSequence = processTreePattern(tempTreePattern);
            if (isTreePatternAesthetical(tempTreeSequence)) {
                possibleWays++;
            }
        }
        if (possibleWays == 0) {
            return num;
        }
        return possibleWays;
    }

    private int[] newTreePAttern(int[] treeHeight, int index) {
        int[] newTreePattern = new int[treeHeight.length - 1];
        int temp = 0;
        for (int i = 0; i < treeHeight.length; i++) {
            if (i != index) {
                newTreePattern[temp++] = treeHeight[i];
            }
        }
        return newTreePattern;
    }

    private int[] processTreePattern(int[] treeHeight) {
        int[] tempTreeHeight = new int[treeHeight.length - 1];
        for (int i = 0; i < treeHeight.length - 1; i++) {
            if (treeHeight[i] < treeHeight[i + 1]) {
                tempTreeHeight[i] = -1;
            } else {
                tempTreeHeight[i] = 0;
            }
        }
        return tempTreeHeight;
    }

    private boolean isTreePatternAesthetical(int[] tempTreeHeight) {
        Arrays.stream(tempTreeHeight).forEach(System.out::println);
        System.out.println("=====");
        for (int i = 0; i < tempTreeHeight.length - 1; i++) {
            if ((tempTreeHeight[i] == -1 && tempTreeHeight[i + 1] == -1) || (tempTreeHeight[i] == 0 && tempTreeHeight[i + 1] == 0)) {
                return false;
            }
        }
        return true;
    }
}
