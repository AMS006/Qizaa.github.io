import java.util.*;
class pair implements Comparable<pair>{
    int PrNo;
    int pId;
    int at;
    int bt;
    pair(int PrNo , int pId,int at,int bt){
        this.PrNo = PrNo;
        this.pId = pId;
        this.at = at;
        this.bt = bt;
    }
    public int compareTo(pair p){
        if(p.PrNo == PrNo){
           pId = p.pId;
        }
        return p.PrNo-PrNo;
    }
}
public class PrioritySheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Processes");
        int n = sc.nextInt();
        int AT[] = new int[n];
        int BT[] = new int[n];
        int Prio[] = new int[n];
        ArrayList<pair> list = new ArrayList<>();
        System.out.println("Enter Arrival Time, Priority No.,Burst Time ");
        for(int i = 0;i<n;i++){
            AT[i] = sc.nextInt();
            Prio[i] = sc.nextInt();
            BT[i] = sc.nextInt();
            
            list.add(new pair(Prio[i],i+1,AT[i],BT[i]));
        }
        Collections.sort(list);
        int CT[] = new int[n];
        int RT[] = new int[n];
        int TAT[] = new int[n];
        int WT[] = new int[n];
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += list.get(i).bt;
            CT[i] = sum;
            TAT[i] = CT[i] - list.get(i).at;
            WT[i] = TAT[i] - list.get(i).bt;
            RT[i] = sum-list.get(i).bt-list.get(i).at;  
        }
        System.out.println("ProcessId AT BT CT TAT WT RT");
        for(int i = 0;i<n;i++){
            System.out.println(list.get(i).pId+" "+list.get(i).at+" " +list.get(i).bt+" "+ CT[i] + " " + TAT[i] + " " + WT[i]+ " " + RT[i]);
        }
        int avgWT = 0, avgTAT=0,ThroughPut =0;
        for(int i = 0;i<n;i++){
            avgWT += WT[i];
            avgTAT += TAT[i];
        }
        avgTAT = avgTAT/n;
        avgWT = avgWT/n;
        ThroughPut = n/CT[n-1];
    }
}
