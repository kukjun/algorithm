import java.util.StringTokenizer;

class Solution {

    public static int count = 0;


    public int solution(String[][] schedule) {
        // 각 요일 마다 스케줄을 의미있는 값으로 환산
        // 요일을 시간으로 환산해서 계산
        boolean[][] week = new boolean[5][24];
        dfs(schedule, week, 0, schedule.length);
        return count;
    }

    public void dfs(String[][] schedule, boolean[][] week, int depth, int target) {
        if (depth == target) {
            count++;
        } else {
            next:
            for (String lecture : schedule[depth]) {
                if (lecture.length() < 10) {
                    String weekDayString = lecture.substring(0, 2);
                    int weekDay = 0;
                    switch (weekDayString) {
                        case "MO" -> weekDay = 0;
                        case "TU" -> weekDay = 1;
                        case "WE" -> weekDay = 2;
                        case "TH" -> weekDay = 3;
                        case "FR" -> weekDay = 4;
                    }
                    String[] stringTime = lecture.substring(3).replaceAll(" ", "").split(":");
                    int time = (Integer.parseInt(stringTime[0]) - 9) * 2 + (Integer.parseInt(stringTime[1]) / 30);
                    for (int i = 0; i < 6; i++) {
                        if (week[weekDay][time + i]) {
                            continue next;
                        }
                    }
                    for (int i = 0; i < 6; i++) {
                        week[weekDay][time + i] = true;
                    }
                    dfs(schedule, week, depth + 1, target);
                    for (int i = 0; i < 6; i++) {
                        week[weekDay][time + i] = false;
                    }

                } else {
                    String firstLecture = lecture.substring(0, 9);
                    String weekDayString1 = firstLecture.substring(0, 2);
                    int weekDay1 = 0;
                    switch (weekDayString1) {
                        case "MO" -> weekDay1 = 0;
                        case "TU" -> weekDay1 = 1;
                        case "WE" -> weekDay1 = 2;
                        case "TH" -> weekDay1 = 3;
                        case "FR" -> weekDay1 = 4;
                    }
                    String[] stringTime1 = firstLecture.substring(3).replaceAll(" ", "").split(":");
                    int time1 = (Integer.parseInt(stringTime1[0]) - 9) * 2 + (Integer.parseInt(stringTime1[1]) / 30);
                    String secondLecture = lecture.substring(9);

                    String weekDayString2 = secondLecture.substring(0, 2);
                    int weekDay2 = 0;
                    switch (weekDayString2) {
                        case "MO" -> weekDay2 = 0;
                        case "TU" -> weekDay2 = 1;
                        case "WE" -> weekDay2 = 2;
                        case "TH" -> weekDay2 = 3;
                        case "FR" -> weekDay2 = 4;
                    }
                    String[] stringTime2 = secondLecture.substring(3).replaceAll(" ", "").split(":");
                    int time2 = (Integer.parseInt(stringTime2[0]) - 9) * 2 + (Integer.parseInt(stringTime2[1]) / 30);

                    for (int i = 0; i < 3; i++) {
                        if (week[weekDay1][time1 + i]) {
                            continue next;
                        }
                    }
                    for (int i = 0; i < 3; i++) {
                        if (week[weekDay2][time2 + i]) {
                            continue next;
                        }
                    }

                    for (int i = 0; i < 3; i++) {
                        week[weekDay1][time1 + i] = true;
                    }
                    for (int i = 0; i < 3; i++) {
                        week[weekDay2][time2 + i] = true;
                    }
                    dfs(schedule, week, depth + 1, target);
                    for (int i = 0; i < 3; i++) {
                        week[weekDay1][time1 + i] = false;
                    }
                    for (int i = 0; i < 3; i++) {
                        week[weekDay2][time2 + i] = false;
                    }
                }
            }
        }
    }

}
