import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    private int getParkingTime(String in, String out) {
        String[] inTime = in.split(":");
        String[] outTime = out.split(":");
        int total = 0;
        int inMin = Integer.parseInt(inTime[1]);
        int outMin = Integer.parseInt(outTime[1]);
        if (outMin > inMin) {
            total = (Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0])) * 60;
            total += outMin - inMin;
        } else {
            total = (Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]) - 1) * 60;
            total += 60 - inMin + outMin;
        }
        return total;
    }
                  
    private int calculateParkingFee(int[] fees, int parkingTime) {
        int totalFee = fees[1];
        parkingTime -= fees[0];
        if (parkingTime > 0) {
            totalFee += (parkingTime / fees[2]) * fees[3];
            if (parkingTime % fees[2] > 0) {
                totalFee += fees[3];
            }
        }
        return totalFee;
    }
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> timeRecord = new HashMap<>();
        Map<String, Integer> totalParkingTime = new HashMap<>();
        
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            String time = st.nextToken();
            String num = st.nextToken();
            String cmd = st.nextToken();
            if (cmd.equals("IN")) {
                timeRecord.put(num, time);
            } else {
                String inTime = timeRecord.get(num);
                timeRecord.remove(num);
                int parkingTime = getParkingTime(inTime, time);
                totalParkingTime.put(num, totalParkingTime.getOrDefault(num, 0) + parkingTime);
            }
        }
        for (Map.Entry<String, String> entry : timeRecord.entrySet()) {
            String num = entry.getKey();
            int parkingTime = getParkingTime(entry.getValue(), "23:59");
            totalParkingTime.put(num, totalParkingTime.getOrDefault(num, 0) + parkingTime);
        }
        System.out.println(totalParkingTime);
        ArrayList<String> keys = new ArrayList<>(totalParkingTime.keySet());
        Collections.sort(keys);
        System.out.println(keys);
        int[] answer = new int[totalParkingTime.size()];
        int i = 0;
        for (String key : keys) {
            answer[i++] = calculateParkingFee(fees, totalParkingTime.get(key)); 
        }
        return answer;
    }
}

