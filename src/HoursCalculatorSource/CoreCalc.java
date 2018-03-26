
package HoursCalculatorSource;

import java.util.prefs.Preferences;

/**
 *
 * @author Sergiu Borlovan
 */

public class CoreCalc {
    
    private int DS;
    private int ND;
    private int SI;
    private int topUp;
    private int hols;
    private double contractHrs;
    private double hourlyRate;
    private double topUpRate;
    private double sleepInRate;
    private double onCallRate;
    
  Preferences systemPref = Preferences.userRoot(); 

    public CoreCalc() {
        this.DS = systemPref.getInt("DS", 12);
        this.ND = systemPref.getInt("ND", 12);
        this.SI = systemPref.getInt("SI", 16);
        this.topUp = systemPref.getInt("topUp", 8);
        this.hols = systemPref.getInt("hols", 7);
        this.contractHrs = systemPref.getDouble("contractHrs", 151.5);
        this.hourlyRate = systemPref.getDouble("hourlyRate", 7.50);
        this.topUpRate = systemPref.getDouble("topUpRate", 7.50);
        this.sleepInRate = systemPref.getDouble("sleepInRate", 29.95);
        this.onCallRate = systemPref.getDouble("onCallRate", 9.95);
    }
    
    public double getSleepInRate() {
        double result = systemPref.getDouble("sleepInRate", sleepInRate);
        return result;
    }

    public void setSleepInRate(double d) {
        sleepInRate = d;
        systemPref.putDouble("sleepInRate", d);
    }

    public double getOnCallRate() {
        double result = systemPref.getDouble("onCallRate", onCallRate);
        return result;
    }

    public void setOnCallRate(double d) {
        onCallRate = d;
        systemPref.putDouble("onCallRate", d);
    }

    public double getContractHrs() {
        double result = systemPref.getDouble("contractHours", contractHrs);
        return result;
    }

    public void setContractHrs(double d) {
        onCallRate = d;
        systemPref.putDouble("contractHrs", d);
    }

    public double getHourlyRate() {
        double result = systemPref.getDouble("hourlyRate", hourlyRate);
        return result;
    }

    public void setHourlyRate(double d) {
        hourlyRate = d;
        systemPref.putDouble("hourlyRate", d);
    }

    public double getTopUpRate() {
        double result = systemPref.getDouble("topUpRate", topUpRate);
        return result;
    }

    public void setTopUpRate(double d) {
        topUpRate = d;
        systemPref.putDouble("topUpRate", d);
    }

    
    public int getDS() {
        int result = systemPref.getInt("DS", DS);
        return result;
    }

    public void setDS(int i) {
        DS = i;
        systemPref.putInt("DS", i);
    }

    public int getND() {
        int result = systemPref.getInt("ND", ND);
        return result;
    }

    public void setND(int i) {
        ND = i;
        systemPref.putInt("ND", i);
    }

    public int getSI() {
        int result = systemPref.getInt("SI", SI);
        return result;
    }

    public void setSI(int i) {
        SI = i;
        systemPref.putInt("SI", i);
    }

    public int getHols() {
        int result = systemPref.getInt("hols", hols);
        return result;
    }

    public void setHols(int i) {
        hols = i;
        systemPref.putInt("hols", i);
    }
    
    public int calculateDS(String s){
       int amount = checkNum(s);
       return amount * DS;
    }
    
    public int calculateND(String s){
       int amount = checkNum(s);
       return amount * ND;   
    }
    
    public int calculateSI(String s){
       int amount = checkNum(s);
       return amount * SI;   
    }
    
    public int calculateTopUp(String s){
       int amount = checkNum(s);
       return amount * topUp; 
    }
    public int calculateOnCall(String s){
       int amount = checkNum(s);
       return amount;
    }
    public double calculateAddHrs(String s){
       double amount = checkNum(s);
       return amount;
    }
    public int calculateHols(String s){
        int amount = checkNum(s);
        return amount * hols;
    }
    public double calculateOvertime(double d){
        if (d <= contractHrs){
            return 0;
        }
        else{
            return d - contractHrs;
        }
    }
    
    public double calculatePay(double tHrs, int tSI, int tOC, double tUp){
        double totalHoursPay = tHrs * hourlyRate;
        double totalSIPay = tSI * sleepInRate;
        double totalOCPay = tOC * onCallRate;
        double totalTopUp = tUp * topUpRate;
        double finalTopUp = totalTopUp - totalSIPay;
        
        double totalPay = totalHoursPay + totalSIPay + totalOCPay + finalTopUp;
        return totalPay;
    }
    public int checkNum(String s){
        if (s.isEmpty()){
            return 0;
        }
        else{
            return Integer.parseInt(s);
        }
    }
    
    public void retrievePreferences(){
        
    }
}
