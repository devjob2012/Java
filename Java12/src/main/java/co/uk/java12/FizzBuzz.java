package co.uk.java12;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FizzBuzz {
    private static int[] A = {1, 3, 6, 4, 1, 2};
    private static int[] AA = {1, 2, 3};
    private static int[] AAA = {-1, -3};
    int[] AP = {-5, 1, 2, 3, 4, 6, 7, 8, 9, 5};


    public static void main(String[] args) {
        int[] AP = {-5, 1, 2, 3, 4, 6, 7, 8, 9, 5};

        FizzBuzz fb = new FizzBuzz();

        Map<String, UserStats> visits = new HashMap<>();

        UserStats userDetails = new UserStats();
        Optional<Long> counts = Optional.of(12L);
        userDetails.setVisitCount(counts);

        UserStats userDetails1 = new UserStats();
        Optional<Long> counts1 = Optional.of(72L);
        userDetails1.setVisitCount(counts1);

        visits.put("2", userDetails);
        visits.put("we", userDetails);
        visits.put("", null);
        visits.put("2", userDetails1);

        fb.countJava8(visits);


        fb.countJava8(null);
    }


    Map<Long, Long> countJava8(Map<String, UserStats>... visits) {
        Map<Long, Long> visitCountMap = new HashMap<>();
        String regex = "\\d+";
        long uniqueUserId = 0;
        long existedVisit = 0;
        if (visits != null) {
            Arrays.stream(visits).forEach(stringUserStatsMap -> {
                stringUserStatsMap.keySet().stream().filter(s -> s.matches(regex)).mapToLong(Long::parseLong)
                .collect(Collectors.toMap(Function.identity(),key->stringUserStatsMap.get(key)))

                ;
            });

        }
        return visitCountMap;
    }

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> visitCountMap = new HashMap<>();
        String regex = "\\d+";
        long uniqueUserId = 0;
        long existedVisit = 0;
        if (visits != null) {
            for (Map<String, UserStats> visit : visits) {

                System.out.println(visit);
                if (visit != null && visit.size() > 0) {
                    for (String userId : visit.keySet()) {
                        existedVisit = 0;
                        if (userId.matches(regex)) {
                            uniqueUserId = Long.parseLong(userId);
                            System.out.println("uniqueUserId  " + uniqueUserId);
                            if (visitCountMap.get(uniqueUserId) != null) {
                                existedVisit = visitCountMap.get(uniqueUserId);
                                System.out.println("existedVisit  " + existedVisit);
                            }
                            UserStats userStat = visit.get(userId);
                            if (userStat != null && userStat.getVisitCount().isPresent()) {
                                long visitsPerWebService = userStat.getVisitCount().get();
                                System.out.println("visitsPerWebService  " + visitsPerWebService);
                                System.out.println("existedVisit  + visitsPerWebService " + existedVisit + " + " + visitsPerWebService);
                                visitCountMap.put(uniqueUserId, existedVisit + visitsPerWebService);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(visitCountMap);
        return visitCountMap;
    }


    public int solution(int[] A) {

        boolean[] temp = new boolean[A.length];
        int[] newTemp = new int[A.length];
        int trimTree = 0;
        int trimTree1 = 0;

        for (int i = 0; i < A.length - 1; i++) {
            newTemp[i] = A[i] - A[i + 1];
            if (i % 2 == 0) {
                temp[i] = true;
                temp[i + 1] = false;
            } else {
                temp[i] = false;
                temp[i + 1] = true;
            }
        }

        for (int j = 0; j < newTemp.length - 1; j++) {

            if ((newTemp[j] < 0 && temp[j]) || (newTemp[j] > 0 && temp[j + 1])) {
                trimTree++;
            }

        }


        return trimTree;
    }


}


//    int[] temp = new int[A.length];
//    int[] newTemp = new int[A.length];
//    int trimTree =0;
//        for (int i = 0; i < A.length - 1; i++) {
//        newTemp[i] = A[i] - A[i + 1];
//        }
//        for (int j = 0; j < newTemp.length - 1; j++) {
//        if ( (newTemp[j] < 0 && newTemp[j + 1] < 0) || (newTemp[j] > 0 && newTemp[j + 1] > 0)) {
//        trimTree++;
//        }
//        }
//
//        return trimTree;