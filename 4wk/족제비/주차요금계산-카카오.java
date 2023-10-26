import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 주차요금계산 {
  
  //https://school.programmers.co.kr/learn/courses/30/lessons/92341

  public static void main(String[] args) {
    int[] fees = {180, 5000, 10, 600};
    String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

    int time = 0;
    int number = 1;
    int type = 2;

    Map<String, String> inTime = new HashMap<>();
    Map<String, Integer> totalTime = new HashMap<>();

    for (String record : records) {
      String[] r = record.split(" ");
      if (r[type].equals("IN")) {
        inTime.put(r[number], r[time]);
      } else {
        totalTime.put(r[number], totalTime.getOrDefault(r[number], 0) + getTimeDiff(inTime.get(r[number]), r[time]));
        inTime.remove(r[number]);
      }
    }

    for (String key : inTime.keySet()) {
      totalTime.put(key, totalTime.getOrDefault(key, 0) + getTimeDiff(inTime.get(key), "23:59"));
    }

    List<String> keys = new ArrayList<>(totalTime.keySet());
    Collections.sort(keys);

    int[] answer = new int[keys.size()];
    int i = 0;
    for (String key : keys) {
      answer[i++] = calcFee(totalTime.get(key), fees);
    }

    System.out.println(Arrays.toString(answer));
  }

  public static int calcFee(int totalTime, int[] fees) {
    int time = totalTime - fees[0];
    int fee = fees[1];

    if(time <= 0) {
      return fee;
    }

    time = time % fees[2] != 0 ? time / fees[2] + 1 : time / fees[2];
    fee += time * fees[3];

    return fee;
  }

  public static int getTimeDiff(String inTime, String outTime) {
    return timeToMinute(outTime) - timeToMinute(inTime);
  }

  public static int timeToMinute(String time) {
    String t[] = time.split(":");
    return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
  }
}
