
package InterviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
     
    public static void main(String[] args) {
    Time a1 = new Time(10,11);
    Time a2 = new Time(11,12);
    Time a3 = new Time(15,16);

    List<Time> aTimes = new ArrayList();
    aTimes.add(a1);
    aTimes.add(a2);
    aTimes.add(a3);
    
    // Person B's Schedule
    Time b1 = new Time(10,11);
    Time b2 = new Time(13,14);
    Time b3 = new Time(16,17);
    List<Time> bTimes = new ArrayList();
    aTimes.add(b1);
    aTimes.add(b2);
    aTimes.add(b3);
    
    List<List<Time>> busyTimes = new ArrayList();
    busyTimes.add(aTimes);
    busyTimes.add(bTimes);
    
    // Print time slots when everyone is free.
    System.out.println(findFreeTime(busyTimes, 9, 19));
        
    }
    public static List<Time> findFreeTime(List<List<Time>> times, int dayStart, int dayEnd) {
    List<Time> freeTimes = new ArrayList();
    for(int i = dayStart; i < dayEnd; i++) {
      freeTimes.add(new Time(i, i+1));
    }
    
    
    // Loop through all people
    for(List<Time> onePersonsTime : times) {
     
      // Loop through each person's time
      for(Time busyTime : onePersonsTime) {
        if(freeTimes.contains(busyTime)) {
          freeTimes.remove(freeTimes.indexOf(busyTime));
        }
      }
    }

    
    return freeTimes;
  }
}
class Time {
    final int start;
    final int end;

    public Time(int s, int e) {
        start = s;
        end = e;
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Time)) {
            return false;
        }

        Time time = (Time) o;
        return start == time.start && end == time.end;
    }

    @Override public int hashCode() {
        return 31 * start + end;
    }

    @Override public String toString() {
        return "Time{" +
            "start=" + start +
            ", end=" + end +
            '}';
    }
}
