package DukeSpecializationCourse03;


/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester{
    
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
         la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles");
         la.printAll();
    }
    
    public void testUniqIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles/weblog2_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println ("there are  " + uniqueIPs + " IPs");
    }
    
    public void testprintAllHigherThanNum() {
        int num = 200;
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles/short-test_log");
        la.printAllHigherThanNum(num);
    }
    
    public void testprintAllHigherThanNum2() {
        int num = 400;
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles/weblog1_log");
        la.printAllHigherThanNum(num);
    }
    
    public void testuniqueIPVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles/weblog2_log");
        ArrayList<String> IPa = la.uniqueIPVisitsOnDay("Sep 24");
        ArrayList<String> IPb = la.uniqueIPVisitsOnDay("Sep 30");
        System.out.println(IPa.toString());
        System.out.println(IPb.toString());
    }
    
    public void testuniqueIPVisitsOnDay2() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles/weblog2_log");
        ArrayList<String> IP = la.uniqueIPVisitsOnDay("Sep 24");
        System.out.println(IP.size());
        for (int k=0; k<IP.size(); k++) {
            String ipVisit = IP.get(k);
            System.out.println(ipVisit);
        }
    }
    
    public void testcountUniqueIPsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles/short-test_log");
        int countIPs = la.countUniqueIPsInRange(200,299);
        System.out.println("There are " + countIPs + " IPs with status code from 200 to 299");
        countIPs = la.countUniqueIPsInRange(300,399);
        System.out.println("There are " + countIPs + " IPs with status code from 300 to 399");
    }
    
    public void testcountUniqueIPsInRange2() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles/weblog2_log");
        int countIPs = la.countUniqueIPsInRange(400,499);
        System.out.println("There are " + countIPs + " IPs with status code from 400 to 499");
    }
    
    public void testCountsVisitPerIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles/short-test_log");
        HashMap<String,Integer> counts = la.countVisitsPerIP();
        System.out.println(counts);
    }
    
    public void testmostNumberVisitsByIP() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles/weblog2_log");
		System.out.println(la.mostNumberVisitsByIP(la.countVisitsPerIP()));
	}
    
	public void testiPsMostVisits() {
		LogAnalyzer la = new LogAnalyzer();
	    la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles/weblog2_log");
		ArrayList<String> list = la.iPsMostVisits(la.countVisitsPerIP());
		for (int i=0; i< list.size();i++) {
			System.out.print(list.get(i) + " ");
        }
		System.out.println();
	}
	
	public void testiPsForDays() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles/weblog3-short_log");
		HashMap<String, ArrayList<String>> map = la.iPsForDays();
		for (Map.Entry<String, ArrayList<String>> e : map.entrySet()) {
			System.out.println(e.getKey() + " maps to " + e.getValue().size() + " IP address(es)");
		}
	}
	
	public void testdayWithMostIPVisits() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles/weblog2_log");
		HashMap<String, ArrayList<String>> map = la.iPsForDays();
		System.out.println(la.dayWithMostIPVisits(map));
	}
	
	public void testiPsWithMostVisitsOnDay() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_LogFiles/weblog2_log");
		HashMap<String, ArrayList<String>> map = la.iPsForDays();
		System.out.println(la.iPsWithMostVisitsOnDay(map, "Sep 30"));
	}

}
