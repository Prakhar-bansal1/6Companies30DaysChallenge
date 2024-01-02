import java.util.*;
public class HighAccessEmployees {
 
  public static List<String> findHighAccessEmployees(List<List<String>> accessTime) {
    List<String> ans = new ArrayList<>();
    Map<String, List<Integer>> hm = new HashMap<>();
    for(var e : accessTime) {
      String name = e.get(0);
      String time = e.get(1);
      // convert time to minutes
      int empTimes = Integer.valueOf(time.substring(0, 2))*60 
                                     + Integer.valueOf(time.substring(2));
      // add to map if not present already
      hm.computeIfAbsent(name, o -> new ArrayList<>()).add(empTimes);
    }
    for(var e : hm.entrySet()) {
      String name = e.getKey();
      var ts = e.getValue();
      // sort the list
      Collections.sort(ts);
      for(int i=2; i<ts.size(); i++) {
        // if (t3 - t1) < 60, add to ans and break
        if(ts.get(i) - ts.get(i-2) < 60) {
          ans.add(name);
          break;
        }
      }
    }
     return ans;
  }

  public static void main(String args[]) {
      List<List<String>> accessTime = new ArrayList<>();
      List<String> employeeA = new ArrayList<>();
      employeeA.add("a");
      employeeA.add("0549");
      accessTime.add(employeeA);
      
      List<String> employeeB = new ArrayList<>();
      employeeB.add("b");
      employeeB.add("0457");
      accessTime.add(employeeB);
      
      List<String> employeeC = new ArrayList<>();
      employeeC.add("a");
      employeeC.add("0532");
      accessTime.add(employeeC);
      
      List<String> employeeD = new ArrayList<>();
      employeeD.add("a");
      employeeD.add("0621");
      accessTime.add(employeeD);
      
      List<String> employeeE = new ArrayList<>();
      employeeE.add("b");
      employeeE.add("0540");
      accessTime.add(employeeE);

      System.out.println(findHighAccessEmployees(accessTime));
  }
}